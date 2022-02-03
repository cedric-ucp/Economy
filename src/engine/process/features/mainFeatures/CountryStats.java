package engine.process.features.mainFeatures;

import engine.config.Config;
import engine.data.economy.Company;
import engine.data.economy.Economy;
import engine.data.economy.Resource;
import engine.data.infrastructures.Transport;
import engine.data.map.Country;

import java.util.ArrayList;
import java.util.List ;
import java.util.Map ;

/**
 * @class
 * @classdesc concentrates methods needed to produce a country’s statistics
 */
public class CountryStats{
    private final Country country ;
    private final Economy economy ;
    private final List <Company> companies ;
    private final List <String> sectorsCompany = new ArrayList<> () ;
    /**
     * CountryStats constructor
     * @param country {Country}
     */
    public CountryStats(Country country) {
        this.country = country ;
        economy = this.country.getEconomy () ;
        companies = economy.getCompanies () ;
    }

    /**
     * allows to get all economic sectors of a country
     * @return sectorsCompany {List <String>}
     */
    public List <String> getAllSectorsCompany (){
        for (Company company : companies){
            String sector = company.getSector ().name () ;
            if (!sectorsCompany.contains (sector)){
                sectorsCompany.add (sector) ;
            }
        }
        return sectorsCompany ;
    }
    /**
     * return number of employees by sector
     * @param diffSector {Config.diffSector}
     * @return totalStaff {Integer}
     */
    public int numberStaffBySector (String diffSector){
        int totalStaff = 0 ;
        for (Company company : companies){
            if (company.getSector ().equals (Config.diffSector.valueOf (diffSector))){
                totalStaff += company.getNumberStaff () ;
            }
        }
        return totalStaff ;
    }

    /**
     * return number of employees by country
     * @return totalStaff {Integer}
     */
    public int staffByCountry (){
        int totalStaff = 0 ;
        for (Company company : companies){
            totalStaff += company.getNumberStaff () ;
        }
        return totalStaff ;
    }

    /**
     * return turnover by sector
     * @param sector {String}
     * @return totalTurnover {long}
     */
    public long turnoverSector (String sector){
        long totalTurnover = 0 ;
        for (Company company : companies){
            if (company.getSector ().equals (Config.diffSector.valueOf (sector))){
                totalTurnover += company.getTurnover () ;
            }
        }
        return totalTurnover ;
    }

    /**
     * return number of company by sector
     * @param sector {String}
     * @return totalCompany {Integer}
     */
    public int totalCompanyBySector (String sector){
        int totalCompany = 0 ;
        for (Company company : companies){
            if (company.getSector ().equals (Config.diffSector.valueOf (sector))){
                totalCompany += company.getTotalCompany () ;
            }
        }
        return totalCompany ;
    }

    /**
     * returns  percentage of a resource on total resources of a country
     * @param typeResource {String}
     * @return totalPercentage {double}
     */
    public double getPercentageByResource (String typeResource){
        Map <Config.typeResource , Resource> resources = country.getResources () ;
        double totalPercentage = 0.0 ;
        for (Config.typeResource resource : resources.keySet ()){
            if (resource.equals (Config.typeResource.valueOf (typeResource))){
                totalPercentage +=  resources.get (resource).getPercentage () ;
            }
        }
        return totalPercentage ;
    }

    /**
     * returns a boolean that indicates whether transport is modern or not
     * @return modern {boolean}
     */
    public boolean modernTransports (){
        int modern = 0 ;
        int noModern = 0 ;
        List <Transport> transports  = economy.getTransports () ;
        for (Transport transport : transports){
            if (transport.isModern ()){
                modern++ ;
            }
            else{
                noModern++ ;
            }
        }
        return modern >= noModern ;
    }

    /**
     * returns the total cost of building a country’s transport
     * @return totalCost {Integer}
     */
    public long totalCostTransport (){
        List <Transport> transports = economy.getTransports () ;
        long totalCost = 0 ;
        for (Transport transport : transports){
            totalCost += transport.getCostBuilding () ;
        }
        return totalCost ;
    }

    /**
     * constructs string of characters of totalStaff
     * in an economic sector
     * @return staffString {StringBuilder}
     */
    public StringBuilder staffSectorToString (){
        StringBuilder staffString = new StringBuilder () ;
        for (String sector : getAllSectorsCompany()){
            staffString.append (sector).append (" : ").
            append (numberStaffBySector (sector)).append ("\n") ;
        }
        return staffString ;
    }
    /**
     * constructs string of characters of totalStaff
     * in a country
     * @return staffString {StringBuilder}
     */
    public StringBuilder staffCountryString (){
        StringBuilder staffString = new StringBuilder ("Number of employees in ") ;
        staffString.append (country.getCountryName ().name ()).append (" : ").
        append (staffByCountry ()).append ("\n") ;
        return staffString ;
    }
    /**
     * constructs string of characters of turnover
     * in an economic sector
     * @return turnoverString {StringBuilder}
     */
    public StringBuilder turnoverSectorString (){
        StringBuilder turnoverString = new StringBuilder () ;
        for (String sector : getAllSectorsCompany ()){
            turnoverString.append (sector).append (" : ").
            append (turnoverSector (sector)).append ("\n") ;
        }
        return turnoverString ;
    }
    /**
     * constructs string of characters of total company
     * in an economic sector
     * @return totalString {StringBuilder}
     */
    public StringBuilder totalCompanyString (){
        StringBuilder totalString = new StringBuilder () ;
        for (String sector : getAllSectorsCompany ()){
            totalString.append (sector).append (" : ").
            append (totalCompanyBySector (sector)).append ("\n") ;
        }
        return totalString ;
    }
    /**
     * constructs string of characters of percentage
     * for each resource of a country
     * @return percentageString {StringBuilder}
     */
    public StringBuilder percentageResourceString (){
        StringBuilder percentageString = new StringBuilder () ;
        for (Resource resource : country.getResources ().values ()){
            Config.typeResource typeResource = resource.getResourceType () ;
            percentageString.append (typeResource.name ()).append (" : ").
            append (getPercentageByResource (typeResource.name ())).append ("\n") ;
        }
        return percentageString ;
    }

    public String toString (){
        return "Number of employees by sector : \n"
                + staffSectorToString () + "\n" + "Number of employees by Country : \n"
                + staffCountryString () + "\n" + "Turnover by sector : \n"
                + turnoverSectorString () + "\n" + "Total Company in the Country : \n"
                + totalCompanyString () + "\n" + "Percentage by resource : \n"
                + percentageResourceString () + "\n" + "Total cost of transport construction : "
                + totalCostTransport () + "\n" + "Modern Transportation : \n"
                + "Modern Transportation in " + country.getCountryName () + " : "
                + modernTransports () + "\n" ;
    }
}






























