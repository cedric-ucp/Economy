package engine.data.infrastructures;

/**
 *  <b>create Port object daughter class of Transport class</b>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 1.0
 */
public class Port extends Transport {
    private int totalPorts ;

    /**
     * Port constructor
     * @param type {String}
     * @param modern {boolean}
     * @param costBuilding {Long}
     * @param traffic {Double}
     * @param totalPorts {Integer}
     */
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
                "\n\ttotalPorts = " + totalPorts +
                "}" ;
    }
}
