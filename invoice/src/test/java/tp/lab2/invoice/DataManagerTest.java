package tp.lab2.invoice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DataManagerTest {
	
	
	private DataManager dataManager;
	private ArrayList<ProductsQuantity> currentQuantity;
	
	@Before
	public void createProducts() {
		
			final Products nails = new Products(1,"Gwozdzie", 0.2);
	    	final Products screws = new Products(2,"Wkrety", 0.4);
	    
			currentQuantity = new ArrayList<>();
			
		    dataManager = new DataManager();
		    dataManager.storedProducts.add(nails);
	        dataManager.storedProducts.add(screws);
	   
	        
	        ProductsQuantity productsQuantity_1 = new ProductsQuantity(1,5); 
	        ProductsQuantity productsQuantity_2 = new ProductsQuantity(2,5); 
	        
	        currentQuantity.add(productsQuantity_1);
	        currentQuantity.add(productsQuantity_2);
	        
	    
			
		    
		
		
		
	}
	
	
		
	
	@Test
	public void checkMethods() {
		        
			 assertEquals(dataManager.checkProductPrice(1,"Netto"), 0.2, 0.001);
			 assertEquals(dataManager.checkProductPrice(1,"Brutto"), 0.25, 0.01);
			 assertEquals(dataManager.totalPrice(currentQuantity), 3.7, 0.01);
			 assertEquals(dataManager.checkProductName(2), "Wkrety");
			 
	}



	

}
