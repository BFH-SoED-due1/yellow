
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.booking;

import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.bankingRelations.PaymentEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.customer.CustomerEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room.RoomEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.booking.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
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
    private Set<Payment> payments;

    /**
     * Default constructor
     */
    public BookingEntity() {
        payments = new HashSet<>();
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

    public Room getBookedRoomImpl() {
        return bookedRoom;
    }

    public void setBookedRoomImpl(Room bookedRoomImpl) {
        this.bookedRoom = bookedRoomImpl;
    }

    public Set<Payment> getPaymentLinkID() {
        return Collections.unmodifiableSet(payments);
    }

    public void linkPaymentID(Payment paymentToLink) {
        this.payments.add(paymentToLink);
    }
}
