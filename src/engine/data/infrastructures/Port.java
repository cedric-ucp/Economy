package engine.data.infrastructures;

public class Port extends Transport {
    private int totalPorts ;

    public Port(String type, boolean modern, long costBuilding, double traffic, int totalPorts) {
        super(type, modern, costBuilding, traffic);
        this.totalPorts = totalPorts;
    }

    public int getTotalPorts() {
        return totalPorts;
    }

    public void setTotalPorts(int totalPorts) {
        this.totalPorts = totalPorts;
    }

    @Override
    public String toString() {
        return  super.toString () +
                "\ntotalPorts=" + totalPorts +
                "}" ;
    }
}
