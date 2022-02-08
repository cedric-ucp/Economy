package engine.data.map;

import engine.config.Config;
import engine.data.economy.Economy;
import engine.data.economy.Resource;

import java.util.HashMap;
import java.util.Map;

/**
 *<b>Create Country object.</b>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 1.2
 */
public class Country {
    /**
     * Country object are represented by these attributes
     * @see Resource
     * @see Economy
     */
    private Config.countryName countryName ;
    private long population ;
    private Map <Config.typeResource , Resource> resources = new HashMap <> () ;
    private Economy economy ;
    private long countryArea ;

    /**
     * Country constructor
     * @param population {long}
     * @param countryName {Config.countryName}
     * @param economy {Economy}
     * @param countryArea {long}
     */
    public Country (long population , Config.countryName countryName , Economy economy , long countryArea){
        this.population = population ;
        this.countryName = countryName ;
        this.economy = economy ;
        this.countryArea = countryArea ;
    }


    public long getPopulation () {
        return population ;
    }

    public void setPopulation (long population) {
        this.population = population ;
    }

    /**
     * add Resource object in Resource list
     * @param resource {Resource}
     */
    public void addResources (Resource resource){
        resources.put (resource.getResourceType() , resource) ;
    }

    public Map<Config.typeResource, Resource> getResources() {
        return resources ;
    }
    public void setResources (Map <Config.typeResource , Resource> resources){
        this.resources = resources ;
    }

    public Config.countryName getCountryName() {
        return countryName ;
    }

    public void setCountryName(Config.countryName countryName) {
        this.countryName = countryName ;
    }

    public Economy getEconomy() {
        return economy ;
    }

    public void setEconomy(Economy economy) {
        this.economy = economy ;
    }

    public long getCountryArea () {
        return countryArea ;
    }

    public void setCountryArea(long countryArea) {
        this.countryArea = countryArea ;
    }


    @Override
    public String toString() {
        return "\nCountry{" +
                "\n\tcountryName = " + countryName.name () +
                "\n\tpopulation = " + population + "\n" +
                resources + economy +
                "\n\tcountryArea = " + countryArea +
                "\n\n----------------------------------------\n\n" ;
    }
    public String toString (int bis){
        return "\nCountry{" +
                "\n\tcountryName = " + countryName.name () +
                "\n\tpopulation = " + population +
                "\n\tcountryArea = " + countryArea +
                "\n\tpib = " + economy.getPib () + "\n" ;

    }
}
