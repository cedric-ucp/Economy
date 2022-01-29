package engine.process;

import engine.config.Config;
import engine.data.economy.Economy;
import engine.data.infrastructures.Airport;
import engine.data.infrastructures.Port;
import engine.data.infrastructures.Road;
import engine.data.infrastructures.Transport;
import engine.data.map.Continent;
import engine.data.map.Country;


public class LoadSimulation {
   Continent continent ;

   public Economy buildEconomy (){
       return new Economy (Config.getRandomNumber (100000 , 500000) , Config.getRandomNumberDouble
               (-2.0 , 2.0) , Config.getRandomNumber (100000 , 200000)) ;
   }
   public Economy buildTransportforEconomy (Economy economy){
       for (int i = 0 ; i < 3 ; i++){
           switch (Config.getRandomNumber (0 , 3)) {
               case 0 :
                   int mileage = Config.getRandomNumber (20000 , 70000) ;
                   economy.addTransport (new Road ("Road", i <= 1,
                           Config.getRandomNumberLong (30000, 450000), Config.getRandomNumberDouble (0.0 , 1.0) ,
                           mileage , (double) Config.countryArea / mileage)) ;
                   break ;
               case 1 :
                   economy.addTransport (new Airport("Road", i <= 1,
                           Config.getRandomNumberLong (30000, 450000), Config.getRandomNumberDouble (0.0 , 1.0) ,
                          Config.getRandomNumber (1 , 8))) ;
                   break ;
               case 2 :
                   economy.addTransport (new Port("Road", i <= 1,
                           Config.getRandomNumberLong (30000, 450000), Config.getRandomNumberDouble (0.0 , 1.0) ,
                           Config.getRandomNumber (2 , 8))) ;
               default :

           }
       }

       return economy ;
   }
   public Country buildCountry (){
       Config.countryName[] countryNames = Config.countryName.values () ;
       int index = Config.getRandomNumber (0 , countryNames.length) ;
       return new Country (Config.getRandomNumberLong (100000 , 200000) , countryNames [index] ,
               buildEconomy () , Config.countryArea) ;
   }
}
