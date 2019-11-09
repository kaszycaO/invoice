package tp.lab2.invoice;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


/**
 * Okienko tytu³owe
 * @author Oliwier Kaszyca
 *
 */
public class MainFrame extends JFrame{
	
	/**
	 *  Wyœwietl fakturê
	 */
	protected JButton showInvoiceButton;
	
	/**
	 * Dodaj fakturê
	 */
	protected JButton addInvoiceButton;
	
	
	/**
	 * Konstruktor tworz¹cy okienko
	 */
	MainFrame(){
		
		
		//--------------------------------------------------------WINDOW OPTIONS-----------------------------------------------------------------------------------//
		setTitle("Faktury");
		setBounds(860,440,400,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(1,1));
		setResizable(false);
		
		JPanel backGround = new JPanel();
		
		backGround.setLayout(new FlowLayout());
		backGround.setBackground(Color.BLACK);
		
		
		
		
		
		
		
		
		
		
		DataManager dataManager = new DataManager();
		MainAdapter mainAdapter = new MainAdapter(this, dataManager);
		
		showInvoiceButton = new JButton("Wyswietl fakture");
		showInvoiceButton.setSize(100, 100);
		addInvoiceButton = new JButton("Dodaj fakture");
		addInvoiceButton.setSize(100, 100);
		
		showInvoiceButton.addActionListener(mainAdapter);
		addInvoiceButton.addActionListener(mainAdapter);
		
	
		backGround.add(showInvoiceButton);
		backGround.add(addInvoiceButton);
		
		this.add(backGround);
		
		

	
		
	}
	
	
	
	

	
	

}
