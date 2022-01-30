package engine.data.infrastructures;

public class Airport extends Transport {
    private int totalAirports;

    public Airport (String type, boolean modern, long costBuilding, double traffic, int totalAiports){
        super(type, modern, costBuilding, traffic);
        this.totalAirports = totalAiports;
    }

    public int getTotalAirports() {
        return totalAirports;
    }

    public void setTotalAirports(int totalAirports) {
        this.totalAirports = totalAirports;
    }

    @Override
    public String toString() {
        return super.toString () + "\ntotalAirports=" + totalAirports + "}" ;
    }
}
