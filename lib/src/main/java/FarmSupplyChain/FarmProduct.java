package FarmSupplyChain;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import java.util.Objects;

@DataType
public class FarmProduct {
	
    @Property
    private String productId;
    @Property
    private String productDescription;
    @Property
    private String producerName;
    @Property
    private String producerAddress;
    @Property
    private String harvestDate;
    @Property
    private String distributerName;
    @Property
    private String distributerAddress;
    @Property
    private String prodToDistDate;
    @Property
    private String retailerName;
    @Property
    private String retailerAddress;
    @Property
    private String distToRetaDate;
    
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
    public void setProducerAddress(String producerAddress) {
        this.producerAddress = producerAddress;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }

    public void setDistributerName(String distributerName) {
        this.distributerName = distributerName;
    }

    public void setDistributerAddress(String distributerAddress) {
        this.distributerAddress = distributerAddress;
    }
  

    public void setProdToDistDate(String prodToDistDate) {
        this.prodToDistDate = prodToDistDate;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public void setRetailerAddress(String retailerAddress) {
        this.retailerAddress = retailerAddress;
    }

    public void setDistToRetaDate(String distToRetaDate) {
        this.distToRetaDate = distToRetaDate;
    }

    
    public FarmProduct(String productId, String productDescription, String producerName, String producerAddress, String harvestDate, String distributerName, String distributerAddress, String prodToDistDate, String retailerName, String retailerAddress, String distToRetaDate) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.producerName = producerName;
        this.producerAddress = producerAddress;
        this.harvestDate = harvestDate;
        this.distributerName = distributerName;
        this.distributerAddress = distributerAddress;
        this.prodToDistDate = prodToDistDate;
        this.retailerName = retailerName;
        this.retailerAddress = retailerAddress;  
        this.distToRetaDate = distToRetaDate;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public String getProductDescription() {
        return productDescription;
    }
    
    public String getProducerName() {
        return producerName;
    }
    
    public String getProducerAddress() {
        return producerAddress;
    }
    
    public String getHarvestDate() {
        return harvestDate;
    }
    
    public String getDistributerName() {
        return distributerName;
    }
    
    public String getDistributerAddress() {
        return distributerAddress;
   

 }
    
    public String getProdToDistDate() {
        return prodToDistDate;
    }
    
    public String getRetailerName() {
        return retailerName;
    }
    
    public String getRetailerAddress() {
        return retailerAddress;
    }
    
    public String getDistToRetaDate() {
        return distToRetaDate;
    
    }
    @Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
 
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
 
		FarmProduct other = (FarmProduct) obj;
 
	

	return Objects.deepEquals(new String[] { getProductId(), getProductDescription(), getProducerName(), getProducerAddress(),getHarvestDate(), getDistributerName() , getDistributerAddress(), getProdToDistDate(), getRetailerName(), getRetailerAddress(),getDistToRetaDate() },
				new String[] {other.getProductId(), other.getProductDescription(), other.getProducerName(), other.getProducerAddress(),other.getHarvestDate(), other.getDistributerName() , other.getDistributerAddress(), other.getProdToDistDate(), other.getRetailerName(), other.getRetailerAddress(),other.getDistToRetaDate() });
	}    
    @Override
	public int hashCode() {
		return Objects.hash(getProductId(), getProductDescription(), getProducerName(), getProducerAddress(),getHarvestDate(), getDistributerName() , getDistributerAddress(), getProdToDistDate(), getRetailerName(), getRetailerAddress(),getDistToRetaDate());
	}
 
	    
}
