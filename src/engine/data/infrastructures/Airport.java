package engine.data.infrastructures;

public class Airport extends Transport {
    private int totalAiports ;

    public Airport (String type, boolean modern, long costBuilding, double traffic, int totalAiports){
        super(type, modern, costBuilding, traffic);
        this.totalAiports = totalAiports;
    }

    public int getTotalAiports () {
        return totalAiports;
    }

    public void setTotalAiports (int totalAiports) {
        this.totalAiports = totalAiports;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "totalAiports=" + totalAiports +
                "} " + super.toString() ;
    }
}
