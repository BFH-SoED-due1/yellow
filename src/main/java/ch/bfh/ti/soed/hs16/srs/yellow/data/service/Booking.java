
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.service;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.Set;

/**
 *
 */
public interface Booking {

    Long getID();

    Customer getBookingCustomer();

    void setBookingCustomer(Customer bookingCustomer);

    Room getBookedRoom();

    void setBookedRoom(Room bookedRoomImpl);

    Set<Payment> getPayments();

    void linkPayment(Payment paymentToLink);

    void setInterval(DateTime startDateTime, DateTime endDateTime);

    Interval getInterval();
}
