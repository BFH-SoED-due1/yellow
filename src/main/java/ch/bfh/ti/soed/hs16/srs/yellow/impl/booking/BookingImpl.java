
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.booking;

import ch.bfh.ti.soed.hs16.srs.yellow.impl.customer.CustomerImpl;
import ch.bfh.ti.soed.hs16.srs.yellow.impl.room.RoomImpl;
import ch.bfh.ti.soed.hs16.srs.yellow.service.booking.Booking;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

/**
 *
 */
public class BookingImpl
        implements Booking {

    private final UUID ID;

    private CustomerImpl bookingCustomer;

    private RoomImpl bookedRoomImpl;

    private Set<UUID> paymentLinkID;

    /**
     * Default constructor
     */
    public BookingImpl() {
        this.ID = UUID.randomUUID();
    }

    public UUID getID() {
        return ID;
    }

    public CustomerImpl getBookingCustomer() {
        return bookingCustomer;
    }

    public void setBookingCustomer(CustomerImpl bookingCustomer) {
        this.bookingCustomer = bookingCustomer;
    }

    public RoomImpl getBookedRoomImpl() {
        return bookedRoomImpl;
    }

    public void setBookedRoomImpl(RoomImpl bookedRoomImpl) {
        this.bookedRoomImpl = bookedRoomImpl;
    }

    public Set<UUID> getPaymentLinkID() {
        return Collections.unmodifiableSet(paymentLinkID);
    }

    public void linkPaymentID(UUID paymentIDToLink) {
        this.paymentLinkID.add(paymentIDToLink);
    }
}