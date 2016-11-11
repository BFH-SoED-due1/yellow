
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.booking;

import ch.bfh.ti.soed.hs16.srs.yellow.impl.bankingRelations.PaymentImpl;
import ch.bfh.ti.soed.hs16.srs.yellow.impl.customer.CustomerImpl;
import ch.bfh.ti.soed.hs16.srs.yellow.impl.room.RoomImpl;
import ch.bfh.ti.soed.hs16.srs.yellow.service.bankingRelations.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.service.booking.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.service.customer.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.service.room.Room;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Unit tests for Booking implementation
 */
public class BookingImplTest {

    @Test
    public void testGetID() throws Exception {

        Booking book = new BookingImpl();
        assertNotNull(book);
        UUID response = book.getID();
        assertNotNull(response);
    }

    @Test
    public void testGetSetBookingCustomer() throws Exception {

        Booking book = new BookingImpl();
        Customer cus = new CustomerImpl();
        book.setBookingCustomer(cus);
        Customer response = book.getBookingCustomer();
        assertEquals(response, cus);
    }

    @Test
    public void testGetSetBookedRoomImpl() throws Exception {

        Booking book = new BookingImpl();
        Room room = new RoomImpl();
        book.setBookedRoomImpl(room);
        Room response = book.getBookedRoomImpl();
        assertEquals(response, room);
    }

    @Test
    public void testGetSetPaymentLinkID() throws Exception {
        Booking book = new BookingImpl();
        Payment pay = new PaymentImpl();
        book.linkPaymentID(pay.getID());
        assertTrue(book.getPaymentLinkID().contains(pay.getID()));
    }

}