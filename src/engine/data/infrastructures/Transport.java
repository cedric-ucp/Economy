package engine.data.infrastructures;

public abstract class Transport {
    private String type ;
    private boolean modern ;
    private long costBuilding ;
    private double traffic ;

    public Transport(String type, boolean modern, long costBuilding, double traffic) {
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
        return modern;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "type='" + type + '\'' +
                ", modern=" + modern +
                ", costBuilding=" + costBuilding +
                ", traffic=" + traffic +
                '}';
    }
}
