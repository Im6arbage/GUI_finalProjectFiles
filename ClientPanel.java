import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JPanel;

public class ClientPanel extends JPanel{
	
	
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
	
	

	public ClientPanel()
	{
		super();
	}
	
	
	public ClientPanel(Client cl)
	{
		super();
		super.setLayout(new GridLayout(1, 2));
		
		Expense [] exp;
		exp = cl.getExpenses();
		
		subclientname = new JLabel("Client Name: " + cl.getName());
		subclientname.setForeground(Color.WHITE);
		
		subtotalincome = new JLabel("Total Income: $" + cl.getMonthlyIncome());
		subtotalincome.setForeground(Color.WHITE);
		subgrossincome = new JLabel("Gross Income: $" + cl.getGrossIncome());
		subgrossincome.setForeground(Color.WHITE);		
		
		billstext = new JTextField(10);
		billstext.setText(" ");
		subbills = new JLabel("Your bills expense is $" + exp[0].getValue() + " of your gross income or " + cl.getPercentageOf("Bills") + "%");
		subbills.setForeground(Color.WHITE);
		
		foodtext = new JTextField(10);
		foodtext.setEditable(false);
		subfood = new JLabel("Your food expense is $" + exp[1].getValue() + " of your gross income or " + cl.getPercentageOf("Food") + "%");
		subfood.setForeground(Color.WHITE);
		
		gastext = new JTextField(10);
		gastext.setText("0000");
		subgas = new JLabel("Your gas expense is $" + exp[2].getValue() + " of your gross income or " + cl.getPercentageOf("Gas") + "%");
		subgas.setForeground(Color.WHITE);
		
		enttext = new JTextField(10);
		enttext.setText("0000");
		subent = new JLabel("Your entertainment expense is $" + exp[3].getValue() + " of your gross income or " + cl.getPercentageOf("Entertainment") + "%");
		subent.setForeground(Color.WHITE);
		
		subgoal = new JLabel("Your target goal savings was " + (cl.getTargetSavings())*100 + "% of your total income");
		subgoal.setForeground(Color.WHITE);
		
		subactualsav = new JLabel("You actually saved " + (100 - cl.getActualSavingsPercentage()) + "% of your total income");

		subclientpanel = new JPanel();
		subclientpanel.setLayout(new GridLayout(0,1));
		
		subclientpanel.add(subclientname);
		subclientpanel.add(subtotalincome);
		subclientpanel.add(subgrossincome);
		subclientpanel.add(subbills);
		subclientpanel.add(subfood);
		subclientpanel.add(subgas);
		subclientpanel.add(subent);
		subclientpanel.add(subgoal);
		subclientpanel.add(subactualsav);
		
		subclientpanel.setBackground(Color.GRAY);
		add(subclientpanel);	
	}
}