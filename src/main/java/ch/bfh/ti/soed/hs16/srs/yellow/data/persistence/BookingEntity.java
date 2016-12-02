
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Room;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "BookingEntity")
@Table(name = "bookings")
@Access(AccessType.FIELD)
public class BookingEntity
        implements Booking,
        Serializable {

    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne(targetEntity = CustomerEntity.class)
    private Customer bookingCustomer;

    @ManyToOne(targetEntity = RoomEntity.class)
    private Room bookedRoom;

    @OneToMany(targetEntity = PaymentEntity.class)
    private Set<Payment> payments = new HashSet<>();

    private Interval bookingFromToInterval;

    public BookingEntity() {
    }

    public Long getID() {
        return ID;
    }

    public Customer getBookingCustomer() {
        return bookingCustomer;
    }

    public void setBookingCustomer(Customer bookingCustomer) {
        this.bookingCustomer = bookingCustomer;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public Set<Payment> getPayments() {
        return Collections.unmodifiableSet(payments);
    }

    public void linkPayment(Payment paymentToLink) {
        this.payments.add(paymentToLink);
    }

    public void setInterval(DateTime startDateTime, DateTime endDateTime) {
        this.bookingFromToInterval = new Interval(startDateTime, endDateTime);
    }

    public Interval getInterval(DateTime startDateTime, DateTime endDateTime) {
        return this.bookingFromToInterval;
    }
}
