package engine.data.economy;

import engine.data.infrastructures.Transport;

import java.util.ArrayList;
import java.util.List;

public class Economy {
    private List <Transport> transports = new ArrayList <> () ;
    private long pib ;
    private double stockExchange ;
    private List <Company> companies = new ArrayList <> () ;
    private long debt ;

    public Economy (int pib , double stockExchange , int debt) {
        this.pib = pib;
        this.stockExchange = stockExchange;
        this.debt = debt;
    }

    public List <Transport> getTransports() {
        return transports;
    }

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
        return "\nEconomy : \n{" +
                transports.toString () +
                "\npib = " + pib +
                "\nstockExchange = " + stockExchange + "\n" +
                companies.toString () +
                "\ndebt = " + debt +
                "}\n" ;
    }
}
