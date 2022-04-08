package engine.process.features.screenplay;

import engine.config.Config;
import engine.data.economy.Company;
import engine.data.economy.Economy;
import engine.data.economy.Resource;
import engine.data.map.Country;

import java.util.ArrayList;
import java.util.List ;
import java.util.Map;

/**
 * <b>PandemicSimulation class builds all the damage done by the pandemic for all countries</b>
 * @author ETAME CEDRIC <etamecedric7@gmail.com
 * @version 1.0
 */
public class PandemicSimulation {

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
     */
    private void changeTotalCompany (Company company){
        int totalCompany = company.getTotalCompany () ;
        int difference = Config.getRandomNumber (3 , totalCompany) ;
        int factor = Config.getRandomNumber (2 , 4) ;

        if (difference == totalCompany){
            totalCompany -= (totalCompany / factor) ;
        }
        else{
            totalCompany -= difference ;
        }
        company.setTotalCompany (totalCompany) ;
    }

    /**
     * is used to modify the performance of each resource for a country after war
     * @param resource {Resource}
     * @return productionAmount  {long}
     */
    private long modifyResource (Resource resource){
        long productionAmount = resource.getProductionAmount () ;
        long difference = Config.getRandomNumberLong (100000 , productionAmount) ;
        int factor = Config.getRandomNumber (2 , 4) ;

        if (difference == productionAmount){
            productionAmount -= (productionAmount / factor) ;
        }
        else{
            while (difference < 250000){
                difference = Config.getRandomNumberLong (100000 , productionAmount) ;
            }
            productionAmount -= difference ;
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
     * it's used to modify all economy's aspects for any country concerned
     * by the pandemic
     * @param country {Country}
     */
    public void changeEconomyCountry (Country country){
        Economy economy = country.getEconomy () ;
        List <Company> companies = economy.getCompanies () ;
        Map<Config.typeResource , Resource> resources = country.getResources () ;
        long allCompanyTurnover = 0 ;
        long totalProductionAmount = 0 ;

            // for each country the turnover of all companies are modified their number as well
            for (Company company : companies){
                // choose a coefficient between 0.4 and 0.6 for a looser country
                long newTurnover = changeCompanyTurnover (company.getTurnover () , Config.getRandomNumberDouble (0.4 , 0.6)) ;
                company.setTurnover (newTurnover) ;
                //saving total turnover of all companies
                allCompanyTurnover += newTurnover ;
                changeTotalCompany (company) ;
            }

            //for each country all resources are modified especially each resource's production amount
            for (Resource resource : resources.values ()){
                long newProductionAmount = modifyResource (resource) ;
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
            long newPopulation = newPopulation (country.getPopulation () , Config.getRandomNumber (15 , 30)) ;
            country.setPopulation (newPopulation) ;
        }

}
