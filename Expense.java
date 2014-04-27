public class Expense{
	private float m_value;
	private int m_priority;
	String m_description;
	
	public Expense()
	{
		m_value = 0.0f;
		m_priority = 0;
	}
	
	
	public Expense(String description, float val, int pr)
	{
		m_description = description;
		m_value = val;
		m_priority = pr;
	}
	
	
	public Expense(Expense ex)
	{
		m_value = ex.getValue();
		m_priority = ex.getPriority();
		m_description = ex.getDescription();
	}
	
	
	public int getPriority()
	{
		return m_priority;
	}
	
	
	public float getValue()
	{
		return m_value;
	}
	
	
	public String getDescription()
	{
		return m_description;
	}
	
	
	public void modifyExpense(float val)
	{
		m_value = val;
	}
}