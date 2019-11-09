package tp.lab2.invoice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Klasa obs�uguj�ca g��wne okno (przed oknem z faktur�)
 * @author Oliwier Kaszyca
 *
 */
public class MainAdapter implements ActionListener {


	/**
	 * Okienko wy�wietlaj�ce si� jako pierwsze
	 */
	private MainFrame mainFrame;
	
	/**
	 * Okno z GUI
	 */
	private InvoiceFrame invoiceFrame;
	
	/**
	 * Baza danych
	 */
	private DataManager dataManager;
	
	/**
	 * Klasa obs�uguj�ca okno z faktur�
	 */
	private InvoiceDataMenager invoiceDataMenager; 
	
	/**
	 * Panel w kt�rym podajemy dane u�ytkownika
	 */
	private InsertIDPanel idPanel;
	
	/**
	 * obecne id klienta
	 */
	private int currentClientID;
	
	/**
	 * obecne id faktury
	 */
	private int currentInvoiceID;
	

	


	
	/**
	 * Konstruktor
	 * @param mainFrame
	 * @param dataManager
	 */
	MainAdapter(MainFrame mainFrame, DataManager dataManager){
		
		dataManager.addProductsToShop();
		this.mainFrame = mainFrame;
		this.dataManager = dataManager;
		

	
	}
	


	

	/**
	 * Metoda odpowiedzialna za obs�ug� zdarze� (przed oknem z faktur�)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
	// Wy�wietlanie faktury	
	if(e.getSource() == mainFrame.showInvoiceButton) {
			
			idPanel = new InsertIDPanel();
			
		
			final int addNewClient = JOptionPane.showConfirmDialog(mainFrame,idPanel,"Podaj kolejno ID klienta i ID umowy",JOptionPane.OK_CANCEL_OPTION);
		
			currentClientID = idPanel.getID();
			currentInvoiceID = idPanel.getInvoiceID();
			
		if(currentClientID >= 0 && currentInvoiceID >= 0) {
			
			if(addNewClient == JOptionPane.OK_OPTION && dataManager.storedInvoices.get(currentInvoiceID).getClientID() == currentClientID) {
			
				invoiceFrame = new InvoiceFrame(dataManager); 
				invoiceFrame.setGlobalText(currentClientID);
				invoiceFrame.prepareToShowInvoice();
				invoiceFrame.setVisible(true);
				
				invoiceDataMenager = new InvoiceDataMenager(invoiceFrame, dataManager); 
			
				ArrayList<ProductsQuantity> currentQuantity = new ArrayList<>();
				currentQuantity = dataManager.storedInvoices.get(currentInvoiceID).getCurrentQuantityOfProducts();
			
			
				for(int i = 0; i < currentQuantity.size() ; i++) {
				
					invoiceDataMenager.drawInvoice(currentQuantity.get(i).getProductID(), currentQuantity.get(i).getProductQuantity(),currentQuantity);
				
				
				}
						
			
			
			
			}
			
			else {
				 JOptionPane.showMessageDialog(invoiceFrame,
						    "B��dne dane!",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
				
				
			}
			
			
			
		
		
		}
		
		else {
			 JOptionPane.showMessageDialog(invoiceFrame,
					    "B��dne dane!",
					    "Inane error",
					    JOptionPane.ERROR_MESSAGE);
			
			
		}
		
		
		
		
}
	
	
	
	// Dodaj faktur�
	else if(e.getSource() == mainFrame.addInvoiceButton) {
		
		final int confirmPane = JOptionPane.showConfirmDialog(mainFrame, "Czy klient istnieje w bazie danych?","INFO", JOptionPane.YES_NO_OPTION);
		
		// Brak klient�w w bazie
			if(confirmPane == JOptionPane.NO_OPTION ) {
				
				final ClientInfo clientInfo= new ClientInfo();
				final int addNewClient = JOptionPane.showConfirmDialog(mainFrame,clientInfo,"Wybierz opcj�",JOptionPane.OK_CANCEL_OPTION); 
				
				currentClientID = dataManager.storedClients.size();
			
				final Clients client = new Clients(currentClientID,clientInfo.getClientName(),clientInfo.getClientSurname(),
							clientInfo.getClientAdress(), clientInfo.getClientNIP());
							
				dataManager.storedClients.add(client);
		

				if(addNewClient == JOptionPane.OK_OPTION) {
					
					invoiceFrame = new InvoiceFrame(dataManager); 
					invoiceFrame.setGlobalText(currentClientID);
					invoiceFrame.prepareToAddInvoice(); 
					invoiceFrame.setVisible(true);
					
					
				}
				
			
			}
			
			//S� klienci w bazie
			else if(confirmPane == JOptionPane.YES_OPTION) {
				
				idPanel = new InsertIDPanel();
				idPanel.invoiceTextVisible(false);

				int addNewClient = JOptionPane.showConfirmDialog(mainFrame,idPanel,"Podaj ID klienta",JOptionPane.OK_CANCEL_OPTION);
				
				currentClientID = idPanel.getID();
				
				
				if(currentClientID >= 0) {
					if(addNewClient == JOptionPane.OK_OPTION) {
					
						invoiceFrame = new InvoiceFrame(dataManager); 
						invoiceFrame.setGlobalText(currentClientID);
						invoiceFrame.prepareToAddInvoice(); 
						invoiceFrame.setVisible(true);
					
				
					}
					
				}
				
				
				else {
					
					 JOptionPane.showMessageDialog(invoiceFrame,
								    "B��dne dane!",
								    "Inane error",
								    JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
			
		
		}
		
		
	}


	
}
