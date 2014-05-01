//
//  Expense.java
//
//  CS 315, Dr. Jenkins
//  Project 2
//  	
//  Created by Cody Herring, Justin Brumley on 4/30/14.
//
//
public class Expense{
	private float m_value;
	private int m_priority;
	String m_description;
	
	/************************************************
	 * Class: Expense
	 * Method: Expense()
	 *
	 * Author: Justin Brumley
	 *
	 * This is the default constructor which
	 * initializes value, priority, and the
	 * description.
	 ************************************************/
	public Expense()
	{
		m_value = 0.0f;
		m_priority = 0;
		m_description = "";
	}
	/************************************************
	 * Class: Expense
	 * Method: Expense(String description, float val, int pr)
	 *
	 * Author: Justin Brumley
	 *
	 * This is the custom constructor which
	 * sets the passed in values to
	 * m_description, m_value, m_priority.
	 ************************************************/
	public Expense(String description, float val, int pr)
	{
		m_description = description;
		m_value = val;
		m_priority = pr;
	}
	/************************************************
	 * Class: Expense
	 * Method: Expense(Expense ex)
	 *
	 * Author: Justin Brumley
	 *
	 * This is a copy constructor.
	 ************************************************/
	public Expense(Expense ex)
	{
		m_value = ex.getValue();
		m_priority = ex.getPriority();
		m_description = ex.getDescription();
	}
	/************************************************
	 * Class: Expense
	 * Method: getPriority()
	 *
	 * Author: Justin Brumley
	 *
	 * This method just returns the priority of
	 * the expenses.
	 ************************************************/
	public int getPriority()
	{
		return m_priority;
	}
	/************************************************
	 * Class: Expense
	 * Method: getValue()
	 *
	 * Author: Justin Brumley
	 *
	 * This method just returns the value of the
	 * user input from NewClientPanel().
	 ************************************************/
	public float getValue()
	{
		return m_value;
	}
	/************************************************
	 * Class: Expense
	 * Method: getDescription()
	 *
	 * Author: Justin Brumley
	 *
	 * This method just returns the description
	 * of the actual item (bills, gas, etc).
	 ************************************************/
	public String getDescription()
	{
		return m_description;
	}
	
	/************************************************
	 * Class: Expense
	 * Method: modifyExpense(float val)
	 *
	 * Author: Justin Brumley
	 *
	 * This method changes the value of the input
	 * when the user selects "edit".
	 ************************************************/
	public void modifyExpense(float val)
	{
		m_value = val;
	}
}