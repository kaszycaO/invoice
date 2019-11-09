package tp.lab2.invoice;

/**
 * Klasa odpowiedzialna za ilosc produktów
 * 
 * @author Oliwier Kaszyca
 *
 */
public class ProductsQuantity {
	
	
	/**
	 * ID produktu
	 */
	private int productID; 
	/**
	 * ilosc produktu
	 */
	private int productQuantity; 
	
	
	/**
	 * Konstruktor klasy 
	 * 
	 * @param productID id produktu
	 * @param productQuantity ilosc produktów
	 */
	ProductsQuantity(int productID, int productQuantity){
		
		this.productID = productID;
		this.productQuantity = productQuantity;
		
		
		
	}

	
	public int getProductQuantity() {
		return productQuantity;
	}

	
	
	public int getProductID() {
		return productID;
	}

}
