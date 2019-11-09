package tp.lab2.invoice;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Okienko odpowiedzialne za zebranie danych o kliencie
 * 
 * @author Oliwier Kaszyca
 *
 */
public class ClientInfo extends JPanel{
	
	/**
	 *  miejsce gdzie klient podaje imie
	 */
	private JTextField nameText;
	
	/**
	 *  miejsce gdzie klient podaje nazwisko
	 */
	private JTextField surnameText;
	

	/**
	 *  miejsce gdzie klient podaje adres
	 */
	private JTextField adressText;
	
	/**
	 *  miejsce gdzie klient podaje nip
	 */
	private JTextField nipText;
	
	
	/**
	 * Projekt panelu
	 */
	ClientInfo(){
		
	

		setLayout(new GridLayout(4,2));
		
		
		JLabel nameField = new JLabel("Imie: ");
		add(nameField);
		nameText = new JTextField(1);
		add(nameText);
		
		JLabel surnameField = new JLabel ("Nazwisko: ");
		add(surnameField);
		surnameText = new JTextField(1);
		add(surnameText);

		
		JLabel adressField = new JLabel("Adres: ");
		add(adressField);
		adressText = new JTextField(1);
		add(adressText);
		
	
		JLabel nipField = new JLabel("NIP: ");
		add(nipField);
		nipText = new JTextField(1);
		add(nipText);
		
		
		
		
		
		
	}
	
	
	/**
	 * Pobierz imie
	 * @return imie
	 */
	public String getClientName() {	
		
		return nameText.getText();
		
	}
	
	/**
	 * Pobierz nazwisko
	 * @return nazwisko
	 */
	public String getClientSurname() {	
		
		return surnameText.getText();
		
		
	}	
	
	/**
	 * Pobierz adres	
	 * @return adres
	 */
	public String getClientAdress() {	
		
		return adressText.getText();
		
	}	
	
	
	/**
	 * Pobierz NIP
	 * @return NIP
	 */
	public String getClientNIP() {	
		
			return nipText.getText();
			
		
		
		
	}	
	
	
	
}
	
	
	


