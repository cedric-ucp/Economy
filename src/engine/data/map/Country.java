package engine.data.map;

import engine.config.Config;
import engine.data.economy.Economy;
import engine.data.economy.Resource;

import java.util.HashMap;
import java.util.Map;

public class Country {
    private long population ;
    private Map<String , Resource> resources = new HashMap<String , Resource>() ;
    private Config.countryName countryName ;
    private Economy economy ;
    private long countryArea ;

    public Country (long population, Config.countryName countryName, Economy economy, long countryArea){
        this.population = population;
        this.countryName = countryName;
        this.economy = economy;
        this.countryArea = countryArea;
    }


    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public void addResources (Resource resource){
        resources.put (resource.getResourceType() , resource) ;
    }

    public Map<String, Resource> getResources() {
        return resources;
    }

    public Config.countryName getCountryName() {
        return countryName;
    }

    public void setCountryName(Config.countryName countryName) {
        this.countryName = countryName;
    }

    public Economy getEconomy() {
        return economy;
    }

    public void setEconomy(Economy economy) {
        this.economy = economy;
    }

    public long getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(long countryArea) {
        this.countryArea = countryArea;
    }


}
