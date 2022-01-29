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

/**
 *
 */
public class LoadSimulation {
   Continent continent ;
   Economy economy ;

   public void buildEconomy (){
       economy = new Economy (Config.getRandomNumber (100000 , 500000) , Config.getRandomNumberDouble
               (-2.0 , 2.0) , Config.getRandomNumber (100000 , 200000)) ;
       buildTransportEconomy() ;
       for (int i = 0 ; i < Config.maxCompany ; i++){
           economy.addCompany (buildCompany ()) ;
       }
   }

   public void buildTransportEconomy(){
       for (int i = 0 ; i < 3 ; i++){
           switch (Config.getRandomNumber (0 , 3)) {
               case 0 :
                   int mileage = Config.getRandomNumber (20000 , 70000) ;
                   economy.addTransport (new Road ("Road", i <= 1,
                           Config.getRandomNumberLong (30000, 450000), Config.getRandomNumberDouble (0.0 , 1.0) ,
                           mileage , (double) Config.countryArea / mileage)) ;
                   break ;
               case 1 :
                   economy.addTransport (new Airport("Airport", i <= 1,
                           Config.getRandomNumberLong (30000, 450000), Config.getRandomNumberDouble (0.0 , 1.0) ,
                          Config.getRandomNumber (1 , 8))) ;
                   break ;
               case 2 :
                   economy.addTransport (new Port("Port", i <= 1,
                           Config.getRandomNumberLong (30000, 450000), Config.getRandomNumberDouble (0.0 , 1.0) ,
                           Config.getRandomNumber (2 , 8))) ;
                   break ;
               default :
                   break ;
           }
       }

   }

   public Company buildCompany (){
       Config.diffSector [] sectors = Config.diffSector.values () ;
       int index = Config.getRandomNumber (0 , sectors.length - 1) ;

       return new Company (Config.getRandomNumber (200 , 1000) , sectors [index] ,
               Config.getRandomNumberLong (100000 , 1000000) , Config.getRandomNumber (4 , 10)) ;
   }

    public Resource buildResource (){
        Config.typeResource [] resources = Config.typeResource.values () ;
        int index = Config.getRandomNumber (0 , resources.length - 1) ;
        return new Resource (resources [index] , Config.getRandomNumberDouble (0.0 , 0.7)) ;
    }

   public Country buildCountry (){
       Config.countryName[] countryNames = Config.countryName.values () ;
       int index = Config.getRandomNumber (0 , countryNames.length - 1) ;
       buildEconomy () ;
       buildTransportEconomy() ;
       Country country = new Country (Config.getRandomNumberLong (100000 , 200000) , countryNames [index] ,
               economy , Config.countryArea) ;

       index = Config.getRandomNumber (1 , 8) ;
       for (int i = 0 ; i < index ; i++){
           country.addResources (buildResource ()) ;
       }
       return country ;
   }



   public void buildContinent (){
       continent = new Continent (1, "CONTINENT") ;
       int numberCountry = continent.getNumberCountry () ;
       for (int i = 0 ; i < numberCountry ; i++){
           continent.addCountry (buildCountry ()) ;
       }
       System.out.println (continent.toString ()) ;
   }

    public Continent getContinent () {
        return continent ;
    }

    public Economy getEconomy () {
        return economy ;
    }
}
