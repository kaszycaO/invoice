package tp.lab2.invoice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;




/**
 *  GUI 
 * @author Oliwier Kaszyca
 *
 */
public class InvoiceFrame extends JFrame {
	
	
	/**
	 * Klasa z danymi 
	 */
	private DataManager dataManager;
	
	/**
	 * panel z danymi o kliencie i w�a�cicielu
	 */
	private JPanel mainPanel;
	
	/**
	 * Panel z dost�pnymi produktami
	 */
	private JPanel productsPanel; 
	
	/**
	 * Panel wy�wietlaj�cy obecn� faktur�
	 */
	private JPanel currentInvoice;
	
	/**
	 * Wy�wietla dane klienta
	 */
	private JTextArea clientInfo;
	
	/**
	 * Wy�wietla dane w�a�ciciela
	 */
	private JTextArea ownerInfo;
	
	/**
	 * Wy�wietla dost�pne produkty
	 */
	private JTextArea listOfProducts;
	
	/**
	 * Wy�wietla liczbe porz�dkow� (tabela)
	 */
	private JTextArea drawInvoiceLP;
	
	/**
	 * Wy�wietla nazw� produktu (tabela)
	 */
	private JTextArea drawInvoiceName;
	
    /**
     * Wy�wietla ilosc produkt�w (tabela)
     */
	private JTextArea drawInvoiceQuantity;
	
	/**
	 * Wy�wietla cen� netto (tabela)
	 */
	private JTextArea drawInvoiceNetPrice;
	
	/**
	 * Wy�wietla cen� brutto (tabela)
	 */
	private JTextArea drawInvoiceGrossPrice;
	
	/**
	 * Wy�wietla ca�kowit� cen� netto (tabela)
	 */
	private JTextArea drawInvoiceTotalNet;
	
	/**
	 * Wy�wietla ca�kowit� cen� brutto
	 */
	private JTextArea drawInvoiceTotalGross;
	
	/**
	 *  Podaj id produktu
	 */
	protected JTextField chooseYourProduct;
	
	/**
	 * podaj ilosc produktu
	 */
	protected JTextField amountOfProduct;
	
	
	/**
	 * Zatwierdz produkt
	 */
	protected JButton approveProducts;
	
	/**
	 * Zatwierdz faktur� 
	 */
	protected JButton approveInvoice;
	
	/**
	 * Zakoncz ogl�danie faktury
	 */
	protected JButton okButton;
	
	/**
	 * Wy�wietla ostateczn� cen� brutto (wszystkich produkt�w) 
	 */
	protected JLabel totalPrice;
	
	/**
	 * Informacja "Razem: "
	 */
	protected JLabel totalPriceInfo;
	

	
	
	


	/**
	 * Konstruktor
	 * @param dataManager
	 */
	InvoiceFrame(DataManager dataManager){
		
		
		this.dataManager = dataManager;
		InvoiceDataMenager menager = new InvoiceDataMenager(this, dataManager);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setLayout(new BorderLayout());
		
	
		
		//-----------------------------------------------------Header------------------------------------------------------------------//
		
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1960,400));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new BorderLayout());
		
		clientInfo = new JTextArea();
		clientInfo.setPreferredSize(new Dimension(400, 400));
		clientInfo.setEditable(false);
		clientInfo.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 22));
		
		
		ownerInfo = new JTextArea();
		ownerInfo.setPreferredSize(new Dimension(400, 400));
		ownerInfo.setEditable(false);
		ownerInfo.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 22));
		
	
		mainPanel.add(clientInfo,BorderLayout.WEST);
		mainPanel.add(ownerInfo,BorderLayout.EAST);
		
		
	
		
	
		
		//-----------------------------------------------------Current Invoice------------------------------------------------------------------//
		
		currentInvoice = new JPanel();
		currentInvoice.setPreferredSize(new Dimension(660,300));
		currentInvoice.setBackground(Color.GREEN);
		currentInvoice.setLayout(new BorderLayout());
		
		
		// kontener na przyciski i labele znajduj�ce si� na dole
		JPanel labelPanel = new JPanel();
		// kontener na text wy�wietlanej faktury
		JPanel textPanel = new JPanel();
		
		labelPanel.setLayout(new GridLayout(1,3));
		textPanel.setLayout(new GridLayout(1,7));

		
		
		
		approveInvoice = new JButton("Zapisz faktur�");
		okButton = new JButton("OK");
		okButton.setVisible(false);
		approveInvoice.addActionListener(menager);
		okButton.addActionListener(menager);
		
		totalPriceInfo = new JLabel("Razem: ");
		totalPriceInfo.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
	
		totalPrice = new JLabel();
		totalPrice.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 15));
		
		
		labelPanel.add(totalPriceInfo);
		labelPanel.add(totalPrice);
		labelPanel.add(okButton);
		labelPanel.add(approveInvoice);
		
		drawInvoiceLP = new JTextArea("LP \n\n");
		drawInvoiceName = new JTextArea("Nazwa Produktu \n\n");
		drawInvoiceQuantity = new JTextArea("Ilosc \n\n");
		drawInvoiceNetPrice = new JTextArea("Netto \n\n");
		drawInvoiceGrossPrice = new JTextArea("Brutto \n\n");
		drawInvoiceTotalNet = new JTextArea("Suma Netto \n\n");
		drawInvoiceTotalGross = new JTextArea("Suma Brutto \n\n");
		
		setTextAreaProp(drawInvoiceLP);
		setTextAreaProp(drawInvoiceName);
		setTextAreaProp(drawInvoiceQuantity);
		setTextAreaProp(drawInvoiceNetPrice);
		setTextAreaProp(drawInvoiceGrossPrice);
		setTextAreaProp(drawInvoiceTotalNet);
		setTextAreaProp(drawInvoiceTotalGross);
		
		textPanel.add(drawInvoiceLP);		
		textPanel.add(drawInvoiceName);		
		textPanel.add(drawInvoiceQuantity);		
		textPanel.add(drawInvoiceNetPrice);		
		textPanel.add(drawInvoiceGrossPrice);		
		textPanel.add(drawInvoiceTotalNet);		
		textPanel.add(drawInvoiceTotalGross);		
				
		
		
	
		currentInvoice.add(labelPanel,BorderLayout.PAGE_END);
		currentInvoice.add(textPanel,BorderLayout.CENTER);

		
		
		//-----------------------------------------------------Choose your product------------------------------------------------------------------//
		
	   	 productsPanel = new JPanel();
		 productsPanel.setLayout(new GridLayout(2,1));
		 productsPanel.setPreferredSize(new Dimension(300,300));
		 productsPanel.setBackground(Color.CYAN);
		
	
		 approveProducts = new JButton("Zatwierdz");
		 approveProducts.addActionListener(menager);
		
		
		 listOfProducts = new JTextArea();
		 listOfProducts.setEditable(false);
		 listOfProducts.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 20));
		
		 JLabel chooseProduct = new JLabel("Podaj id produktu: ");
		 JLabel chooseAmount = new JLabel("Podaj ilosc: ");
		
		 chooseYourProduct = new JTextField(1);
		 amountOfProduct = new JTextField(1);
		 
		 //kontener na panel z produktami
		 JPanel helper = new JPanel();
		 helper.setBackground(Color.LIGHT_GRAY);
		 
		 helper.setPreferredSize(new Dimension(300,100));
		 helper.setLayout(new GridLayout(6,1));
		 helper.add(chooseProduct);
		 helper.add(chooseYourProduct);
		 helper.add(chooseAmount);
		 helper.add(amountOfProduct);
		 helper.add(approveProducts);
		 
	
		 productsPanel.add(helper);
		 productsPanel.add(listOfProducts);
		 setListOfProducts();
		
		
	
		 //------------------------------------------------------ADD TO FRAME -------------------------------------------------------------------------------------------//
		 
		add(productsPanel, BorderLayout.WEST);
		add(mainPanel, BorderLayout.NORTH);
		add(currentInvoice, BorderLayout.CENTER);
		
		
		
	}
	
	
	
	/**
	 * Usstawia tekst zawieraj�cy informacje o cenie ostatecznej
	 * @param text
	 */
	public void setTotalPriceText(String text) {
		
		totalPrice.setText("");
		totalPrice.setText(text);
		
	}
	
	
	/**
	 * Wy�wietla tabele faktury
	 * @param textNum LP
	 * @param textName Nazwa
	 * @param textQuantity Ilosc
	 * @param textNet Cena netto
	 * @param textGross Cena brutto
	 * @param textTotalNet Suma netto
	 * @param textTotalGross Suma brutto
	 */
	public void setInvoiceText(String textNum, String textName, String textQuantity, String textNet, String textGross, String textTotalNet, String textTotalGross) {
		
		addText(drawInvoiceLP, textNum);
		addText(drawInvoiceName, textName);
		addText(drawInvoiceQuantity,textQuantity);
		addText(drawInvoiceNetPrice, textNet);
		addText(drawInvoiceGrossPrice, textGross);
		addText(drawInvoiceTotalNet,textTotalNet);
		addText(drawInvoiceTotalGross,textTotalGross);
		
		
		
	}
	
	/**
	 * Ustawienia textArea
	 * @param textArea 
	 */
	public final void setTextAreaProp(JTextArea textArea) {
		
		textArea.setEditable(false);
		textArea.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 18));
		
		
		
	}
	
	/**
	 * Dodaj tekst do pola przechowuj�cego tekst
	 * @param textArea
	 * @param text
	 */
	public void addText(JTextArea textArea, String text) {
		
		String currText = textArea.getText();
		textArea.setText("");
		currText += text;
		textArea.setText(currText);
		
	}
	
	
	/**
	 * Wy�wietlanie info nt w�a�ciciela i kupuj�cego
	 * @param clientID
	 */
	public void setGlobalText(int clientID) {
		
		final String nazwa =	"\n   Kupuj�cy: \n\n    "+
					dataManager.getClientInfo(clientID,"Imie") + "\n    " +
					dataManager.getClientInfo(clientID,"Nazwisko") + "\n    " +
					dataManager.getClientInfo(clientID,"Adres") + "\n    " +
					dataManager.getClientInfo(clientID,"NIP");
		
		clientInfo.setText(nazwa);
	
		
		
		
		final String owner = "\nSprzedaj�cy: \n\n"+
					"Oliwier\nKaszyca\nul. Reja 11\nWroc�aw\n1234567890";
		
		ownerInfo.setText(owner);
		
	}
	
	/**
	 * Wypisuje wszystkie dost�pne produkty
	 */
	public final void setListOfProducts(){
		
		
		String produkty = "Dostepne produkty: \n\n";
		
		for(int i = 0; i <  dataManager.storedProducts.size(); i++) {
			
			
			produkty+= dataManager.storedProducts.get(i).getProductID() + " " +
					dataManager.storedProducts.get(i).getProductName() + "\n";
			
			
		}
		
		
		listOfProducts.setText(produkty);
		
	}
	
	/**
	 * Zczytuje ilosc produktu z odpowiedniego pola
	 * @return
	 */
	public int getAmountOfProduct() {
		

			try {
				
				final int liczba = Integer.parseInt(amountOfProduct.getText());
				return liczba;
			}
			catch(NumberFormatException e){
				
				return 0;
				
			}
	
	}
	
	/**
	 * Zczytuje id produktu z odpowiedniego pola
	 * @return
	 */
	public int chooseYourProduct(){
		 
		 try {
		 final int liczba = Integer.parseInt(chooseYourProduct.getText());
		 
		 return liczba;
		 
		 } 
		 catch(NumberFormatException e) {
			 
				return 0;
			 
		 }
		 
		 
	 }
	 
	
	/**
	 * Przygotowuje odpowiedni widok GUI (wy�wietl faktur�)
	 */
	public void prepareToShowInvoice() {
		
		approveInvoice.setVisible(false);
		okButton.setVisible(true);
		productsPanel.setVisible(false);
		
		
		
		
	}
	
	/**
	 * Przygotowuje odpowiedni widok GUI (dodaj faktur�)
	 */
	public void prepareToAddInvoice() {
		
		okButton.setVisible(false);
		approveInvoice.setVisible(true);
		productsPanel.setVisible(true);
		
		
		
		
	}
	

}
