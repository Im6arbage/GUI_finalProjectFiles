import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JPanel;

public class ClientPanel extends JPanel{
	
	
	private JLabel subclientname;
	private JLabel subclient;
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

	public ClientPanel()
	{
		super();
	}
	
	
	public ClientPanel(Client cl)
	{
		super();
		super.setLayout(new GridLayout(1, 2));
		//super.add();
		
		subclientname = new JLabel("Client Name: ");
		subclientname.setForeground(Color.WHITE);
		
		
		subgrossincome = new JLabel("Gross Income: ");
		subgrossincome.setForeground(Color.WHITE);
		//gross = c.getGrossIncome();
		
		
		
		subfood = new JLabel("Your Food Expense: ");
		subfood.setForeground(Color.WHITE);
		subent = new JLabel("Entertainment Expense(%): ");
		subent.setForeground(Color.WHITE);
		subgas = new JLabel("Gas Expense(%): ");
		subgas.setForeground(Color.WHITE);
		subbills = new JLabel("Bills Expense(%): ");
		subbills.setForeground(Color.WHITE);
		subgoal = new JLabel("Your target goal savings was (blank) percent of your total income"); //+ c.getTargetPercentage());
		subgoal.setForeground(Color.WHITE);
		subactualsav = new JLabel("You actually saved (%):"); // + c.getActualSavingsPercentage() + " percent of your gross income");
		subactualsav.setForeground(Color.WHITE);
		
		subclientpanel = new JPanel();
		subclientpanel.setLayout(new GridLayout(0,1));
		
		subclientpanel.add(subclientname, BorderLayout.CENTER);
		subclientpanel.add(subgrossincome);
		subclientpanel.add(subbills);
		subclientpanel.add(subfood);
		subclientpanel.add(subent);
		subclientpanel.add(subgas);
		subclientpanel.add(subbills);
		subclientpanel.add(subgoal);
		subclientpanel.add(subactualsav);
		
		subclientpanel.setBackground(Color.GRAY);
		add(subclientpanel);	
	}
}