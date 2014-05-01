//
//  Client.java
//
//  CS 315, Dr. Jenkins
//  Project 2
//  	
//  Created by Cody Herring, Justin Brumley on 4/30/14.
//
//

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Client{
	private String m_name;
	private float m_monthlyIncome;
	private float m_targetSavings;
	private Expense[] m_expenses = new Expense[4];
	
	/************************************************
	 * Class: Client
	 * Method: Client()
	 *
	 * Author: Justin Brumley
	 *
	 * This is the default constructor that intializes
	 * the array of the expenses, monthly income,
	 * and name.
	 ************************************************/
	public Client()
	{
		m_name = "John Doe";
		m_monthlyIncome = 0.0f;
		m_targetSavings = 0.0f;
		m_expenses[0] = new Expense("Bills", 0.0f, 0);
		m_expenses[1] = new Expense("Food", 0.0f, 2);
		m_expenses[2] = new Expense("Gas", 0.0f, 1);
		m_expenses[3] = new Expense("Entertainment", 0.0f, 3);
	}
	/************************************************
	 * Class: Client
	 * Method: Client(String nm, float inc, float savings)
	 *
	 * Author: Justin Brumley
	 *
	 * This is the custom constructor which sets
	 * the passed in values to m_name, m_monthlyIncome,
	 * and m_targetSavings.
	 ************************************************/
	public Client(String nm, float inc, float savings)
	{
		m_name = nm;
		m_monthlyIncome = inc;
		m_targetSavings = savings;
	}
	/************************************************
	 * Class: Client
	 * Method: getPercentageOf(String ex)
	 *
	 * Author: Justin Brumley
	 *
	 * This method gets the percentage of
	 * the specified expense.
	 ************************************************/
	
	public float getPercentageOf(String ex)
	{
		for(int i = 0; i < 4; ++i)
		{
			if(ex == m_expenses[i].getDescription())
			{
				return (m_expenses[i].getValue()/m_monthlyIncome) * 100;
			}
		}
		return 0.0f;
	}
	/************************************************
	 * Class: Client
	 * Method: getActualSavingsPercentage()
	 *
	 * Author: Justin Brumley
	 *
	 * This method gets the actual savings percentage
	 * of the specified expense.
	 ************************************************/
	
	public float getActualSavingsPercentage()
	{
		float percent = 0.0f;
		for(int i = 0; i < 4; ++i)
		{
			percent += m_expenses[i].getValue();
		}
		float returnval = (percent / m_monthlyIncome) * 100.0f;
		return (returnval > 100.0f) ? returnval - 100.0f : returnval;
	}
	/************************************************
	 * Class: Client
	 * Method: getGrossIncome()
	 *
	 * Author: Justin Brumley
	 *
	 * This method gets the gross income of the total
	 * income - expenses.
	 ************************************************/
	public float getGrossIncome()
	{
		float expense = 0.0f;
		for(int i = 0; i < 4; ++i)
		{
			expense += m_expenses[i].getValue();
		}
		return (m_monthlyIncome - expense);
	}
	/************************************************
	 * Class: Client
	 * Method: getMonthlyIncome()
	 *
	 * Author: Justin Brumley
	 *
	 * This method just returns the monthly income. 
	 ************************************************/	
	
	public float getMonthlyIncome()
	{
		return m_monthlyIncome;
	}
	/************************************************
	 * Class: Client
	 * Method: setName()
	 *
	 * Author: Justin Brumley
	 *
	 * This method sets the name of the client. 
	 ************************************************/	
	
	public void setName(String nm)
	{
		m_name = nm;
	}
	/************************************************
	 * Class: Client
	 * Method: setExpense()
	 *
	 * Author: Justin Brumley
	 *
	 * This method sets the expense at index
	 * with the float val.
	 ************************************************/	
	
	public void setExpense(int index, float val)
	{
		m_expenses[index].modifyExpense(val);
	}
	/************************************************
	 * Class: Client
	 * Method: setExpenses(Expense[] ex)
	 *
	 * Author: Justin Brumley
	 *
	 * This method sets all expenses to an array
	 * so that it may be used as one.
	 ************************************************/	
	
	public void setExpenses(Expense[] ex)
	{
		for(int i = 0; i < 4; ++i)
		{
			m_expenses[i] = new Expense(ex[i]);
		}
	}
	/************************************************
	 * Class: Client
	 * Method: getTargetSavings()
	 *
	 * Author: Justin Brumley
	 *
	 * This method returns the user input from the
	 * radio button as target savings.
	 ************************************************/	
	
	public float getTargetSavings()
	{
		return m_targetSavings;
	}
	/************************************************
	 * Class: Client
	 * Method: Expense[] getExpenses()
	 *
	 * Author: Justin Brumley
	 *
	 * This method returns m_expenses. 
	 ************************************************/
	
	public Expense[] getExpenses()
	{
		return m_expenses;
	}
	/************************************************
	 * Class: Client
	 * Method: setIncome()
	 *
	 * Author: Justin Brumley
	 *
	 * This method sets the user inputted income
	 * to the float inc.
	 ************************************************/	
	public void setIncome(float inc)
	{
		m_monthlyIncome = inc;
	}
	/************************************************
	 * Class: Client
	 * Method: setSavings()
	 *
	 * Author: Justin Brumley
	 *
	 * This method sets the target savings from
	 * the user inputted radio button to the
	 * float sav.
	 ************************************************/
	
	public void setSavings(float sav)
	{
		m_targetSavings = sav;
	}
	/************************************************
	 * Class: Client
	 * Method: getName()
	 *
	 * Author: Justin Brumley
	 *
	 * This method just returns the name of the client. 
	 ************************************************/	
	public String getName()
	{
		return m_name;
	}
	/************************************************
	 * Class: Client
	 * Method: save() throws FileNotFoundException
	 *
	 * Author: Justin Brumley
	 *
	 * This method saves the file. 
	 ************************************************/
	public void save() throws FileNotFoundException
	{
		try
		{
			FileOutputStream oStream = new FileOutputStream(m_name + ".txt");
			PrintWriter writer = new PrintWriter(oStream);
			System.out.println(m_name);
			writer.println("Customer Name: " + m_name);
			writer.println("Monthly Income: " + m_monthlyIncome);
			writer.println("Target Savings: " + m_targetSavings);
			for(int i = 0; i < 4; ++i)
			{
				writer.println(m_expenses[i].getDescription() + " : " + m_expenses[i].getValue());
			}
			writer.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error writing to the file!");
			System.out.println(m_name);
			e.getStackTrace();
		}
	}
}