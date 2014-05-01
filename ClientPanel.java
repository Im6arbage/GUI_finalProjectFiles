//
//  ClientPanel.java
//
//  CS 315, Dr. Jenkins
//  Project 2
//  	
//  Created by Cody Herring, Justin Brumley on 4/30/14.
//
//

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class ClientPanel extends JPanel implements ActionListener{
	
	private Client m_client;
	private JLabel subclientname;
	private JLabel subclient;
	
	private JLabel subtotalincome;

	private JLabel subgrossincome;
	private JLabel subgross;
	private JLabel subexpenses;
	private JLabel subexp;
	private JLabel subfood;
	private JLabel subent;
	private JLabel subgas;
	private JLabel subbills;
	private JLabel subgoal;
	private JLabel subactualsav;
	
	private JPanel subclientpanel;
	
	private JTextField billstext;
	private JTextField gastext;
	private JTextField enttext;
	private JTextField foodtext;
	
	private JButton changestotalincome;
	private JButton modifyExpenses[] = new JButton[4];
	
	private JPanel[] buttonPanel = new JPanel[4];
	private JPanel totalIncomeButtonPanel;
	
	DecimalFormat dec;
	
	public static final int BILLS = 0;
	public static final int FOOD = 1;
	public static final int GAS = 2;
	public static final int ENTERTAINMENT = 3;
	
	private JPanel incomepanel;
	
	/************************************************
	 * Class: ClientPanel
	 * Method: ClientPanel()
	 *
	 * Author: Cody Herring/Justin Brumley
	 *
	 * This is a default constructor.
	 ************************************************/
	public ClientPanel()
	{
		super();
	}
	/************************************************
	 * Class: ClientPanel
	 * Method: ClientPanel(Client cl)
	 *
	 * Author: Cody Herring
	 *
	 * This is the default constructor which
	 * initializes the summary page of the Client.
	 ************************************************/
	public ClientPanel(Client cl)
	{
		super();
		super.setLayout(new GridLayout(1, 2));
		
		dec = new DecimalFormat("#.##");
		
		m_client = cl;
		
		TitledBorder summary = BorderFactory.createTitledBorder("Summary");
		summary.setTitleJustification(TitledBorder.CENTER);
		
		totalIncomeButtonPanel = new JPanel();
		
		changestotalincome = new JButton("Edit");
		changestotalincome.addActionListener(this);
		changestotalincome.setBackground(Color.GRAY);
		changestotalincome.setForeground(Color.BLACK);
		
		totalIncomeButtonPanel.setBackground(Color.ORANGE);
		totalIncomeButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		totalIncomeButtonPanel.add(changestotalincome);
		
		for(int i = 0; i < buttonPanel.length; ++i)
		{
			buttonPanel[i] = new JPanel();
			buttonPanel[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			buttonPanel[i].setBackground(Color.ORANGE);
			modifyExpenses[i] = new JButton("Edit");
			modifyExpenses[i].setBackground(Color.GRAY);
			modifyExpenses[i].setForeground(Color.BLACK);
			modifyExpenses[i].addActionListener(this);
			buttonPanel[i].add(modifyExpenses[i]);
		}
		
		Expense [] exp;
		exp = cl.getExpenses();
		
		subclientname = new JLabel(m_client.getName());
		subclientname.setForeground(Color.BLACK);
		
		subtotalincome = new JLabel("Total Income: $" + dec.format(m_client.getMonthlyIncome()));
		subtotalincome.setForeground(Color.BLACK);
		subgrossincome = new JLabel("Gross Income: $" + dec.format(m_client.getGrossIncome()));
		subgrossincome.setForeground(Color.BLACK);		
		
		billstext = new JTextField(10);
		billstext.setText(" ");
		subbills = new JLabel("Your bills expense is $" + dec.format(exp[0].getValue()) + " of your gross income. (" + dec.format(m_client.getPercentageOf("Bills")) + "%)");
		subbills.setForeground(Color.BLACK);
		
		foodtext = new JTextField(10);
		foodtext.setEditable(false);
		subfood = new JLabel("Your food expense is $" + dec.format(exp[1].getValue()) + " of your gross income. (" + dec.format(m_client.getPercentageOf("Food")) + "%)");
		subfood.setForeground(Color.BLACK);
		
		gastext = new JTextField(10);
		gastext.setText("0000");
		subgas = new JLabel("Your gas expense is $" + dec.format(exp[2].getValue()) + " of your gross income. (" + dec.format(m_client.getPercentageOf("Gas")) + "%)");
		subgas.setForeground(Color.BLACK);
		
		enttext = new JTextField(10);
		enttext.setText("0000");
		subent = new JLabel("Your entertainment expense is $" + dec.format(exp[3].getValue()) + " of your gross income. (" + dec.format(m_client.getPercentageOf("Entertainment")) + "%)");
		subent.setForeground(Color.BLACK);
		
		subgoal = new JLabel("Your target goal savings was " + dec.format((m_client.getTargetSavings())*100) + "% of your total income.");
		subgoal.setForeground(Color.BLACK);
		
		subactualsav = new JLabel("You actually saved " + dec.format((100 - m_client.getActualSavingsPercentage())) + "% of your total income.");
		subactualsav.setForeground(Color.BLACK);
		
		subclientpanel = new JPanel();
		subclientpanel.setLayout(new GridLayout(12, 1));
		
		JPanel nameformat = new JPanel();
		JPanel summarypane = new JPanel();
		
		nameformat.setLayout(new FlowLayout());
		nameformat.setBackground(Color.ORANGE);
		subclientname.setFont(new Font("Cambria", Font.ITALIC | Font.BOLD, 36));
		nameformat.add(subclientname);
		
		summarypane.setLayout(new GridLayout(2, 2));
		summarypane.setBackground(Color.ORANGE);
		summarypane.add(subgrossincome);
		summarypane.add(subgoal);
		summarypane.add(subactualsav);
		summarypane.setBorder(summary);
		
		subclientpanel.add(nameformat);
		subclientpanel.add(subtotalincome);
		subclientpanel.add(totalIncomeButtonPanel);
		subclientpanel.add(subbills);
		subclientpanel.add(buttonPanel[BILLS]);
		subclientpanel.add(subfood);
		subclientpanel.add(buttonPanel[FOOD]);
		subclientpanel.add(subgas);
		subclientpanel.add(buttonPanel[GAS]);
		subclientpanel.add(subent);
		subclientpanel.add(buttonPanel[ENTERTAINMENT]);
		subclientpanel.add(summarypane);
		
		subclientpanel.setBackground(Color.ORANGE);
		add(subclientpanel);	
	}
	/************************************************
	 * Class: ClientPanel
	 * Method: actionPerformed(ActionEvent ev)
	 *
	 * Author: Justin Brumley
	 *
	 * This method handles the user requested changes
	 * for income and expenses.
	 ************************************************/
	public void actionPerformed(ActionEvent ev)
	{
		Object o = ev.getSource();
		
		if(o == changestotalincome)
		{
			modifyPrompt(4);
		}
		else if(o == modifyExpenses[0])
		{
			modifyPrompt(BILLS);
		}
		else if(o == modifyExpenses[1])
		{
			modifyPrompt(FOOD);
		}
		else if(o == modifyExpenses[2])
		{
			modifyPrompt(GAS);
		}
		else if(o == modifyExpenses[3])
		{
			modifyPrompt(ENTERTAINMENT);
		}
		
		Expense [] exp;
		exp = m_client.getExpenses();
		subtotalincome.setText("Total Income: $" + dec.format(m_client.getMonthlyIncome()));
		
		subgrossincome.setText("Gross Income: $" + dec.format(m_client.getGrossIncome()));
		
		subbills.setText("Your bills expense is $" + dec.format(exp[0].getValue()) + " of your gross income. (" + dec.format(m_client.getPercentageOf("Bills")) + "%)");
		
		subfood.setText("Your food expense is $" + dec.format(exp[1].getValue()) + " of your gross income. (" + dec.format(m_client.getPercentageOf("Food")) + "%)");
		
		subgas.setText("Your gas expense is $" + dec.format(exp[2].getValue()) + " of your gross income. (" + dec.format(m_client.getPercentageOf("Gas")) + "%)");
		
		subent.setText("Your entertainment expense is $" + dec.format(exp[3].getValue()) + " of your gross income. (" + dec.format(m_client.getPercentageOf("Entertainment")) + "%)");
		
		subgoal.setText("Your target goal savings was " + dec.format((m_client.getTargetSavings())*100) + "% of your total income.");
		
		subactualsav.setText("You actually saved " + dec.format((100 - m_client.getActualSavingsPercentage())) + "% of your total income.");
	}
	/************************************************
	 * Class: ClientPanel
	 * Method: modifyPrompt(int exp)
	 *
	 * Author: Justin Brumley
	 *
	 * This method handles the pop up window
	 * for manually modifying input values for
	 * income and expenses.
	 ************************************************/
	public void modifyPrompt(int exp)
	{
		String result = (String)JOptionPane.showInputDialog(null,"Enter the modified value: ",
				"Modify Value", JOptionPane.OK_CANCEL_OPTION, null, null, "");
		float value = 0.0f;
		try
		{
			value = Float.parseFloat(result);
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid value!");
		}
		
		switch(exp)
		{
		case BILLS:
		{
			m_client.setExpense(BILLS, value);
			break;
		}
		
		case FOOD:
		{
			m_client.setExpense(FOOD, value);
			break;
		}
		
		case GAS:
		{
			m_client.setExpense(GAS, value);
			break;
		}
		
		case ENTERTAINMENT:
		{
			m_client.setExpense(ENTERTAINMENT, value);
			break;
		}
		
		case 4:
		{
			m_client.setIncome(value);
			break;
		}
		
		default:
		{
			
		}
		}
		this.getTopLevelAncestor().repaint();
	}
	
	/************************************************
	 * Class: ClientPanel
	 * Method: getAssociatedClient()
	 *
	 * Author: Justin Brumley
	 *
	 * This method returns the reference
	 * to a client.
	 ************************************************/
	public Client getAssociatedClient()
	{
		return m_client;
	}
}
