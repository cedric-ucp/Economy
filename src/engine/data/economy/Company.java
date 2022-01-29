package engine.data.economy;

import engine.config.Config;

public class Company{
    private long numberStaff ;
    private Config.diffSector sector  ;
    private long turnover ;
    private int totalCompany ;

    public Company (int numberStaff , Config.diffSector sector , long turnover , int totalCompany) {
        this.numberStaff = numberStaff ;
        this.sector = sector ;
        this.turnover = turnover ;
        this.totalCompany = totalCompany ;
    }

    public long getNumberStaff() {
        return numberStaff;
    }

    public void setNumberStaff(long numberStaff) {
        this.numberStaff = numberStaff;
    }

    public Config.diffSector getSector() {
        return sector;
    }

    public void setSector(Config.diffSector sector) {
        this.sector = sector;
    }

    public long getTurnover() {
        return turnover;
    }

    public void setTurnover(long turnover) {
        this.turnover = turnover;
    }

    public int getTotalCompany() {
        return totalCompany;
    }

    public void setTotalCompany(int totalCompany) {
        this.totalCompany = totalCompany;
    }

    @Override
    public String toString() {
        return "\nCompany{" +
                "\nnumberStaff = " + numberStaff +
                "\nsector = '" + sector + '\'' +
                "\nturnover = " + turnover +
                "\ntotalCompany = " + totalCompany +
                "}\n";
    }
    public boolean companySectorOf (Config.diffSector sector){
        return this.sector.equals (sector) ;
    }
}
