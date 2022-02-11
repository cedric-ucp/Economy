package engine.config;

/**
 * <b> contains all necessary constants and functions</b>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 2.1
 */

public class Config {
    /**
     * generate a random integer
     * @param min {Integer}
     * @param max {Integer}
     * @return {Integer}
     */
    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random () * (max - min) + min) ;
    }
    /**
     * generate a random double
     * @param min {Double}
     * @param max {Double}
     * @return {Double}
     */
    public static double getRandomNumberDouble (double min , double max){
        return (Math.random () * (max - min) + min) ;
    }

    /**
     * generate random long
     * @param min {long}
     * @param max {long}
     * @return {long}
     */
    public static long getRandomNumberLong (long min , long max){
        return (long) (Math.random () * (max - min) + min) ;
    }

    /**
     * All static parameters that will be used
     */
    public enum countryName {CAMEROON , MOROCCO , ALGERIA , CONGO , FRANCE , TUNISIA , LEBANON}
    public enum typeResource {GOLD , DIAMOND , WOOD , COTTON , PETROL , COAL , GAS , COBALT}
    public enum diffSector  {AGRICULTURE , INDUSTRIAL , SERVICE , TECH}
    public static int maxCountry = 4 ;
    public static int maxCompany = getRandomNumber (8 , 10) ;
    public static long countryArea = getRandomNumber (20000 , 80000) ;


}
