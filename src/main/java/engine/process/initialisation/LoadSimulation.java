package engine.process.initialisation;

import engine.config.Config;
import engine.data.economy.Company;
import engine.data.economy.Economy;
import engine.data.economy.Resource;
import engine.data.infrastructures.Airport;
import engine.data.infrastructures.Port;
import engine.data.infrastructures.Road;
import engine.data.map.Continent;
import engine.data.map.Country;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>LoadSimulation concentrates all methods which generate the continent
 * and all his countries and derived.</b>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 3.0
 */
public class LoadSimulation {
    /**
     * attributes of the class
     * continent and economy
     */
   private Continent continent ;
   private Economy economy ;
   private final Map<Config.typeResource , Resource> resources = new HashMap <> () ;

    /**
     * allows the creation of transport infrastructures for every country randomly %%
     */
    public void buildTransportEconomy(){
        for (int i = 0 ; i < 3 ; i++){
            switch (Config.getRandomNumber (0, 3)){
                case 0 : {
                    int mileage = Config.getRandomNumber (20000, 70000);
                    economy.addTransport (new Road ("Road", i <= 1,
                            Config.getRandomNumberLong (30000, 450000), Config.getRandomNumberDouble (0.0, 1.0) ,
                            mileage , (double) Config.countryArea / mileage)) ;
                }
                case 1 : economy.addTransport (new Airport("Airport", i <= 1,
                        Config.getRandomNumberLong (30000, 450000), Config.getRandomNumberDouble (0.0, 1.0),
                        Config.getRandomNumber (1, 8))) ;
                case 2 : economy.addTransport (new Port ("Port", i <= 1,
                        Config.getRandomNumberLong (30000, 450000) , Config.getRandomNumberDouble (0.0, 1.0) ,
                        Config.getRandomNumber (2, 8))) ;
                default : {
                }
            }
        }

    }

    /**
     * Creation of a company based on statics numbers.
     * @return object {Company}
     */
   public Company buildCompany (){
       Config.diffSector [] sectors = Config.diffSector.values () ;
       int index = Config.getRandomNumber (0 , sectors.length - 1) ;

       return new Company (Config.getRandomNumber (200 , 1000) , sectors [index].name () ,
               Config.getRandomNumberLong (100000 , 1000000) , Config.maxCompany ) ;
   }

    /**
     * Creation of different types of resources for a country based on static
     * data that could be modified
     */
    public void buildResource (){
        Config.typeResource [] resourcesType = Config.typeResource.values () ;
        int total = Config.getRandomNumber (1 , 8) ;
        int i = 0 ;
        while (i < total){
            int index = Config.getRandomNumber (0 , resourcesType.length - 1) ;
            Resource resource = new Resource (resourcesType [index] , Config.getRandomNumberDouble (0.0 , 0.7) , Config.getRandomNumberLong (250000 , 400000)) ;
            resources.put (resourcesType [index] , resource) ;
            i++ ;
        }
    }

    /**
     * used to calculate total production amount of a resource in a country
     * @return totalProductionAmount {long}
     */
    public long getTotalProductionAmount (){
        long totalProductionAmount = 0 ;
        for (Resource resource : resources.values ()){
            totalProductionAmount += resource.getProductionAmount () ;
        }
        return totalProductionAmount ;
    }

    /**
     * used to build object Economy with aspects that concerns it
     */
    public void buildEconomy (){
        economy = new Economy (Config.getRandomNumberDouble
                (-2.0 , 2.0) , Config.getRandomNumber (100000 , 200000)) ;
        buildTransportEconomy () ;
        long allCompanyTurnover = 0 ;
        for (int i = 0; i < Config.maxCompany ; i++){
            Company company = buildCompany () ;
            economy.addCompany (company) ;
            allCompanyTurnover += company.getTurnover () ;
        }
        long pib = allCompanyTurnover + getTotalProductionAmount () ;
        economy.setPib (pib) ;
    }

    /**
     * Building of a country object with all intel associated.
     * @return country {Country}
     */
   public Country buildCountry (){
       Config.countryName[] countryNames = Config.countryName.values () ;
       int index = Config.getRandomNumber (0 , countryNames.length) ;
       buildEconomy () ;
       buildResource () ;
       Country country = new Country (Config.getRandomNumberLong (5200000 , 1000000) , countryNames [index].name () ,
               economy , Config.countryArea) ;
       country.setResources (resources) ;
       resources.clear () ;

       return country ;
   }

    /**
     * Verify that a country doesn't already exits in a continent by using
     * country's name
     * @param continent {Continent}
     * @param country {Country}
     * @return {boolean}
     */
   public boolean countryExitsInContinent (Continent continent , Country country){
      for (Country currentCountry : continent.getCountries ().values ()){
          if (currentCountry.getCountryName ().equals (country.getCountryName ())){
              return true ;
          }
      }
      return false ;
   }

    /**
     * Building of a Continent Object with all his countries and informations
     * associated
     */
   public void buildContinent (){
       continent = new Continent (Config.maxCountry , "CONTINENT") ;
       int numberCountry = continent.getNumberCountry () ;
       for (int i = 0 ; i < numberCountry ; i++){
           Country country = buildCountry () ;
           while (countryExitsInContinent (continent , country)) {
               country = buildCountry () ;
//               System.out.println(country.getCountryName()) ;
           }
           continent.addCountry (country) ;
       }

   }

    public Continent getContinent () {
        return continent ;
    }

    public Economy getEconomy () {
        return economy ;
    }
}
