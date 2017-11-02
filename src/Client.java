
public class Client {
	
	private String name;
	private ClientRMI client;
	
	public Client(String name, ClientRMI client) {
		super();
		this.name = name;
		this.client = client;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClientRMI getClient() {
		return client;
	}

	public void setClient(ClientRMI client) {
		this.client = client;
	}

	

}
