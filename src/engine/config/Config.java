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
    public enum countryName {CAMEROON , MOROCCO , ALGERIA , FRANCE ,  ITALY , SPAIN , CONGO , TUNISIA}
    public enum typeResource {GOLD , DIAMOND , WOOD , COTTON , PETROL , COAL , GAS , COBALT}
    public enum diffSector  {AGRICULTURE , INDUSTRIAL , SERVICE , TECH}
    public static int maxCountry = 4 ;
    public static int maxCompany = getRandomNumber (8 , 10) ;
    public static long countryArea = getRandomNumber (20000 , 80000) ;
    public static boolean WAR = false;
    public static boolean Pandemic = false;
    public static String WAR_WINNER = "";
    public static String WAR_LOSER = "";
    public static int COUNTER_WAR = 0;
    public static int COUNTER_Pandimec = 0;
    public static final int WINDOW_WIDTH = 600 ; // On definit la largeur de la fenetre
    public static final int WINDOW_HEIGHT = 600 ;// On definit la hauteur de notre fenetre
    public static final int GRILL_SIZE = 100;
    public static final int LINE_COUNT = WINDOW_HEIGHT / GRILL_SIZE; // hauteur de la fenetre divisee la taille d'un block.
    public static final int COLUMN_COUNT = WINDOW_WIDTH / GRILL_SIZE ; // largeur de la fenetre divisee par la taille d'un block.


}
