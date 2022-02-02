package engine.data.infrastructures;

/**
 * @class
 * @classdesc Abstract class Transport
 */
public abstract class Transport {
    private final String type ;
    private boolean modern ;
    private long costBuilding ;
    private double traffic ;

    /**
     * Transport Constructor
     * @param type {String}
     * @param modern {boolean}
     * @param costBuilding {long}
     * @param traffic {double}
     */
    public Transport (String type, boolean modern, long costBuilding, double traffic) {
        this.type = type;
        this.modern = modern;
        this.costBuilding = costBuilding;
        this.traffic = traffic;
    }

    public void setTraffic(double traffic) {
        this.traffic = traffic;
    }

    public void setCostBuilding(long costBuilding) {
        this.costBuilding = costBuilding;
    }

    public void setModern(boolean modern) {
        this.modern = modern;
    }

    public double getTraffic() {
        return traffic;
    }

    public long getCostBuilding() {
        return costBuilding;
    }

    public boolean isModern() {
        return modern ;
    }
    public String getType (){
        return type ;
    }

    @Override
    public String toString () {
        return "\nTransport{" +
                "\n\ttype = '" + type + '\'' +
                "\n\tmodern = " + modern +
                "\n\tcostBuilding = " + costBuilding +
                "\n\ttraffic = " + traffic ;
    }
}
