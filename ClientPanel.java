import java.awt.GridLayout;

import javax.swing.JPanel;

public class ClientPanel extends JPanel{
	
	public ClientPanel()
	{
		super();
	}
	
	
	public ClientPanel(Client cl)
	{
		super();
		super.setLayout(new GridLayout(1, 2));
		//super.add();
	}
}