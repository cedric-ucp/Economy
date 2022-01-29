package engine.data.map;

import engine.config.Config;

import java.util.HashMap;
import java.util.Map;

public class Continent {
    private final Map <Config.countryName , Country> countries = new HashMap <> () ;
    private final int numberCountry ;

    public Continent (int numberCountry){
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
}
