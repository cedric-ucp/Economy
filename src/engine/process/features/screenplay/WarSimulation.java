package engine.process.features.screenplay;

import engine.config.Config;
import engine.data.economy.Company;
import engine.data.economy.Economy;
import engine.data.economy.Resource;
import engine.data.map.Country;

import java.util.List;
import java.util.Map;

/**
 * <b>WarSimulation allows the building of consequences of a war for a country looser or winner.</b>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 1.0
 */

public class WarSimulation {
    private final Country country ;

    /**
     * WarSimulation constructor
     * @param country {Country}
     */
    public WarSimulation (Country country){
        this.country = country ;
    }

    /**
     * changeCompanyTurnover allows to calculate the drop in turnover for a company
     * @param turnover {long}
     * @param coefficient {double}
     * @return turnover {long}
     */
    private long changeCompanyTurnover (long turnover , double coefficient){
        long decreaseTurnover = (long) (turnover * coefficient) ;
        turnover -= decreaseTurnover ;

        return turnover ;
    }

    /**
     * allows to calculate the decrease the size of total numbers of companies
     * @param company {Company}
     * @param looser {boolean}
     */
    private void changeTotalCompany (Company company , boolean looser){
        int totalCompany = company.getTotalCompany () ;
        int difference = Config.getRandomNumber (3 , totalCompany) ;
        if (looser){
            if (difference == totalCompany) {
                totalCompany -= (totalCompany / 2) ;
            }
            else{
                totalCompany -= difference ;
            }
        }
        else{
            if (difference == totalCompany){
                totalCompany -= (totalCompany / 4) ;
            }
            else{
                totalCompany -= (difference / 2) ;
            }
        }
        company.setTotalCompany (totalCompany) ;

    }

    /**
     * is used to modify the performance of each resource for a country after war
     * @param resource {Resource}
     * @param looser {boolean}
     * @return productionAmount  {long}
     */
    private long modifyResource (Resource resource , boolean looser){
        long productionAmount = resource.getProductionAmount () ;
        long difference = Config.getRandomNumberLong (100000 , productionAmount) ;
        if (looser){
            if (difference == productionAmount){
                productionAmount -= (productionAmount / 2) ;
            }
            else{
                while (difference < 250000){
                    difference = Config.getRandomNumberLong (100000 , productionAmount) ;
                }
              productionAmount -= difference ;
            }
        }
        else{
            if (difference == productionAmount){
                productionAmount -= (productionAmount / 4) ;
            }
            else{
                productionAmount -= (productionAmount / 2) ;
            }
        }
        return productionAmount ;
    }

    /**
     * is used to calculate the population of a country after a war from a coefficient
     * @param population {long}
     * @param coefficient {double}
     * @return population {long}
     */
    private long newPopulation (long population , double coefficient){
       long difference = (long) (population * coefficient) / 100 ;
       population -= difference ;

       return population ;
    }

    /**
     * the main function that concentrates the rest function of the class.
     * it's used to modify all economy's aspects of a country looser after
     * a war or a country winner after a war
     * @param looser {boolean}
     */
    public void changeEconomyCountry (boolean looser){
        Economy economy = country.getEconomy () ;
        List <Company> companies = economy.getCompanies () ;
        Map <Config.typeResource , Resource> resources = country.getResources () ;
        long allCompanyTurnover = 0 ;
        long totalProductionAmount = 0 ;

        //we side with the losing country
        if (looser){
            // for each country the turnover of all companies are modified their number as well
            for (Company company : companies){
                // choose a coefficient between 0.4 and 0.6 for a looser country
                long newTurnover = changeCompanyTurnover (company.getTurnover () , Config.getRandomNumberDouble (0.4 , 0.6)) ;
                company.setTurnover (newTurnover) ;
                //saving total turnover of all companies
                allCompanyTurnover += newTurnover ;
                changeTotalCompany (company , true) ;
            }

            //for each country all resources are modified especially each resource's production amount
            for (Resource resource : resources.values ()){
                long newProductionAmount = modifyResource (resource , true) ;
                resource.setProductionAmount (newProductionAmount) ;
                //saving total production amount of all resources
                totalProductionAmount += newProductionAmount ;
            }
            //update of economy and resources for the country
            economy.setCompanies (companies) ;
            economy.setPib (allCompanyTurnover + totalProductionAmount) ;
            country.setResources (resources) ;
            country.setEconomy (economy) ;
            //population modified due to war percentage between 15% and 30%
            long newPopulation = newPopulation (country.getPopulation () , Config.getRandomNumber(15 , 30)) ;
            country.setPopulation (newPopulation) ;
        }
        // we side with the winner country
        else {
            //same algorithm than above but with different numbers adapted for a winner country
            for (Company company : companies) {
                long newTurnover = changeCompanyTurnover (company.getTurnover () , Config.getRandomNumberDouble (0.2, 0.4)) ;
                company.setTurnover (newTurnover) ;
                allCompanyTurnover += newTurnover ;
                changeTotalCompany (company , false) ;
            }
            for (Resource resource : resources.values()){
                long newProductionAmount = modifyResource (resource , false) ;
                modifyResource (resource, false) ;
                totalProductionAmount += newProductionAmount ;
            }
            economy.setCompanies (companies) ;
            economy.setPib (allCompanyTurnover + totalProductionAmount) ;
            country.setResources (resources) ;
            country.setEconomy (economy) ;
            long newPopulation = newPopulation (country.getPopulation () , Config.getRandomNumber (7 , 15)) ;
            country.setPopulation (newPopulation) ;
        }

    }

    public Country getCountry (){
        return country ;
    }

}
