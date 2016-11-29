
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
import org.joda.time.DateTime;
import org.joda.time.Interval;

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

    public void setInterval(DateTime startDateTime, DateTime endDateTime);

    public Interval getInterval(DateTime startDateTime, DateTime endDateTime);
}
