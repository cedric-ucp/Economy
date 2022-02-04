package engine.config;

/**
 * @class
 * @classdesc contains all necessary constants and functions
 */

public class Config {
    /**
     * generate a random integer
     * @param min {Integer}
     * @param max {Integer}
     * @return {Integer}
     */
    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max + 1 - min)) + min;
    }
    /**
     * generate a random double
     * @param min {Double}
     * @param max {Double}
     * @return {Double}
     */
    public static double getRandomNumberDouble (double min , double max){
        return (Math.random() * (max + 1.0 - min)) + min ;
    }

    /**
     * generate random long
     * @param min {long}
     * @param max {long}
     * @return {long}
     */
    public static long getRandomNumberLong (long min , long max){
        return (long) (Math.random() * (max + 1 - min)) + min ;
    }

    public enum countryName {CAMEROON , MOROCCO , ALGERIA , CONGO , FRANCE , TUNISIA , LYBAN}
    public enum typeResource {GOLD , DIAMOND , WOOD , COTTON , PETROL , COAL , GAS , COBALT}
    public enum diffSector  {AGRICULTURE , INDUSTRIAL , SERVICE , TECH}
    public static int maxCountry = getRandomNumber (5 , 10) ;
    public static int maxCompany = getRandomNumber (8 , 10) ;
    public static long countryArea = getRandomNumber (20000 , 80000) ;


}
