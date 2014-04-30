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
	
	
	public Client(String nm, float inc, float savings)
	{
		m_name = nm;
		m_monthlyIncome = inc;
		m_targetSavings = savings;
	}
	
	
	//public float getTargetPercentage
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
	
	private Expense getLowestPriority()
	{
		for(int i = 3; i >= 0; ++i)
		{
			if(m_expenses[i].getValue() != 0.0f)
			{
				return m_expenses[i];
			}
		}
		return new Expense("invalid", 0.0f, 0);
	}
	
	
	public float getGrossIncome()
	{
		float expense = 0.0f;
		for(int i = 0; i < 4; ++i)
		{
			expense += m_expenses[i].getValue();
		}
		return (m_monthlyIncome - expense);
	}
	
	
	public float getMonthlyIncome()
	{
		return m_monthlyIncome;
	}
	
	
	public void setName(String nm)
	{
		m_name = nm;
	}
	
	
	public void setExpense(int index, float val)
	{
		m_expenses[index].modifyExpense(val);
	}
	
	
	public void setExpenses(Expense[] ex)
	{
		for(int i = 0; i < 4; ++i)
		{
			m_expenses[i] = new Expense(ex[i]);
		}
	}
	
	
	public float getTargetSavings()
	{
		return m_targetSavings;
	}
	
	
	public Expense[] getExpenses()
	{
		return m_expenses;
	}
	
	
	public void setIncome(float inc)
	{
		m_monthlyIncome = inc;
	}
	
	
	public void setSavings(float sav)
	{
		m_targetSavings = sav;
	}
	
	
	public String getName()
	{
		return m_name;
	}
	
	
	
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