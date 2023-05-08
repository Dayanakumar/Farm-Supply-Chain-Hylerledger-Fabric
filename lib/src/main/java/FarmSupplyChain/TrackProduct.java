package FarmSupplyChain;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.shim.ChaincodeException;
import org.hyperledger.fabric.shim.ChaincodeStub;
import com.owlike.genson.Genson;


@Contract(
       name = "FarmSupplyChain",
       info = @Info(
               title = "FarmSupplyChain contract",
               description = "A FarmSupply chaincode ",
               version = "0.0.1-SNAPSHOT"))



@Default
public final class TrackProduct implements ContractInterface {
 
	private final Genson genson = new Genson();
	private enum FarmSupplyChainErrors {
		FarmProduct_NOT_FOUND,
        FarmProduct_ALREADY_EXISTS
 

   }
	
	    @Transaction()
	    
	    public void initLedger(final Context ctx) {
	    	
	        ChaincodeStub stub= ctx.getStub();
	        
	        FarmProduct product = new FarmProduct(
	        	    "123",
	        	    "Organic Apples",
	        	    "Dayana",
	                 "4/413 Kunnihatty,Tamil Nadu",
	        	    "2023-04-10",
	        	    "Kairav Distributors",
	        	    "4th st,Gandhipuram,TN",
	        	    "2023-04-11",
	        	    "Praveen Grocery",
	        	    "789 High St, Coimbatore, TN",
	        	    "2023-04-12"
	        	);

	        
	        String FarmProductState = genson.serialize(product);
	        
	        stub.putStringState("123", FarmProductState);
	    }
	    
	    @Transaction()
	
        public FarmProduct addNewFarmProduct(final Context ctx,final String id,final String description,
	    		final String producerName,final String producerAddress, final String harvestDate) {
	        ChaincodeStub stub = ctx.getStub();
	        
	        String FarmProductState = stub.getStringState(id);

	        if (!FarmProductState.isEmpty()) {
	            String errorMessage = String.format("Product %s already exists", id);
	            System.out.println(errorMessage);
	            throw new ChaincodeException(errorMessage, FarmSupplyChainErrors.FarmProduct_ALREADY_EXISTS.toString());
	        }
	        
	        FarmProduct product = new FarmProduct(id, description, producerName, producerAddress, harvestDate, null, null ,null, null, null, null);
	        
	        FarmProductState = genson.serialize(product);
	        
	        stub.putStringState(id, FarmProductState); 
	        
	        return product;
	    }
	    
	    @Transaction()
	   
	    public String transferAssetToDistributor(final Context ctx, final String id,final String distributerName,final String distributerAddress,final String transferDate) throws Exception {
	        // Retrieve the asset from the ledger
	    	ChaincodeStub stub = ctx.getStub();
	       
	    	String AssetToDistState = stub.getStringState(id);
            if (AssetToDistState == null) {
	        	throw new ChaincodeException("Product with id " + id + " does not exist");
	        }
            
	        FarmProduct product = genson.deserialize(AssetToDistState,FarmProduct.class);
	    
	        product.setDistributerName(distributerName);
	        product.setDistributerAddress(distributerAddress);
	        product.setProdToDistDate(transferDate);
             
	        AssetToDistState = genson.serialize(product);
	        stub.putStringState(id, AssetToDistState);
	        
	        // Return the asset id
	        return id;
	    }
	   

	    
	    @Transaction()
	    
	    public String transferAssetToRetailer(Context ctx, String id, String retailerName, String retailerAddress, String transferDate) throws Exception {
	        // Retrieve the asset from the ledger
	        ChaincodeStub stub = ctx.getStub();
	    	
	    	String AssetToRetailerState = stub.getStringState(id);
	        if (AssetToRetailerState == null) {
	            throw new Exception("Asset with id " + id + " does not exist");
	        }
           
            FarmProduct product = genson.deserialize(AssetToRetailerState,FarmProduct.class);
	      
	        // Update the asset with the retailer information
	        product.setRetailerName(retailerName);
	        product.setRetailerAddress(retailerAddress);
	        product.setDistToRetaDate(transferDate);

	        stub.putStringState(id, AssetToRetailerState);
	        return id;
	    }
	    
	    
	    @Transaction()

	    public FarmProduct getAssetById(final Context ctx, final String id) {
	        ChaincodeStub stub = ctx.getStub();
	        
	        String assetState = stub.getStringState(id);
 
	        if(assetState == null || assetState.isEmpty()) {
	        	throw new RuntimeException("Asset with ID: " + id + "does not exist");
	        }
	        
	        FarmProduct asset = genson.deserialize(assetState, FarmProduct.class);
            return asset;
	    }
	    
}

