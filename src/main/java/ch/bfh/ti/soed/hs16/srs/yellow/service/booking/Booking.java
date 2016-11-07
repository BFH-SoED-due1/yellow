
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.booking;

import ch.bfh.ti.soed.hs16.srs.yellow.impl.customer.CustomerImpl;
import ch.bfh.ti.soed.hs16.srs.yellow.impl.room.RoomImpl;

import java.util.Set;
import java.util.UUID;

/**
 *
 */
public interface Booking {

    UUID getID();

    CustomerImpl getBookingCustomer();

    void setBookingCustomer(CustomerImpl bookingCustomer);

    RoomImpl getBookedRoomImpl();

    void setBookedRoomImpl(RoomImpl bookedRoomImpl);

    Set<UUID> getPaymentLinkID();

    void linkPaymentID(UUID paymentIDToLink);
}