package engine.process.features.mainFeatures;

import engine.config.Config;
import engine.data.economy.Company;
import engine.data.economy.Economy;
import engine.data.economy.Resource;
import engine.data.infrastructures.Transport;
import engine.data.map.Country;

import java.util.List;
import java.util.Map;

/**
 * @class
 * @classdesc create CountryInfo object that concentrates methods for obtaining information from a country
 */
public class CountryInfo {
    private Country country ;
    private  Config.typeResource [] typeResource ;

    public CountryInfo (Country country){
        this.country = country ;
        getNumberCompany () ;
        getAllTypeResource () ;
    }
    /**
     * returns total number of companies present in a country
     * @return totalCompany {Integer}
     */
    public int getNumberCompany (){
        Economy economy = country.getEconomy () ;
        List <Company> companies = economy.getCompanies () ;
        int totalCompany = 0 ;

        for (Company company : companies){
            totalCompany += company.getTotalCompany () ;
        }
        return totalCompany ;
    }

    /**
     * allows to obtain the resource type(s) of a country
     */
    public void getAllTypeResource (){
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

    /**
     * returns the type or types of transport of a country
     * @return typeTransport {String}
     */
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
    public StringBuilder getTypeResourcesToString (){
        StringBuilder resourceString = new StringBuilder ("Country's resources :\n") ;
        for (Config.typeResource resource : typeResource) {
            resourceString.append ("\t").append (resource).append ("\n") ;
        }
        return resourceString ;
    }
    public StringBuilder getTypeTransportToString (){
        StringBuilder transportString = new StringBuilder ("Country's transport :\n") ;
        for (String typeTransport : getTypeTransport ()){
            transportString.append ("\t").append (typeTransport).append ("\n") ;
        }
        return transportString ;
    }
    public String toString (){
        return "CountryInfo : \n" +
                country.toString (0) + "Total company : " + getNumberCompany ()  + "\n" +
                getTypeResourcesToString () +
                getTypeTransportToString () + "\n" ;
    }



}
