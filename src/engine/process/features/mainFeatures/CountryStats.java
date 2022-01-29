package engine.process.features.mainFeatures;

import engine.config.Config;
import engine.data.economy.Company;
import engine.data.economy.Economy;
import engine.data.economy.Resource;
import engine.data.infrastructures.Transport;
import engine.data.map.Country;

import java.util.List;
import java.util.Map;

public class CountryStats{
    private final Country country ;
    private final Economy economy ;
    private final List <Company> companies ;

    public CountryStats(Country country) {
        this.country = country ;
        economy = this.country.getEconomy () ;
        companies = economy.getCompanies () ;
    }

    public int numberStaffBySector (String diffSector){
        int totalStaff = 0 ;
        for (Company company : companies){
            if (company.getSector ().equals (Config.diffSector.valueOf (diffSector))){
                totalStaff += company.getNumberStaff () ;
            }
        }
        return totalStaff ;
    }

    public int staffByCountry (){
        int totalStaff = 0 ;
        for (Company company : companies){
            totalStaff += company.getNumberStaff () ;
        }
        return totalStaff ;
    }

    public long turnoverSector (String sector){
        long totalTurnover = 0 ;
        for (Company company : companies){
            if (company.getSector ().equals (Config.diffSector.valueOf (sector))){
                totalTurnover += company.getTurnover () ;
            }
        }
        return totalTurnover ;
    }

    public int totalCompanyBySector (String sector){
        int totalCompany = 0 ;
        for (Company company : companies){
            if (company.getSector ().equals (Config.diffSector.valueOf (sector))){
                totalCompany += company.getTotalCompany () ;
            }
        }
        return totalCompany ;
    }

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

    public long totalCostTransport (){
        List <Transport> transports = economy.getTransports () ;
        long totalCost = 0 ;
        for (Transport transport : transports){
            totalCost += transport.getCostBuilding () ;
        }
        return totalCost ;
    }
    /*
    private double maxNumber (double number1 , double number2){
        return Math.max (number1, number2) ;
    }*/

    /*
    public String percentageMostTraffic (Economy economy){
        List <Transport> transports = economy.getTransports () ;
        double airportCount = 0 ;
        double portCount = 0 ;
        double roadCount = 0 ;
        for (Transport transport : transports){
            if (transport.getType ().equals ("Road")){
                roadCount++ ;
            }
            else if (transport.getType ().equals ("Airport")){
                airportCount++ ;
            }
            else{
                portCount++ ;
            }
        }
        double getMax = maxNumber (roadCount , airportCount) ;
        getMax = maxNumber (getMax , portCount) ;

        return "" ;
    }
*/

}






























