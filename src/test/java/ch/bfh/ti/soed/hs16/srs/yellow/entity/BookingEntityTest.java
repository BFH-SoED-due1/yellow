
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.entity;

import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.BookingEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.CustomerEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.PaymentEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.RoomEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Room;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for Booking implementation
 */
public class BookingEntityTest {

    @Test
    public void testGetID() throws Exception {

        Booking book = new BookingEntity();
        assertNotNull(book);
    }

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
        book.setBookedRoom(room);
        Room response = book.getBookedRoom();
        assertEquals(response, room);
    }

    @Test
    public void testGetSetPayment() throws Exception {
        Booking book = new BookingEntity();
        Payment pay = new PaymentEntity();
        book.linkPayment(pay);
        assertTrue(book.getPayments().contains(pay));
    }

    @Test
    public void testGetInterval() throws Exception {
        Booking book = new BookingEntity();
        DateTime dt = DateTime.now();
        DateTime dt1 = new DateTime(2017, 02, 03, 11, 17);
        book.setInterval(dt, dt1);
        Interval interval = book.getInterval();
        assertNotNull(interval);
    }
}
