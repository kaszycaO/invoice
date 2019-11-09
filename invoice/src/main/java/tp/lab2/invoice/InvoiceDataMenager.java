package tp.lab2.invoice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Klasa obs�uguj�ca okno faktura
 * 
 * @author Oliwier Kaszyca
 *
 */
public class InvoiceDataMenager implements ActionListener {
	
	/**
	 * obiekt klasy odpowiedzialnej za wy�wietlenie okna z faktur�
	 */
	private InvoiceFrame invoiceFrame;
	
	/**
	 * obiekt klasy przechowuj�cej dane z g��wnych list
	 */
	private DataManager dataManager;
	
	/**
	 * Lista wybranych produkt�w (razem z ich ilo�ci�) w konkretnej fakturze 
	 */
	private ArrayList<ProductsQuantity> currentQuantityOfProducts = new ArrayList<>();
	
	/**
	 * obiekt klasy faktura 
	 */
	private Invoice currInvoice;
	
	 /**
	 * Liczba porz�dkowa "tabeli"
	 */
	private int counter = 1;
	
	/**
	 * id klienta, kt�ry przechodzi przez proces tworzenia faktury 
	 */
	private int currentClientID;
	
	
	/**
	 * Konstruktor klasy
	 * @param invoiceFrame okno programu
	 * @param dataManager klasa odpowiedzialna za baz� danych
	 */
	InvoiceDataMenager(InvoiceFrame invoiceFrame, DataManager dataManager){
		
		this.invoiceFrame = invoiceFrame;
		this.dataManager = dataManager;
		
		
	}

	
	
	

	/**
	 * Metoda tworz�ca graficzn� interpretacj� faktury
	 * @param productID
	 * @param amountOfProduct
	 * @param currentQuantityOfProducts
	 */
	public void drawInvoice(int productID, int amountOfProduct, ArrayList<ProductsQuantity> currentQuantityOfProducts ) {
		
		final double netPrice = dataManager.checkProductPrice(productID, "Netto");
		final double grossPrice = dataManager.checkProductPrice(productID, "Brutto");	
		
		if(grossPrice < 0 && netPrice < 0)
			return;
		
		
		String numberText;
		String productNameText;
		String amountOfProductText;
		String netPriceText;
		String grossPriceProduct;
		String totalNetPrice;
		String totalGrossPrice;
		
		
		numberText = counter + "\n";
		productNameText = dataManager.checkProductName(productID) + "\n";
		amountOfProductText = amountOfProduct + "\n";
		netPriceText = netPrice + "\n";
		grossPriceProduct = grossPrice + "\n";
		totalNetPrice = dataManager.totalProductPrice(netPrice, amountOfProduct) + "\n";
		totalGrossPrice = dataManager.totalProductPrice(grossPrice, amountOfProduct) + "\n";
		
		
		counter++;
		invoiceFrame.setInvoiceText(numberText, productNameText, amountOfProductText, netPriceText, grossPriceProduct, totalNetPrice,totalGrossPrice);
		invoiceFrame.setTotalPriceText(dataManager.totalPrice(currentQuantityOfProducts)+"");
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource() == invoiceFrame.approveProducts) {
			
			final int productID = invoiceFrame.chooseYourProduct();
			final int amountOfProduct = invoiceFrame.getAmountOfProduct();
			
			
			if(productID > 0 && productID <=(dataManager.storedProducts.size()) && amountOfProduct > 0) {
			
			
			final ProductsQuantity currProduct = new ProductsQuantity(productID, amountOfProduct);
			
			
			invoiceFrame.chooseYourProduct.setText("");
			invoiceFrame.amountOfProduct.setText("");
			currentQuantityOfProducts.add(currProduct);
			drawInvoice(productID, amountOfProduct, currentQuantityOfProducts);
			
			
			}
			
			else
			{
				 JOptionPane.showMessageDialog(invoiceFrame,
						    "B��dne dane!",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
				
				
			}
			
			
			
		}
		
		else if(e.getSource() == invoiceFrame.approveInvoice) {
			
			//jeden klient jest ju� w bazie
			currentClientID = dataManager.storedClients.size() - 1;
			currInvoice = new Invoice(currentClientID);
			//w bazie nie ma faktur
			currInvoice.setInvoiceID(dataManager.storedInvoices.size());
			currInvoice.setCurrentQuantityOfProducts(currentQuantityOfProducts);	
			dataManager.storedInvoices.add(currInvoice);
			
			counter = 1;
			invoiceFrame.setVisible(false);
			invoiceFrame.dispose(); 
			
			
			
		}
		
		else if(e.getSource() == invoiceFrame.okButton) {
			
			
			invoiceFrame.setVisible(false);
			invoiceFrame.dispose(); 
			
			
		}
		
		
	}

}
