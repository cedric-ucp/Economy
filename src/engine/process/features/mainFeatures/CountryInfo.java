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
 *
 * <b>CountryInfo concentrates all information needed to know and understand
 * a country.</b>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 1.5
 */
public class CountryInfo {
    private Country country ;
    private  Config.typeResource [] typeResource ;

    /**
     * CountryInfo constructor
     * @param country {Country}
     */
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
    public java.lang.String[] getTypeTransport (){
        List <Transport> transports = country.getEconomy ().getTransports () ;
        java.lang.String[] typeTransport = new java.lang.String[transports.size ()] ;
        int i = 0 ;
        for (Transport transport : transports){
            typeTransport [i] = transport.getType () ;
            i++ ;
        }
        return typeTransport ;
    }

    /**
     * returns the character string that presents all resources of a country
     * @return resourceString {StringBuilder}
     */
    public StringBuilder getTypeResourcesToString (){
        StringBuilder resourceString = new StringBuilder ("Country's resources :\n") ;
        for (Config.typeResource resource : typeResource) {
            resourceString.append ("\t").append (resource).append ("\n") ;
        }
        return resourceString ;
    }

    /**
     * returns the character string that presents all kind of transport
     * @return transportString {String}
     */
    public StringBuilder getTypeTransportToString (){
        StringBuilder transportString = new StringBuilder ("Country's transport :\n") ;
        for (java.lang.String typeTransport : getTypeTransport ()){
            transportString.append ("\t").append (typeTransport).append ("\n") ;
        }
        return transportString ;
    }
    public java.lang.String toString (){
        return "CountryInfo : \n" +
                country.toString (0) + "Total company : " + getNumberCompany ()  + "\n" +
                getTypeResourcesToString () +
                getTypeTransportToString () + "\n" ;
    }



}
