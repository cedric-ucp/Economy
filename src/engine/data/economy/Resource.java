package engine.data.economy;

import engine.config.Config;

/**
 * @class
 * @classdesc create Resource object
 */
public class Resource {
    private Config.typeResource resourceType;
    private double percentage ;

    /**
     * Resource constructor
     * @param type {Config.typeResource}
     * @param percentage {Double}
     */
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
                "\n\tresourceType = " + resourceType.name () + '\'' +
                "\n\tpercentage = " + percentage +
                "}\n" ;
    }
}
