package engine.data.economy;

import engine.data.infrastructures.Transport;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>create an Economy object with his components associated.</b>>
 * @author ETAME CEDRIC
 * @version 1.1
 */
public class Economy {
    /**
     * All attributes are an economic aspect of a country
     * @see Transport
     * @see Company
     */
    private final List <Transport> transports = new ArrayList <> () ;
    private long pib ;
    private double stockExchange ;
    private List <Company> companies = new ArrayList <> () ;
    private long debt ;

    /**
     * Economy constructor
     * @param stockExchange {Double}
     * @param debt {Integer}
     */
    public Economy (double stockExchange , int debt) {
        this.stockExchange = stockExchange ;
        this.debt = debt ;
    }

    public List <Transport> getTransports () {
        return transports ;
    }

    /**
     * add Transport object in transports list
     * @param transport {Transport}
     */
    public void addTransport (Transport transport){
        this.transports.add (transport) ;
    }

    public long getPib () {
        return pib ;
    }

    public void setPib (long pib) {
        this.pib = pib ;
    }

    public double getStockExchange () {
        return stockExchange ;
    }

    public void setStockExchange (double stockExchange) {
        this.stockExchange = stockExchange ;
    }

    public List<Company> getCompanies () {
        return companies ;
    }

    public void setCompanies (List <Company> companies){
        this.companies = companies ;
    }
    /**
     * add company object in companies list
     * @param company {Company}
     */
   public void addCompany (Company company){
        companies.add (company) ;
   }

    public long getDebt () {
        return debt ;
    }

    public void setDebt(long debt) {
        this.debt = debt ;
    }

    @Override
    public String toString() {
        return "\nEconomy{\n" +
                transports +
                "\n\tpib = " + pib +
                "\n\tstockExchange = " + stockExchange + "\n" +
                companies +
                "\n\tdebt = " + debt +
                "}\n" ;
    }
}
