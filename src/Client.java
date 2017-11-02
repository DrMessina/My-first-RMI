
public class Client {
	
	private int id;
	private String name;
	private ClientRMI client;
	
	public Client(int id, String name, ClientRMI client) {
		super();
		this.id = id;
		this.name = name;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
