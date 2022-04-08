package test;
import engine.data.map.Country;
import engine.process.features.mainFeatures.CountryInfo;
import engine.process.features.screenplay.EconomicImprovement;
import engine.process.initialisation.LoadSimulation;

import java.util.Map;


public class Main {

    public static void main (String [] args) {
        /*--------------------------------------------Demo-------------------------------------------*/

        System.out.println ("\n\n--------------------------Test Simulation----------------------------\n\n") ;
        LoadSimulation loadSimulation = new LoadSimulation () ;
        loadSimulation.buildContinent () ;

        System.out.println ("\n\n--------------------------Test Infos Pays-----------------------------\n\n") ;
        Map <String , Country> countries = loadSimulation.getContinent ().getCountries () ;
        System.out.println("taille dico : " + countries.size());
        CountryInfo countryInfo ;
        for (Country country : countries.values ()){
            countryInfo = new CountryInfo (country) ;
            System.out.println (countryInfo) ;
        }

        EconomicImprovement economicImprovement = new EconomicImprovement (loadSimulation.getContinent ()) ;
        for (Country country : countries.values ()){
            economicImprovement.addCountryInvolved (country) ;
        }
        //Vous pouvez tester les differentes ameliorations de l'economie possibles
        economicImprovement.aidBetweenCountries ();
        for (Country country : countries.values ()){
            countryInfo = new CountryInfo (country) ;
            System.out.println (countryInfo) ;
        }
    }
}
