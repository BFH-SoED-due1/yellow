
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.booking;

import ch.bfh.ti.soed.hs16.srs.yellow.service.booking.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.service.customer.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.service.room.Room;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 *
 */
public class BookingImpl
        implements Booking {

    private final UUID ID;

    private Customer bookingCustomer;

    private Room bookedRoomImpl;

    private Set<UUID> paymentLinkID;

    /**
     * Default constructor
     */
    public BookingImpl() {
        this.ID = UUID.randomUUID();
        paymentLinkID = new HashSet<>();
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