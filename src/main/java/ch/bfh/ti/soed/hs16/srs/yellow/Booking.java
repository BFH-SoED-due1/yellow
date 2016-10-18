package ch.bfh.ti.soed.hs16.srs.yellow;

import java.util.UUID;

import ch.bfh.ti.soed.hs16.srs.yellow.customer.CustomerTest;
import ch.bfh.ti.soed.hs16.srs.yellow.room.RoomTest;

/**
 * 
 */
public class Booking {

    /**
     * Default constructor
     */
    public Booking() {
    }

    /**
     * 
     */
    private UUID ID;
    
    private CustomerTest bookingCustomer;
    
    private RoomTest bookedRoom;

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public CustomerTest getBookingCustomer() {
		return bookingCustomer;
	}

	public void setBookingCustomer(CustomerTest bookingCustomer) {
		this.bookingCustomer = bookingCustomer;
	}

	public RoomTest getBookedRoom() {
		return bookedRoom;
	}

	public void setBookedRoom(RoomTest bookedRoom) {
		this.bookedRoom = bookedRoom;
	}
}