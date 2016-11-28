
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.booking;

import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.bankingRelations.PaymentEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.customer.CustomerEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.room.RoomEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.bankingRelations.Payment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.booking.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Customer;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.joda.time.Interval;

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

    @Transient
    private Interval bookingFromToInterval;

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
}
