package test;
import engine.config.Config;
import engine.data.map.Country;
import engine.process.features.mainFeatures.CountryInfo;
import engine.process.features.mainFeatures.CountryStats;
import engine.process.initialisation.LoadSimulation;

import java.util.Map;


public class Main {

    public static void main (String[] args) {
        /*-------------------------------------------------Demo-------------------------------------------*/

        System.out.println ("\n\n--------------------------Test Simulation----------------------------\n\n");
        LoadSimulation loadSimulation = new LoadSimulation () ;
        loadSimulation.buildContinent () ;

        System.out.println ("\n\n--------------------------Test Infos Pays----------------------------\n\n");
        Map <Config.countryName, Country> countries = loadSimulation.getContinent ().getCountries () ;
        for (Country country : countries.values ()){
            CountryInfo countryInfo = new CountryInfo (country) ;
            System.out.println (countryInfo) ;
        }

        System.out.println ("\n\n--------------------------Test Country Stats---------------------------\n\n") ;
        for (Country country : countries.values ()){
            CountryStats countryStats = new CountryStats (country) ;
            System.out.println (countryStats) ;
        }
        System.out.println("Test Git 222dazdaq");
    }
}
