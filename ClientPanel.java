import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

import javax.swing.JPanel;


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
	
	public static final int BILLS = 0;
	public static final int FOOD = 1;
	public static final int GAS = 2;
	public static final int ENTERTAINMENT = 3;
	
	private JPanel incomepanel;

	public ClientPanel()
	{
		super();
	}
	
	
	public ClientPanel(Client cl)
	{
		super();
		super.setLayout(new GridLayout(1, 2));
		
		m_client = cl;
		
		totalIncomeButtonPanel = new JPanel();
		
		changestotalincome = new JButton("Edit");
		changestotalincome.addActionListener(this);
		changestotalincome.setBackground(Color.DARK_GRAY);
		changestotalincome.setForeground(Color.WHITE);
		
		totalIncomeButtonPanel.setBackground(Color.GRAY);
		totalIncomeButtonPanel.setLayout(new BorderLayout());
		totalIncomeButtonPanel.add(changestotalincome, BorderLayout.WEST);
		for(int i = 0; i < buttonPanel.length; ++i)
		{
			buttonPanel[i] = new JPanel();
			buttonPanel[i].setLayout(new BorderLayout());
			buttonPanel[i].setBackground(Color.GRAY);
			modifyExpenses[i] = new JButton("Edit");
			modifyExpenses[i].setBackground(Color.DARK_GRAY);
			modifyExpenses[i].setForeground(Color.WHITE);
			modifyExpenses[i].addActionListener(this);
			buttonPanel[i].add(modifyExpenses[i], BorderLayout.WEST);
		}
		
		Expense [] exp;
		exp = cl.getExpenses();
		
		subclientname = new JLabel("Client Name: " + m_client.getName());
		subclientname.setForeground(Color.WHITE);
		
		subtotalincome = new JLabel("Total Income: $" + m_client.getMonthlyIncome());
		subtotalincome.setForeground(Color.WHITE);
		subgrossincome = new JLabel("Gross Income: $" + m_client.getGrossIncome());
		subgrossincome.setForeground(Color.WHITE);		
		
		billstext = new JTextField(10);
		billstext.setText(" ");
		subbills = new JLabel("Your bills expense is $" + exp[0].getValue() + " of your gross income or " + m_client.getPercentageOf("Bills") + "%");
		subbills.setForeground(Color.WHITE);
		
		foodtext = new JTextField(10);
		foodtext.setEditable(false);
		subfood = new JLabel("Your food expense is $" + exp[1].getValue() + " of your gross income or " + m_client.getPercentageOf("Food") + "%");
		subfood.setForeground(Color.WHITE);
		
		gastext = new JTextField(10);
		gastext.setText("0000");
		subgas = new JLabel("Your gas expense is $" + exp[2].getValue() + " of your gross income or " + m_client.getPercentageOf("Gas") + "%");
		subgas.setForeground(Color.WHITE);
		
		enttext = new JTextField(10);
		enttext.setText("0000");
		subent = new JLabel("Your entertainment expense is $" + exp[3].getValue() + " of your gross income or " + m_client.getPercentageOf("Entertainment") + "%");
		subent.setForeground(Color.WHITE);
		
		subgoal = new JLabel("Your target goal savings was " + (m_client.getTargetSavings())*100 + "% of your total income");
		subgoal.setForeground(Color.WHITE);
		
		subactualsav = new JLabel("You actually saved " + (100 - m_client.getActualSavingsPercentage()) + "% of your total income");
		subactualsav.setForeground(Color.WHITE);
		
		subclientpanel = new JPanel();
		subclientpanel.setLayout(new GridLayout(0,1));
		
		subclientpanel.add(subclientname);
		subclientpanel.add(subtotalincome);
		subclientpanel.add(totalIncomeButtonPanel);
		subclientpanel.add(subgrossincome);
		subclientpanel.add(subbills);
		subclientpanel.add(buttonPanel[BILLS]);
		subclientpanel.add(subfood);
		subclientpanel.add(buttonPanel[FOOD]);
		subclientpanel.add(subgas);
		subclientpanel.add(buttonPanel[GAS]);
		subclientpanel.add(subent);
		subclientpanel.add(buttonPanel[ENTERTAINMENT]);
		subclientpanel.add(subgoal);
		subclientpanel.add(subactualsav);
		
		subclientpanel.setBackground(Color.GRAY);
		add(subclientpanel);	
	}
	
	
	
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
		subclientname.setText("Client Name: " + m_client.getName());
		subtotalincome.setText("Total Income: $" + m_client.getMonthlyIncome());
		subgrossincome.setText("Gross Income: $" + m_client.getGrossIncome());
		subbills.setText("Your bills expense is $" + exp[0].getValue() + " of your gross income or " + m_client.getPercentageOf("Bills") + "%");
		subfood.setText("Your food expense is $" + exp[1].getValue() + " of your gross income or " + m_client.getPercentageOf("Food") + "%");
		subgas.setText("Your gas expense is $" + exp[2].getValue() + " of your gross income or " + m_client.getPercentageOf("Gas") + "%");
		subent.setText("Your entertainment expense is $" + exp[3].getValue() + " of your gross income or " + m_client.getPercentageOf("Entertainment") + "%");
		subgoal.setText("Your target goal savings was " + (m_client.getTargetSavings())*100 + "% of your total income");
		subactualsav.setText("You actually saved " + (100 - m_client.getActualSavingsPercentage()) + "% of your total income");
	}
	
	
	
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
}
