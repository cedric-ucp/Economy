package test;
import engine.config.Config;
import engine.data.map.Country;
import engine.process.features.mainFeatures.CountryInfo;
import engine.process.features.mainFeatures.CountryStats;
import engine.process.features.screenplay.WarSimulation;
import engine.process.initialisation.LoadSimulation;

import java.util.Map;


public class Main {

    public static void main (String[] args) {
        /*-------------------------------------------------Demo-------------------------------------------*/

        System.out.println ("\n\n--------------------------Test Simulation----------------------------\n\n") ;
        LoadSimulation loadSimulation = new LoadSimulation () ;
        loadSimulation.buildContinent () ;

        System.out.println ("\n\n--------------------------Test Infos Pays-----------------------------\n\n") ;
        Map<String, Country> countries = loadSimulation.getContinent ().getCountries () ;
        System.out.println("taille dico : " + countries.size());
        CountryInfo countryInfo ;
        for (Country country : countries.values ()){
            countryInfo = new CountryInfo (country) ;
            System.out.println (countryInfo) ;
        }

        System.out.println ("\n\n--------------------------Test Country Stats---------------------------\n\n") ;
        for (Country country : countries.values ()){
            CountryStats countryStats = new CountryStats (country) ;
            System.out.println (countryStats) ;
        }
        System.out.println ("\n\n--------------------------Test WarSimulation--------------------------$$-\n\n") ;
        System.out.println("TAILLE DICO : " + countries.size ());

        for (Country country : countries.values ()) {
            WarSimulation warSimulation = new WarSimulation (country) ;
            warSimulation.changeEconomyCountry (false) ;
            countryInfo = new CountryInfo (country) ;
            System.out.println (countryInfo) ;
        }



    }
}
