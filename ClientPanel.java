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
	
	
	
	private JLabel subfood;
	private JLabel foodpercent;
	private JTextField foodtext;
	
	private JLabel subent;
	private JTextField enttext;
	private JLabel subgas;
	private JTextField gastext;
	private JLabel subbills;
	private JTextField billstext;
	private JLabel subgoal;
	private JTextField goaltext;
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
		
		gross
		subgrossincome = new JLabel("Gross Income: ");
		subgrossincome.setForeground(Color.WHITE);		
		
		foodtext = new JTextField(10);
		foodtext.setText("0000");
		foodtext.setEditable(false);
		subfood = new JLabel("Your food Expense is " + foodtext.getText() + " of your gross income or " + cl.getPercentageOf("Food"));
		subfood.setForeground(Color.WHITE);
		
		enttext = new JTextField(10);
		enttext.setText("0000");
		entpercent = new Jlabel("10%");
		foodtext.setEditable(false);
		subent = new JLabel("Your entertainment Expense is " + enttext.getText() + " of your gross income or " + cl.getPercentageOf("Entertainment"));
		subent.setForeground(Color.WHITE);
		
		gastext = new JTextField(10);
		gastext.setText("0000");
		subgas = new JLabel("Your gas Expense is " + gastext.getText() + " of your gross income or " + cl.getPercentageOf("Gas"));
		subgas.setForeground(Color.WHITE);
		
		billstext = new JTextField(10);
		billstext.setText("0000");
		subbills = new JLabel("Your bills expense is " + billstext.getText() + " of your gross income or " + cl.getPercentageOf("Bills"));
		subbills.setForeground(Color.WHITE);
		
		subgoal = new JLabel("Your target goal savings was " + cl.getTargetSavings() + " percent of your total income");
		subgoal.setForeground(Color.WHITE);
		
		
		subactualsav = new JLabel("You actually saved " + cl.getActualSavingsPercentage() + " percent of your total income");
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