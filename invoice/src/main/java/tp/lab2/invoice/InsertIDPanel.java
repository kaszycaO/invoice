package tp.lab2.invoice;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Panel pobieraj�cy informacje o id faktury i klienta
 * @author Oliwier Kaszyca
 *
 */
public class InsertIDPanel extends JPanel {
	
	/**
	 * pole w kt�re podajemy id klienta
	 */
	private JTextField clientIDText;
	
	/**
	 * pole w kt�re podajemy id faktury
	 */
	private JTextField invoiceIDText;
	
	/**
	 * Projekt panelu
	 */
	InsertIDPanel(){
		
		setLayout(new GridLayout(3,2));
		
		clientIDText = new JTextField();
		invoiceIDText = new JTextField();
	
		add(clientIDText);
		add(invoiceIDText);
	
	}
	
	
	public int getID() {
		
		try {
			
			return Integer.parseInt(clientIDText.getText());
			
		} catch(NumberFormatException e) {
			
			return -1;
		 }
	}
		
	public int getInvoiceID() {
		
		try {
			
			int i = Integer.parseInt(invoiceIDText.getText());
			
			return i;
			
		} catch(NumberFormatException e) {
			
			return -1;
			
		 }
		
		
	}
	
	/**
	 * W zale�no�ci od potrzeby zmiana widoczno�ci invoiceIDText
	 * @param statement true lub false
	 */
	public void invoiceTextVisible(boolean statement) {
		
		
		if(statement) {
			
			invoiceIDText.setVisible(true);
			
		}
		
		else
			invoiceIDText.setVisible(false);
			
		
	}
		
		
	


}
