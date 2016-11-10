
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.service.booking;

import ch.bfh.ti.soed.hs16.srs.yellow.service.customer.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.service.room.Room;

import java.util.Set;
import java.util.UUID;

/**
 *
 */
public interface Booking {

    UUID getID();

    Customer getBookingCustomer();

    void setBookingCustomer(Customer bookingCustomer);

    Room getBookedRoomImpl();

    void setBookedRoomImpl(Room bookedRoomImpl);

    Set<UUID> getPaymentLinkID();

    void linkPaymentID(UUID paymentIDToLink);
}
