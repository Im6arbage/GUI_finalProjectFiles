import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClientManager{
	
	private ArrayList<Client> m_clients = new ArrayList<Client>();
	
	public ClientManager()
	{
	
	}

	
	public ClientManager(String name, float budget, float savings)
	{
		addClient(new Client(name, budget, savings));
	}
	
	
	public ClientManager(Client cl)
	{
		addClient(cl);
	
	}
	
	
	public void addClient(Client cl)
	{
		m_clients.add(cl);
	}
	
	
	public void addClient(String name, float budget, float savings)
	{
		m_clients.add(new Client(name, budget, savings));
	}
	
	
	public Client getClientAt(int index)
	{
		return m_clients.get(index);
	}
	
	
	public Client getClientByName(String name)
	{
		for(int i = 0; i < m_clients.size(); ++i)
		{
			Client c = m_clients.get(i);
			
			if(c.getName() == name)
			{
				return c; 
			}
		}
		return null;
	}
	
	
	public Client removeClientAt(int i)
	{
		return m_clients.remove(i);
	}
	
	
	public Client removeClientByName(String name)
	{
		for(int i = 0; i < m_clients.size(); ++i)
		{
			Client c = m_clients.get(i);
			if(c.getName() == name)
			{
				return removeClientAt(i);
			}
		}
		return null;
	}
	
	
	public void saveClient(String name)
	{
		try 
		{
			Client c = getClientByName(name);
			c.save();
		} 
		catch (Exception e) {
			System.out.println("Error Saving client!");
		}
	}
	
	
	public void loadClient(String filename)
	{
		try
		{
			
		}
		catch(Exception e)
		{
			
		}
	}
}