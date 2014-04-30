import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;



public class FinanceWindow extends JFrame implements ActionListener{
	
	JTabbedPane m_tabbedPane;
	
	ClientManager m_clientmanager;
	
	JMenuBar m_menubar = new JMenuBar();
	JMenu m_fileMenu;
	JMenu m_helpMenu;
	JMenuItem m_newClient;
	JMenuItem m_export;
	JMenuItem m_exit;
	JMenuItem m_about;
	
	private int m_currTab;
	Image image;
    
	/************************************************
	 * Class: FinanceWindow
	 * Method: FinanceWindow()
	 *
	 * Author: Cody Herring/Justin Brumley
	 *
	 * This is the default constructor which
	 * initializes the window along with menu items
	 * and their event handlers
	 *************************************************/
	public FinanceWindow() 
	{
		super("HerrBrum Finance Calculator");
		m_currTab = 0;
		m_clientmanager = new ClientManager();
		
		m_tabbedPane = new JTabbedPane();
		
		m_newClient = new JMenuItem("New Client");
		m_newClient.addActionListener(this);
		m_export = new JMenuItem("Export");
		m_export.addActionListener(this);
		m_exit = new JMenuItem("Exit");
		m_exit.addActionListener(this);
		
		m_about = new JMenuItem("About");
		m_about.addActionListener(this);
		
		m_fileMenu = new JMenu("File");
		m_fileMenu.add(m_newClient);
		m_fileMenu.add(m_export);
		m_fileMenu.add(m_exit);
		
		m_helpMenu = new JMenu("Help");
		m_helpMenu.add(m_about);
		
		m_menubar.add(m_fileMenu);
		m_menubar.add(m_helpMenu);
		
		super.setJMenuBar(m_menubar);
	
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
    

		super.setBounds(200,200,dim.width-600,dim.height-100);
		super.setSize(650, 700);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.add(m_tabbedPane);
		super.setVisible(true);
		
	}
	
	/************************************************
	 * Class: FinanceWindow
	 * Method: paint(Graphics g)
	 *
	 * Author: Cody Herring/Justin Brumley
	 *
	 * This method should display the HerrBrum
	 * picture.
	 ************************************************/
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(image, 20, 150, null);
	}
	
	/************************************************
	 * Class: FinanceWindow
	 * Method: addClientInfoTab()
	 *
	 * Author: Cody Herring/Justin Brumley
	 * 
	 ************************************************/
	public void addClientInfoTab(Client cl)
	{
		ClientPanel panel = new ClientPanel(cl);
		m_tabbedPane.addTab(cl.getName(), panel);
		m_clientmanager.addClient(cl);
		m_currTab++;
	}
	
	/************************************************
	 * Class: FinanceWindow
	 * Method: removePreviousTab()
	 * 
	 * Author: Justin Brumley
	 * 
	 * This method removes the New Client tab after
	 * submission.
	 ************************************************/
	public void removePreviousTab()
	{
		m_tabbedPane.remove(m_currTab - 1);
	}
	
	
	/************************************************
	 * Class: FinanceWindow
	 * Method: addNewClientTab()
	 *
	 * Author: Cody Herring/Justin Brumley
	 * 
	 ************************************************/
	private void addNewClientTab()
	{
		NewClientPanel newpanel = new NewClientPanel(new Client());
		m_tabbedPane.addTab("New Client", newpanel);
	}
	
	/************************************************
	 * Class: FinanceWindow
	 * Method: actionPerformed(ActionEvent arg)
	 *
	 * Author: Cody Herring/Justin Brumley
	 *
	 * This is the method that handles events for
	 * menu items exit, new client, 
	 ************************************************/
	public void actionPerformed(ActionEvent arg) {
		Object ev = arg.getSource();
		if(ev == m_exit)
		{
			System.exit(0);
		}
		else if(ev == m_newClient)
		{
			addNewClientTab();
		}
		else if(ev == m_export)
		{
			m_clientmanager.saveClient(((ClientPanel) m_tabbedPane.getSelectedComponent()).getAssociatedClient().getName());
		}
		else if(ev == m_about)
		{
			JOptionPane.showMessageDialog(null, "Cody Herring and Justin Brumley\n                CS 315-01\n              Spring 2014");
		}
	}
}