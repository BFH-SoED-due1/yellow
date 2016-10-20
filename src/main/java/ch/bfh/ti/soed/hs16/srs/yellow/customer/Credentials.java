
package ch.bfh.ti.soed.hs16.srs.yellow.customer;

import java.util.UUID;

/**
 * 
 */
public class Credentials {
	
	private UUID ID;
	
	/**
     * Name under which the customer is known to system
     */
    private String login;

    /**
     * Hash from customer's password from the input field (not a plaintext password !)
     */
    private String passwordHash;
	
    /**
     * Default constructor
     */
    public Credentials() {
    	this.ID = UUID.randomUUID();
    }

    public String getPasswordHash() {
		return this.passwordHash;
	}


	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}