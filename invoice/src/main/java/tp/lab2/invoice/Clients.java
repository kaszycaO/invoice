package tp.lab2.invoice;

/**
 *  Klasa odpowiedzialna za klienta
 * @author Oliwier Kaszyca
 *
 */
public class Clients {
	
	/**
	 * ID klienta
	 */
	private final int clientID;
	
	/**
	 *  imie klienta
	 */
	private final String clientName;
	
	/**
	 *  nazwisko klienta
	 */
	private final String clientSurname;
	/**
	 *  adres klienta
	 */
	private final String clientAdress;
	
	/**
	 *  NIP klienta
	 */
	private final String clientNIP;
	
	
	/**
	 * Konstruktor klienta
	 * @param clientID
	 * @param clientName
	 * @param clientSurname
	 * @param clientAdress
	 * @param clientNIP
	 */
	Clients(int clientID, String clientName, String clientSurname, String clientAdress, String clientNIP){
		
		this.clientID = clientID;
		this.clientName = clientName;
		this.clientSurname = clientSurname;
		this.clientAdress = clientAdress;
		this.clientNIP = clientNIP;
		
		
	}



	public int getClientID() {
		return clientID;
	}



	public String getClientSurname() {
		return clientSurname;
	}



	public String getClientName() {
		return clientName;
	}



	public String getClientAdress() {
		return clientAdress;
	}



	public String getClientNIP() {
		return clientNIP;
	}
	
	
	
	
	
	

}
