package engine.data.infrastructures;

/**
 *<b>create Road class daughter class of Transport.</b>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 1.0
 */
public class Road extends Transport{
    private int mileage ;
    private double coverage ;

    /**
     * Road constructor
     * @param type {String}
     * @param modern {boolean}
     * @param costBuilding {long}
     * @param traffic {double}
     * @param mileage {Integer}
     * @param coverage {double}
     */
    public Road(String type, boolean modern, long costBuilding, double traffic, int mileage, double coverage) {
        super(type, modern, costBuilding, traffic);
        this.mileage = mileage;
        this.coverage = coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getCoverage() {
        return coverage;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return  super.toString () +
                "\n\tmileage=" + mileage +
                "\n\tcoverage=" + coverage +
                "}" ;
    }
}
