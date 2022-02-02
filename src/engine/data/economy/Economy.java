package engine.data.economy;

import engine.data.infrastructures.Transport;

import java.util.ArrayList;
import java.util.List;

/**
 * @class
 * @classdesc create Economy object
 */
public class Economy {
    private final List <Transport> transports = new ArrayList <> () ;
    private long pib ;
    private double stockExchange ;
    private final List <Company> companies = new ArrayList <> () ;
    private long debt ;

    /**
     * Economy constructor
     * @param pib {Integer}
     * @param stockExchange {Double}
     * @param debt {Integer}
     */
    public Economy (int pib , double stockExchange , int debt) {
        this.pib = pib;
        this.stockExchange = stockExchange;
        this.debt = debt;
    }

    public List <Transport> getTransports() {
        return transports;
    }

    /**
     * add Transport object in transports list
     * @param transport {Transport}
     */
    public void addTransport (Transport transport){
        this.transports.add (transport) ;
    }

    public long getPib() {
        return pib;
    }

    public void setPib(long pib) {
        this.pib = pib;
    }

    public double getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(double stockExchange) {
        this.stockExchange = stockExchange;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    /**
     * add company object in companies list
     * @param company {Company}
     */
   public void addCompany (Company company){
        companies.add (company) ;
   }

    public long getDebt() {
        return debt;
    }

    public void setDebt(long debt) {
        this.debt = debt;
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
