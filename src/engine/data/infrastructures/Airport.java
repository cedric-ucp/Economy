package engine.data.infrastructures;

/**
 * <b>create Airport Object daughter Transport class</b>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 1.0
 */
public class Airport extends Transport {
    private int totalAirports ;

    /**
     * Airport constructor
     * @param type {String}
     * @param modern {boolean}
     * @param costBuilding {long}
     * @param traffic {long}
     * @param totalAirports {Double}
     */
    public Airport (String type , boolean modern, long costBuilding, double traffic, int totalAirports){
        super (type, modern, costBuilding, traffic) ;
        this.totalAirports = totalAirports ;
    }

    public int getTotalAirports () {
        return totalAirports;
    }

    public void setTotalAirports (int totalAirports) {
        this.totalAirports = totalAirports ;
    }

    @Override
    public String toString () {
        return super.toString () + "\n\ttotalAirports = " + totalAirports + "}" ;
    }
}
