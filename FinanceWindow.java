import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Graphics;




public class FinanceWindow extends JFrame implements ActionListener{
	
	JTabbedPane m_tabbedPane;
	
	ClientManager m_clientmanager;
	
	JMenuBar m_menubar = new JMenuBar();
	JMenu m_fileMenu;
	JMenu m_helpMenu;
	JMenuItem m_newClient;
	JMenuItem m_saveClientList;
	JMenuItem m_loadClientList;
	JMenuItem m_exit;
	JMenuItem m_about;
	
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
	 ************************************************/

	public FinanceWindow() 
	{
		super("HerrBrum Finance Calculator");
		
		m_clientmanager = new ClientManager();
		
		m_tabbedPane = new JTabbedPane();
		
		m_newClient = new JMenuItem("New Client");
		m_newClient.addActionListener(this);
		m_saveClientList = new JMenuItem("Save");
		m_loadClientList = new JMenuItem("Load");
		m_exit = new JMenuItem("Exit");
		m_exit.addActionListener(this);
		
		m_about = new JMenuItem("About");
		m_about.addActionListener(this);
		
		m_fileMenu = new JMenu("File");
		m_fileMenu.add(m_newClient);
		m_fileMenu.add(m_saveClientList);
		m_fileMenu.add(m_loadClientList);
		m_fileMenu.add(m_exit);
		
		m_helpMenu = new JMenu("Help");
		m_helpMenu.add(m_about);
		
		m_menubar.add(m_fileMenu);
		m_menubar.add(m_helpMenu);
		
		super.setJMenuBar(m_menubar);
	
		image = Toolkit.getDefaultToolkit().createImage("/Users/codyherring/Desktop/Final_Project_Source_2/Startup_Image.jpg");
		

		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		
		
		super.setBounds(200,200,dim.width-600,dim.height-100);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.add(m_tabbedPane);
		super.setVisible(true);
		super.setResizable(false);
		
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
		JPanel panel = new JPanel();
		m_tabbedPane.addTab(cl.getName(), panel);
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
	}
}