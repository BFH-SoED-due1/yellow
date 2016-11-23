
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.booking;

import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.bankingRelations.PaymentEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.booking.BookingEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.customer.CustomerEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room.RoomEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.booking.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit tests for Booking implementation
 */
public class BookingEntityTest {

   /* @Test
    public void testGetID() throws Exception {

        Booking book = new BookingEntity();
        assertNotNull(book);
        UUID response = book.getID();
        assertNotNull(response);
    } */

    @Test
    public void testGetSetBookingCustomer() throws Exception {

        Booking book = new BookingEntity();
        Customer cus = new CustomerEntity();
        book.setBookingCustomer(cus);
        Customer response = book.getBookingCustomer();
        assertEquals(response, cus);
    }

    @Test
    public void testGetSetBookedRoomImpl() throws Exception {

        Booking book = new BookingEntity();
        Room room = new RoomEntity();
        book.setBookedRoomImpl(room);
        Room response = book.getBookedRoomImpl();
        assertEquals(response, room);
    }

    @Test
    public void testGetSetPaymentLinkID() throws Exception {
        Booking book = new BookingEntity();
        Payment pay = new PaymentEntity();
        book.linkPaymentID(pay.getID());
        assertTrue(book.getPaymentLinkID().contains(pay.getID()));
    }

}