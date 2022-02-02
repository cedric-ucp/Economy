package engine.data.map;

import engine.config.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * @class
 * @classdesc create Continent object
 */
public class Continent {
    private final String continentName ;
    private final Map <Config.countryName , Country> countries = new HashMap <> () ;
    private final int numberCountry ;

    /**
     * Continent constructor
     * @param numberCountry {Integer}
     * @param continentName {String}
     */
    public Continent (int numberCountry , String continentName){
        this.continentName = continentName ;
        this.numberCountry = numberCountry ;
    }

    public Map <Config.countryName , Country> getCountries() {
        return countries ;
    }

    /**
     * add country object in countries dictionary
     * @param country {Country}
     */
    public void addCountry (Country country){
        countries.put (country.getCountryName () , country) ;
    }

    public int getNumberCountry() {
        return numberCountry;
    }

    public String toString() {
        return "\nContinent{" +
                "\n\tcontinentName = " + continentName + '\'' +
                "\n\tnumberCountry = " + numberCountry + "\n" +
                countries +
                '}';
    }
}
