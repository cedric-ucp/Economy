package engine.config;

public class Config {
    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max + 1 - min)) + min;
    }
    public static double getRandomNumberDouble (double min , double max){
        return (Math.random() * (max + 1.0 - min)) + min ;
    }
    public static long getRandomNumberLong (long min , long max){
        return (long) (Math.random() * (max + 1 - min)) + min ;
    }

    public static enum countryName {CAMEROON , MOROCCO , ALGERIA , CONGO , FRANCE , TUNISIA}
    public static enum typeResource {GOLD , DIAMOND , WOOD , COTTON , PETROL , COAL , GAS}
    public static enum diffSector  {AGRICULTURE , INDUSTRIAL , SERVICE , TECH}
    public static int maxCountry = getRandomNumber (5 , 10) ;
    public static int maxCompany = getRandomNumber (8 , 10) ;
    public static long countryArea = getRandomNumber (20000 , 80000) ;


}
