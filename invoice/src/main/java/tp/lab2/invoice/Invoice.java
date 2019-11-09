package tp.lab2.invoice;

import java.util.ArrayList;

/**
 * Klasa odpowiedzialna za faktur�
 * @author Oliwier Kaszyca
 *
 */
public class Invoice {
	
	/**
	 * Lista z ilo�ci� i nazw� produktu
	 */
	private ArrayList<ProductsQuantity> currentQuantityOfProducts = new ArrayList<>();
	
	
	/**
	 * ID faktury
	 */
	private int invoiceID;
	/**
	 * ID klienta
	 */
	private int clientID;
	
	/**
	 * Konstruktor faktury
	 * 
	 * @param invoiceID id faktury
	 * @param clientID id klienta
	 */
	 Invoice(int clientID){

	        this.clientID = clientID;
	    }

	public int getClientID() {
		return clientID;
	}



	public int getInvoiceID() {
		return invoiceID;
	}



	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	
	public ArrayList<ProductsQuantity> getCurrentQuantityOfProducts() {
		return currentQuantityOfProducts;
	}

	public void setCurrentQuantityOfProducts(ArrayList<ProductsQuantity> currentQuantityOfProducts) {
		this.currentQuantityOfProducts = currentQuantityOfProducts;
	}
	
	
	
	
}
