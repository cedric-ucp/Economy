package engine.data.economy;

import engine.config.Config;

public class Resource {
    private Config.typeResource resourceType;
    private double percentage ;

    public Resource(Config.typeResource type, double percentage) {
        this.resourceType = type;
        this.percentage = percentage;
    }

    public Config.typeResource getResourceType() {
        return resourceType;
    }

    public void setResourceType (Config.typeResource resourceType) {
        this.resourceType = resourceType;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    public boolean isTypeOf (Config.typeResource resourceType){
        return this.resourceType.equals (resourceType) ;
    }

    @Override
    public String toString() {
        return "\n\nResources{" +
                "\nresourceType = " + resourceType + '\'' +
                "\npercentage = " + percentage +
                "}\n" ;
    }
}
