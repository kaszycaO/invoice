package tp.lab2.invoice;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProductTest {
	
	
	
	 @Test
	    public void checkGrossPrice() {
	        
		 	Products produkt = new Products(1,"Gwozdzie",0.15);
		 	assertEquals(produkt.getGrossPrice(), 0.18, 0.001);
	    }

}
