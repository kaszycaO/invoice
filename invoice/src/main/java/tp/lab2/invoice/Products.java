package tp.lab2.invoice;

/**
 * Klasa odpowiedzialna za produkty
 * 
 * @author Oliwier Kaszyca
 *
 */
public class Products {

	/**
	 * nazwa produktu
	 */
    private String productName;
    
    /**
     * cena produktu
     */
    private double productPrice;
    
    /**
     * ID produktu 
     */
    private int productID;
    
    
    




    /**
     * Konstruktor produktu
     * @param productID ID produktu
     * @param productName nazwa produktu
     * @param productPrice cena produktu
     */
    Products(int productID, String productName, double productPrice){

    	this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        

    }

    public String getProductName(){

        return productName;

    }

    public double getProductPrice(){

  
        return Math.round(productPrice * 100.0)/100.0;
        

    }
    
    
    public int getProductID(){

        return productID;

    }
    
    public double getGrossPrice(){
    	
  
    	return Math.round((productPrice + 0.23 * productPrice)*100.0)/100.0;
    	
    }
    


}
