package engine.data.infrastructures;

public class Road extends Transport{
    private int mileage ;
    private double coverage ;

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
        return "Road{" +
                "mileage=" + mileage +
                ", coverage=" + coverage +
                "} " + super.toString();
    }
}
