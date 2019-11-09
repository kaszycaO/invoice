package tp.lab2.invoice;

import java.util.ArrayList;


/**
 * Klasa odpowiedzialna za bazê danych
 * 
 * @author Oliwier Kaszyca
 *
 */
public class DataManager {
	
	
	/**
	 * Lista przechowywuj¹ca produkty dostepne w sklepie
	 */
	protected ArrayList<Products> storedProducts = new ArrayList<>();
	
	/**
	 * lista przechowywuj¹ca faktury
	 */
	protected ArrayList<Invoice> storedInvoices = new ArrayList<>();

	/**
	 * lista przechowuj¹ca dodanych klientów
	 */
	protected ArrayList<Clients> storedClients = new ArrayList<>();
	

	
	/**
	 * Metoda dodaj¹ca produkty bêd¹ce w ofercie
	 */
	public void addProductsToShop() {
		
	    final Products nails = new Products(1,"Gwozdzie", 0.2);
	    final Products screws = new Products(2,"Wkrety", 0.4);
	    final Products bolts = new Products(3,"Sruby", 0.3);
	    final Products hammer = new Products(4,"Mlotek", 20.99);
	    final Products drillDriver = new Products(5,"Wkretarka", 150);
	    final Products nuts = new Products(6,"Nakretki", 0.1);
	    final Products washers = new Products(7,"Podkladki", 0.05);
        
        storedProducts.add(nails);
        storedProducts.add(screws);
        storedProducts.add(bolts);
        storedProducts.add(hammer);
        storedProducts.add(drillDriver);
        storedProducts.add(nuts);
        storedProducts.add(washers);
		
	}	
	
	
	/**
	 * Metoda sprawdzaj¹ca cenê produktu 
	 * @param productID 
	 * @param type BRUTTO lub NETTO
	 * @return cena produktu
	 */
	public double checkProductPrice(int productID, String type) {
		

		
		for(int i = 0; i < storedProducts.size(); i++) {
			
			if(storedProducts.get(i).getProductID() == productID) {
				
				if(type.equals("Netto"))
					return storedProducts.get(i).getProductPrice();
				else if(type.equals("Brutto"))
					return storedProducts.get(i).getGrossPrice();
			}
		}
		
		return -2;
		
		
	}
	
	
	/**
	 * Metoda licz¹ca ca³kowit¹ cenê BRUTTO
	 * @param currentQuantity lista z obecn¹ iloœci¹ i ID produktu
	 * @return ca³kowita cena BRUTTO
	 */
	public double totalPrice(ArrayList<ProductsQuantity> currentQuantity) {
			
		
		double sum = 0;
		int productID;
		int amountOfProduct;
		double grossPrice;
		
		for(int i = 0; i < currentQuantity.size(); i++) {
			
			
			productID = currentQuantity.get(i).getProductID();
			amountOfProduct = currentQuantity.get(i).getProductQuantity();
			grossPrice = checkProductPrice(productID, "Brutto");
			sum += totalProductPrice(grossPrice, amountOfProduct);
			
			
		}
			
			return Math.round(sum * 100.0)/100.0;
	
	}
	
	/**
	 * Metoda licz¹ca ca³kowit¹ cenê dodanego produktu
	 * @param price cena
	 * @param amountOfProduct ilosc produktu
	 * @return
	 */
	public double totalProductPrice(double price, int amountOfProduct) {
		
		return Math.round(amountOfProduct * price* 100.0)/100.0;

	}
	

	/**
	 * Metoda sprawdzaj¹ca nazwê produktu
	 * @param productID 
	 * @return nazwa produktu, lub "brak" gdy nie ma go na liœcie
	 */
	public String checkProductName(int productID) {
		
		for(int i = 0; i < storedProducts.size(); i++) {
			
			if(storedProducts.get(i).getProductID() == productID) 
				return storedProducts.get(i).getProductName();
		
		}
		
		return "brak";
		
		
	}
	
	/**
	 * Info nt klienta
	 * @param clientID podaj id
	 * @param typeOfInfo podaj typ informacji
	 * @return
	 */
	public String getClientInfo(int clientID, String typeOfInfo) {
		
		for(int i = 0; i < storedClients.size() ;i++) {
			
			if(storedClients.get(i).getClientID() == clientID) {
				
				if(typeOfInfo == "Imie") { return storedClients.get(i).getClientName(); }
				if(typeOfInfo == "Nazwisko") { return storedClients.get(i).getClientSurname(); }
				if(typeOfInfo == "Adres") { return storedClients.get(i).getClientAdress(); }
				if(typeOfInfo == "NIP") { return storedClients.get(i).getClientNIP(); }
				
				
				
			}
			
			
		}
		
		return "brak";
		
	}
	


}
