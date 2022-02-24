package engine.data.economy;

import engine.config.Config;

/**
 * <b>Create object company</b>>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 1.0
 */
public class Company{
    private long numberStaff ;
    private String sector  ;
    private long turnover ;
    private int totalCompany ;

    /**
     * Company constructor
     * @param numberStaff {Integer}
     * @param sector {Config.diffSector}
     * @param turnover {long}
     * @param totalCompany {Integer}
     */
    public Company (int numberStaff , String sector, long turnover , int totalCompany) {
        this.numberStaff = numberStaff ;
        this.sector = sector ;
        this.turnover = turnover ;
        this.totalCompany = totalCompany ;
    }


    public long getNumberStaff () {
        return numberStaff ;
    }

    public void setNumberStaff (long numberStaff) {
        this.numberStaff = numberStaff ;
    }

    public String getSector () {
        return sector ;
    }

    public void setSector (String sector) {
        this.sector = sector;
    }

    public long getTurnover () {
        return turnover;
    }

    public void setTurnover (long turnover) {
        this.turnover = turnover ;
    }

    public int getTotalCompany () {
        return totalCompany ;
    }

    public void setTotalCompany (int totalCompany) {
        this.totalCompany = totalCompany ;
    }

    @Override
    public String toString () {
        return "\nCompany{" +
                "\n\tnumberStaff = " + numberStaff +
                "\n\tsector = '" + sector + '\'' +
                "\n\tturnover = " + turnover +
                "\n\ttotalCompany = " + totalCompany +
                "}\n" ;
    }
    public boolean companySectorOf (String sector){
        return this.sector.equals (sector) ;
    }



































}
