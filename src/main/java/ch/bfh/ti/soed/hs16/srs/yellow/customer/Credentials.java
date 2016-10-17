
package ch.bfh.ti.soed.hs16.srs.yellow.customer;

/**
 * 
 */
public class Credentials {

	/**
     * 
     */
    private String login;

    /**
     * 
     */
    private String passwordHash;
	
    /**
     * Default constructor
     */
    public Credentials() {
    	
    }

    public String getPasswordHash() {
		return passwordHash;
	}


	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}