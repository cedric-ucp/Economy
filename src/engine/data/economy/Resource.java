package engine.data.economy;

public class Resource {
    private String resourceType;
    private double percentage ;

    public Resource(String type, double percentage) {
        this.resourceType = type;
        this.percentage = percentage;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType (String resourceType) {
        this.resourceType = resourceType;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    public boolean isTypeOf (String resourceType){
        return this.resourceType.equals (resourceType) ;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceType='" + resourceType + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
