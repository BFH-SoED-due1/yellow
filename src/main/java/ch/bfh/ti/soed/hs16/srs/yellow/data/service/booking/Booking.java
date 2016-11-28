
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.service.booking;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;
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
}
