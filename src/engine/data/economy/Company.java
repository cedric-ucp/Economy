package engine.data.economy;

public class Company{
    private long numberStaff ;
    private String sector  ;
    private long turnover ;
    private int totalCompany ;

    public Company (int numberStaff , String sector , int turnover , int totalCompany) {
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
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
        return "Company" +
                "numberStaff = " + numberStaff +
                ", sector = '" + sector + '\'' +
                ", turnover = " + turnover +
                ", totalCompany = " + totalCompany +
                '}';
    }
    public boolean companySectorOf (String sector){
        return this.sector.equals (sector) ;
    }
}
