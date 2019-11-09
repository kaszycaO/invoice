package tp.lab2.invoice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Klasa obs³uguj¹ca okno faktura
 * 
 * @author Oliwier Kaszyca
 *
 */
public class InvoiceDataMenager implements ActionListener {
	
	/**
	 * obiekt klasy odpowiedzialnej za wyœwietlenie okna z faktur¹
	 */
	private InvoiceFrame invoiceFrame;
	
	/**
	 * obiekt klasy przechowuj¹cej dane z g³ównych list
	 */
	private DataManager dataManager;
	
	/**
	 * Lista wybranych produktów (razem z ich iloœci¹) w konkretnej fakturze 
	 */
	private ArrayList<ProductsQuantity> currentQuantityOfProducts = new ArrayList<>();
	
	/**
	 * obiekt klasy faktura 
	 */
	private Invoice currInvoice;
	
	 /**
	 * Liczba porz¹dkowa "tabeli"
	 */
	private int counter = 1;
	
	/**
	 * id klienta, który przechodzi przez proces tworzenia faktury 
	 */
	private int currentClientID;
	
	
	/**
	 * Konstruktor klasy
	 * @param invoiceFrame okno programu
	 * @param dataManager klasa odpowiedzialna za bazê danych
	 */
	InvoiceDataMenager(InvoiceFrame invoiceFrame, DataManager dataManager){
		
		this.invoiceFrame = invoiceFrame;
		this.dataManager = dataManager;
		
		
	}

	
	
	

	/**
	 * Metoda tworz¹ca graficzn¹ interpretacjê faktury
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
						    "B³êdne dane!",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
				
				
			}
			
			
			
		}
		
		else if(e.getSource() == invoiceFrame.approveInvoice) {
			
			//jeden klient jest ju¿ w bazie
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
