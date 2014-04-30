import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.util.*;
import java.awt.*;

public class NewClientPanel extends JPanel implements ActionListener{
	
	// Submit client information labels
	private JLabel clientname;
	private JTextField name;
	private JLabel whatpercent; 
	private JLabel grossincome; 
	private JTextField gross; 
	private JLabel expenses; 
    
	// Example fields (ex: 200.00);
	private JTextField gasex; 
	private JTextField foodex; 
	private JTextField billsex; 
	private JTextField entex; 
	
	// Expense Labels
	private JLabel gas; 
	private JLabel food; 
	private JLabel bills;
	private JLabel entertainment; 
	
	// Desired percentage to save
	private JRadioButton tenpercent; 
	private JRadioButton fifteenpercent; 
	private JRadioButton twentypercent; 
	private Client m_clientinfo;
	
	ButtonGroup group; 
	
	private JButton submit; 
	
	// money icon symbol in new client tab
	ImageIcon icon; 
	JLabel iconlabel; 

	// strings for radio buttons
	static String ten = "10%";	
	static String fifteen = "15%";	
	static String twenty = "20%"; 	
	
	/************************************************
	 * Class: NewClientPanel
	 * Method: NewClientPanel(client cl)
	 *
	 * Author: Cody Herring
	 *
	 * This is the default constructor. It initializes
	 * the graphics, text fields, labels, radio
	 * buttons and all fields other attributes
	 * inside the new client tab.
	 ************************************************/	
	public NewClientPanel(Client cl)
	{
		super();
		m_clientinfo = cl;
		Border purpline, raisedetched;
		purpline = BorderFactory.createLineBorder(Color.MAGENTA);
		raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		
		JPanel mainpanel1 = new JPanel();
		mainpanel1.setLayout(new FlowLayout());
		mainpanel1.setBackground(Color.ORANGE);
		
		//JPanel title = new JPanel();
		//JLabel titlefield = new JLabel();
		//title.setLayout(new FlowLayout());
		//title.setBackground(Color.ORANGE);
		//titlefield.setFont(new Font("Helvetica", Font.BOLD, 24));
		//titlefield.setText("HerrBrum Financial Calculator");
		//
		//title.add(titlefield);
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,0));
		p1.setBorder(raisedetched);
		p1.setBackground(Color.ORANGE);
		
		
		JPanel p1a = new JPanel();
		p1a.add(clientname = new JLabel("Client Name: "));
		name = new JTextField(20);
		name.setText("ex: Marion Morrison");
		name.selectAll();
		p1a.add(name);
		p1a.setBackground(Color.ORANGE);
		
		JPanel p1b = new JPanel();
		p1b.setLayout(new GridLayout(2,1));
		p1b.setBackground(Color.ORANGE);
		
		JPanel p1ba = new JPanel();
		p1ba.setBackground(Color.ORANGE);
		p1ba.setLayout(new GridLayout(1,3));
		
		p1b.add(whatpercent = new JLabel("What % of your income would you like to save?"));
	       
		group = new ButtonGroup();

		tenpercent = new JRadioButton(ten);
		tenpercent.setOpaque(false);
		group.add(tenpercent);
		p1ba.add(tenpercent);
	       
		fifteenpercent = new JRadioButton(fifteen);
		fifteenpercent.setOpaque(false);
		group.add(fifteenpercent);
		p1ba.add(fifteenpercent);
	       
		twentypercent = new JRadioButton(twenty);
		twentypercent.setOpaque(false);
		group.add(twentypercent);
		p1ba.add(twentypercent);
		
		JPanel mainpanel1a = new JPanel();
		mainpanel1a.setLayout(new BorderLayout());
		mainpanel1a.setBackground(Color.ORANGE);
		icon = new ImageIcon("/Users/codyherring/Desktop/GUI_finalProject/GUI_finalProjectFiles/money_icon.png");
		
		iconlabel = new JLabel(icon);
		iconlabel.setBackground(Color.ORANGE);
		//iconlabel.setOpaque(true);
		
		p1b.add(p1ba);
		p1b.add(mainpanel1a);
	
		p1.add(p1a);
		p1.add(p1b);
		p1.add(iconlabel);

		
		mainpanel1.add(p1);
		
		JPanel mainpanel2 = new JPanel();
		mainpanel2.setLayout(new FlowLayout());
		mainpanel2.setBackground(Color.ORANGE);
		
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2,1));
		p2.setBorder(purpline);
		p2.setBackground(Color.ORANGE);
		
		JPanel p2a = new JPanel();
		p2a.setBackground(Color.ORANGE);
		
		JPanel p2b = new JPanel();
		p2b.setLayout(new GridLayout(3,1));
		p2b.setBackground(Color.ORANGE);
		
		
		p2a.add(grossincome = new JLabel("Total Income (Monthly): "));
		gross = new JTextField(10);
		gross.setText("ex: 10000.00");
		gross.selectAll();
		p2a.add(gross);
		
		JPanel p2ba = new JPanel();
		p2ba.setBackground(Color.ORANGE);
		
		JPanel p2bb = new JPanel();
		p2bb.setBackground(Color.ORANGE);
		
		JPanel p2bc = new JPanel();
		p2bc.setBackground(Color.ORANGE);
		
		p2ba.add(expenses = new JLabel("EXPENSES:"));
		
		p2bb.add(bills = new JLabel("Bills: "));
		billsex = new JTextField(6);
		billsex.setText("ex: 200.00");
		billsex.selectAll();
		p2bb.add(billsex);
		
		p2bb.add(food = new JLabel("Food: "));
		foodex = new JTextField(6);
		foodex.setText("ex: 200.00");
		foodex.selectAll();
		p2bb.add(foodex);
		
		p2bb.add(gas = new JLabel("Gas: "));
		gasex = new JTextField(6);
		gasex.setText("ex: 200.00");
		gasex.selectAll();
		p2bb.add(gasex);

		p2bb.add(entertainment = new JLabel("Entertainment: "));
		entex = new JTextField(6);
		entex.setText("ex: 200.00");
		entex.selectAll();
		p2bb.add(entex);
		
		
		submit = new JButton("Submit");
		submit.setSize(50,50);
		submit.addActionListener(this);
		p2bc.add(submit);
		p2b.add(p2ba);
		p2b.add(p2bb);
		p2b.add(p2bc);
		
		p2.add(p2a);
		p2.add(p2b);
		
		mainpanel2.add(p2);
		
		setLayout(new GridLayout(2,1));
		mainpanel1.add(mainpanel1a);
		
		//add(title);
		add(mainpanel1, BorderLayout.NORTH);
		add(mainpanel2, BorderLayout.SOUTH);
		
		
		setBackground(Color.ORANGE);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
	}
	/************************************************
	 * Class: NewClientPanel
	 * Method: actionPerformed(ActionEvent arg)
	 *
	 * Author: Cody Herring/Justin Brumley
	 *
	 * This method handles events for submit and
	 * checks for correctly inputted information.
	 ************************************************/	
	public void actionPerformed(ActionEvent arg) 
	{
		Object ev = arg.getSource();
		
		if(ev == submit)
		{
			float income, billsamt, gasamt, foodamt,entamt ;
			try
			{
				income = Float.parseFloat(gross.getText());
				billsamt = Float.parseFloat(billsex.getText());
				gasamt = Float.parseFloat(gasex.getText());
				foodamt = Float.parseFloat(foodex.getText());
				entamt = Float.parseFloat(entex.getText());
				
				m_clientinfo.setName(name.getText());
				m_clientinfo.setIncome(income);
				
				Expense[] expenses = new Expense[4];
				expenses[0] = new Expense("Bills", billsamt, 0);
				expenses[1] = new Expense("Gas", gasamt, 1);
				expenses[2] = new Expense("Food", foodamt, 2);
				expenses[3] = new Expense("Entertainment", entamt, 3);
					
				m_clientinfo.setExpenses(expenses);
					
				float percentage = 0.0f;
				if(tenpercent.isSelected())
				{
					percentage = 0.10f;
				}
				else if(fifteenpercent.isSelected())
				{
					percentage = 0.15f;
				}
				else if(twentypercent.isSelected())
				{
					percentage = 0.20f;
				}
				m_clientinfo.setSavings(percentage);
				
				((FinanceWindow) this.getTopLevelAncestor()).addClientInfoTab(m_clientinfo);
				((FinanceWindow) this.getTopLevelAncestor()).removePreviousTab();
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Please enter valid values!");
			}
		}
	}
}