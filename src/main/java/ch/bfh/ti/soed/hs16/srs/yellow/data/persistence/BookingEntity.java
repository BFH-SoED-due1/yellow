
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

    private DateTime startDateTime;

    private DateTime endDateTime;

    /**
     * Default constructor. Must be used in order for O/R Mapper to function properly. Must be empty.
     */
    public BookingEntity() {
    }

    /**
     * @return ID of that booking entity
     */
    public Long getID() {
        return ID;
    }

    /**
     * @return Customer entity involved in booking
     */
    public Customer getBookingCustomer() {
        return bookingCustomer;
    }

    /**
     * Set customer which performed a booking
     * @param bookingCustomer customer which performed a booking
     */
    public void setBookingCustomer(Customer bookingCustomer) {
        this.bookingCustomer = bookingCustomer;
    }

    /**
     * Returns room entity involved in a booking
     * @return room entity involved in a booking
     */
    public Room getBookedRoom() {
        return bookedRoom;
    }

    /**
     * @param bookedRoom room which must be reserved
     */
    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    /**
     * Get all payments connected with this booking
     *
     * @return Unmodifiable Set of all payments connected with this booking
     */
    public Set<Payment> getPayments() {
        return Collections.unmodifiableSet(payments);
    }

    /**
     * @param paymentToLink awaits Payment entity to be added to this booking debt list
     */
    public void linkPayment(Payment paymentToLink) {
        this.payments.add(paymentToLink);
    }

    /**
     * @param startDateTime starting point of te booking in form of JodaTime DateTime type
     * @param endDateTime ending point of the booking in form of JodaTime DateTime type
     */
    public void setInterval(DateTime startDateTime, DateTime endDateTime) {
        this.bookingFromToInterval = new Interval(startDateTime, endDateTime);
    }

    /**
     * @return JodaTime interval which was set up before
     */
    public Interval getInterval() {
        return this.bookingFromToInterval;
    }
}
