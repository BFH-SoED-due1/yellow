
package ch.bfh.ti.soed.hs16.srs.yellow;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

import ch.bfh.ti.soed.hs16.srs.yellow.bankingRelations.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.customer.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.room.Room;

/**
 * 
 */
public class Booking {

    private final UUID ID;
    
    private Customer bookingCustomer;
    
    private Room bookedRoom;
    
    private Set<UUID> paymentLinkID;
	
    /**
     * Default constructor
     */
    public Booking() {
    	this.ID = UUID.randomUUID();
    }

	public UUID getID() {
		return ID;
	}

	public Customer getBookingCustomer() {
		return bookingCustomer;
	}

	public void setBookingCustomer(Customer bookingCustomer) {
		this.bookingCustomer = bookingCustomer;
	}

	public Room getBookedRoom() {
		return bookedRoom;
	}

	public void setBookedRoom(Room bookedRoom) {
		this.bookedRoom = bookedRoom;
	}

	public Set<UUID> getPaymentLinkID() {
		return Collections.unmodifiableSet(paymentLinkID);
	}

	public void linkPaymentID(UUID paymentIDToLink) {
		this.paymentLinkID.add(paymentIDToLink);
	}
}