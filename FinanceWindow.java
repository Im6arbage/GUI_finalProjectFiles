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
	JMenuItem m_saveClientList;
	JMenuItem m_loadClientList;
	JMenuItem m_exit;
	JMenuItem m_about;
    
	
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
	
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
    

		super.setBounds(200,200,dim.width-600,dim.height-100);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.add(m_tabbedPane);
		super.setVisible(true);
		
	}
	
	
	public void addClientInfoTab(Client cl)
	{
		JPanel panel = new JPanel();
		m_tabbedPane.addTab(cl.getName(), panel);
	}
	
	
	private void addNewClientTab()
	{
		NewClientPanel newpanel = new NewClientPanel(new Client());
		m_tabbedPane.addTab("New Client", newpanel);	
	}
	
	
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