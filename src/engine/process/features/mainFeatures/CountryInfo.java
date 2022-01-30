package engine.process.features.mainFeatures;

import engine.config.Config;
import engine.data.economy.Company;
import engine.data.economy.Economy;
import engine.data.economy.Resource;
import engine.data.infrastructures.Transport;
import engine.data.map.Country;

import java.util.List;
import java.util.Map;

public class CountryInfo {
    private Country country ;
    private  Config.typeResource [] typeResource ;

    public int getNumberCompany (Country country){
        Economy economy = country.getEconomy () ;
        List <Company> companies = economy.getCompanies () ;
        int totalCompany = 0 ;

        for (Company company : companies){
            totalCompany += company.getTotalCompany () ;
        }
        return totalCompany ;
    }

    public void getTypeResource (Country country){
        Map<Config.typeResource , Resource> resources = country.getResources () ;
        int i = 0 ;
        typeResource = new Config.typeResource [resources.size ()] ;
        for (Config.typeResource typeResource : resources.keySet ()){
            this.typeResource [i] = typeResource ;
            i++ ;
        }
    }

    public void setCountry (Country country){
        this.country = country ;
    }

    public Config.typeResource[] getTypeResource() {
        return typeResource;
    }

    public String [] getTypeTransport (){
        List <Transport> transports = country.getEconomy ().getTransports () ;
        String [] typeTransport = new String [transports.size ()] ;
        int i = 0 ;
        for (Transport transport : transports){
            typeTransport [i] = transport.getType () ;
            i++ ;
        }
        return typeTransport ;
    }

}
