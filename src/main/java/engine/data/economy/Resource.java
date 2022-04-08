package engine.data.economy;

import engine.config.Config;

/**
 * <b>Create an object Resource.</b>>
 * @author ETAME CEDRIC etamecedric7@gmail.com
 * @version 1.0
 */
public class Resource {
    private Config.typeResource resourceType;
    private double percentage ;
    private long productionAmount ;

    /**
     * Resource constructor
     * @param type {Config.typeResource}
     * @param percentage {Double}
     * @param productionAmount {long}
     */
    public Resource (Config.typeResource type , double percentage , long productionAmount) {
        this.resourceType = type ;
        this.percentage = percentage ;
        this.productionAmount = productionAmount ;
    }

    public Config.typeResource getResourceType () {
        return resourceType ;
    }

    public void setResourceType (Config.typeResource resourceType) {
        this.resourceType = resourceType ;
    }

    public double getPercentage () {
        return percentage ;
    }

    public void setProductionAmount (long productionAmount) {
        this.productionAmount = productionAmount ;
    }

    public long getProductionAmount() {
        return productionAmount ;
    }

    public void setPercentage (double percentage) {
        this.percentage = percentage ;
    }
    public boolean isTypeOf (Config.typeResource resourceType){
        return this.resourceType.equals (resourceType) ;
    }

    @Override
    public java.lang.String toString () {
        return "\n\nResources{" +
                "\n\tresourceType = " + resourceType.name () + '\'' +
                "\n\tpercentage = " + percentage +
                "\n\tproductionAmount = " + productionAmount +
                "}\n" ;
    }
}
