package engine.data.map;

import engine.config.Config;

import java.util.HashMap;
import java.util.Map;

public class Continent {
    private String continentName ;
    private final Map <Config.countryName , Country> countries = new HashMap <> () ;
    private final int numberCountry ;

    public Continent (int numberCountry , String continentName){
        this.continentName = continentName ;
        this.numberCountry = numberCountry ;
    }

    public Map <Config.countryName , Country> getCountries() {
        return countries ;
    }

    public void addCountry (Country country){
        countries.put (country.getCountryName () , country) ;
    }

    public int getNumberCountry() {
        return numberCountry;
    }

    public String toString() {
        return "\nContinent{" +
                "\ncontinentName = " + continentName + '\'' +
                "\nnumberCountry = " + numberCountry + "\n" +
                countries +
                '}';
    }
}
