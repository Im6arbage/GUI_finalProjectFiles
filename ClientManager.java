import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClientManager{
	
	private ArrayList<Client> m_clients = new ArrayList<Client>();
	
	/************************************************
	 * Class: ClientManager
	 * Method: ClientManager()
	 *
	 * Author: Justin Brumley
	 *
	 * This is the default constructor. 
	 ************************************************/
	public ClientManager()
	{
	
	}
	/************************************************
	 * Class: ClientManager
	 * Method: ClientManager(String name, float budged, float savings)
	 *
	 * Author: Justin Brumley
	 *
	 * This is the custom constructor which calls
	 * addClient function for creation of a
	 * NewClient.
	 ************************************************/
	public ClientManager(String name, float budget, float savings)
	{
		addClient(new Client(name, budget, savings));
	}
	/************************************************
	 * Class: ClientManager
	 * Method: ClientManager(Client cl)
	 *
	 * Author: Justin Brumley
	 *
	 * This is the constructor that intializes the
	 * manager with one client.
	 ************************************************/
	public ClientManager(Client cl)
	{
		addClient(cl);
	
	}
	/************************************************
	 * Class: ClientManager
	 * Method: addClient()
	 *
	 * Author: Justin Brumley
	 *
	 * This method adds the client to m_clients
	 * list.
	 ************************************************/
	public void addClient(Client cl)
	{
		m_clients.add(cl);
	}
	/************************************************
	 * Class: ClientManager
	 * Method: addClient(String name, float budget, float savings)
	 *
	 * Author: Justin Brumley
	 *
	 * This method passes is name, budget, and savings
	 * and adds it to m_clients list.
	 ************************************************/
	public void addClient(String name, float budget, float savings)
	{
		m_clients.add(new Client(name, budget, savings));
	}
	/************************************************
	 * Class: ClientManager
	 * Method: getClientAt(int index)
	 *
	 * Author: Justin Brumley
	 *
	 * This method gets the name, income, and
	 * expenses for the summary page.
	 ************************************************/
	
	public Client getClientAt(int index)
	{
		return m_clients.get(index);
	}
	/************************************************
	 * Class: ClientManager
	 * Method: getClientByName()
	 *
	 * Author: Justin Brumley
	 *
	 * This  method retrieves the client based
	 * on the name of the client.
	 ************************************************/
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
	/************************************************
	 * Class: ClientManager
	 * Method: saveClient()
	 *
	 * Author: Justin Brumley
	 *
	 * This method exports base client information
	 * to a textfile named "clientname.txt".
	 ************************************************/
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
	
}