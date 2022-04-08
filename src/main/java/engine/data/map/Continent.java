package engine.data.map;

import engine.config.Config;

import java.util.HashMap;
import java.util.Map;

/**
 *<b>create Continent object</b>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 1.0
 */
public class Continent {
    private final String continentName ;
    private final Map <String , Country> countries = new HashMap <> () ;
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

    public Map <String , Country> getCountries() {
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
