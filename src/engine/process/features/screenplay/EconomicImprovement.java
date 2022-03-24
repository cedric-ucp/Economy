package engine.process.features.screenplay;

import engine.config.Config;
import engine.data.economy.Economy;
import engine.data.infrastructures.Transport;
import engine.data.map.Continent;
import engine.data.map.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Contains all methods for the economic improvement</b>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 1.0
 */

public class EconomicImprovement {
    private Continent continent ;
    private final List <Country> countries = new ArrayList <> () ;


    /**
     * EconomicImprovement constructor
     * @param continent {Continent}
     */
    public EconomicImprovement (Continent continent) {
        this.continent = continent ;
    }

    /**
     * check if a country already in @see countries
     * @param country {Country}
     * @return {boolean}
     */
    public boolean countryExistInList (Country country){
        if (countries.isEmpty ()){
            return false ;
        }
        else{
            for (Country country1 : countries){
                if (country1.equals (country)){
                    return true ;
                }
            }
        }
        return false ;
    }

    /**
     * add a country to country's improvement list
     * @param country {Country}
     */
    public void addCountryInvolved (Country country){
        if (!countryExistInList (country)){
            countries.add (country) ;
        }
    }

    /**
     *  trade simulation between countries in @see countries
     */
    public void countryTrade (){
       try {
            for (Country country : countries) {
                Economy economy = country.getEconomy();
                List<Transport> transports = economy.getTransports();
                double traffic = 0;

                for (Transport transport : transports) {
                    traffic = transport.getTraffic();
                    traffic = traffic + Config.getRandomNumberDouble(0.0, 0.3);
                    transport.setTraffic(traffic);
                }
                long pib = economy.getPib () ;
                pib += pib * traffic ;
                economy.setPib (pib) ;
            }
        }
       catch (NullPointerException nullPointerException){
           System.err.println ("Country involved List is empty") ;
       }
    }

    /**
     * improvement infrastructure simulation for countries in @see countries
     */
    public void infrastructureImprovement (){
        try {
            for (Country country : countries) {
                Economy economy = country.getEconomy();
                List<Transport> transports = economy.getTransports();
                /*
                  for all country's transport, transport's costBuilding is updated
                  and if the transport infrastructure wasn't modern, its updated
                 */
                for (Transport transport : transports) {
                    long costBuilding = transport.getCostBuilding ();
                    costBuilding += costBuilding * transport.getTraffic () ;
                    transport.setCostBuilding (costBuilding) ;
                    boolean modern = transport.isModern() ;

                    if (!modern) {
                        transport.setModern (true) ;
                    }
                }
            }
        }
        catch (NullPointerException nullPointerException){
            System.err.println ("Country involved List is empty") ;
        }
    }

    /**
     * aid between countries simulation for countries in @see countries
     */
    public void aidBetweenCountries (){
       try {
            int sizeList = countries.size();
            long[] modified = new long[sizeList];
            int i = 0;
            //we recuperate and stock every country's pib
            for (Country country : countries) {
                Economy economy = country.getEconomy();
                modified[i] = economy.getPib();
                i++;
            }

            /*
              modification of the gross domestic product by a
              random country according to a random coefficient
             */
            for (int c = 0; c < modified.length; c++) {
                int randomIndex = Config.getRandomNumber(0, modified.length - 1);
                modified[c] += modified[randomIndex] * Config.getRandomNumberDouble(0.1, 0.2);
            }

            //country's pib update
            i = 0;
            for (Country country : countries) {
                Economy economy = country.getEconomy();
                economy.setPib(modified[i]);
                i++;
            }
        }
       catch (NullPointerException nullPointerException){
           System.err.println ("Country involved List is empty") ;
       }
    }

    public void setContinent (Continent continent) {
        this.continent = continent ;
    }

    public Continent getContinent () {
        return continent ;
    }
}
