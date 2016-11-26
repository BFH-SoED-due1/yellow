
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.booking;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.booking.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 *
 */
@Entity
public class BookingEntity
        implements Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private Customer bookingCustomer;

    private Room bookedRoomImpl;

    private Set<UUID> paymentLinkID;

    /**
     * Default constructor
     */
    public BookingEntity() {
        paymentLinkID = new HashSet<>();
    }

    public Long getID() {
        return ID;
    }

    public Customer getBookingCustomer() {
        return bookingCustomer;
    }

    public void setBookingCustomer(Customer bookingCustomer) {
        this.bookingCustomer = bookingCustomer;
    }

    public Room getBookedRoomImpl() {
        return bookedRoomImpl;
    }

    public void setBookedRoomImpl(Room bookedRoomImpl) {
        this.bookedRoomImpl = bookedRoomImpl;
    }

    public Set<UUID> getPaymentLinkID() {
        return Collections.unmodifiableSet(paymentLinkID);
    }

    public void linkPaymentID(UUID paymentIDToLink) {
        this.paymentLinkID.add(paymentIDToLink);
    }
}
