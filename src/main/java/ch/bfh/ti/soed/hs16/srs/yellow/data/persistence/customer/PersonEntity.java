
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.customer;


import ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.booking.BookingEntity;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.booking.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.customer.Person;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "PersonEntity")
@Access(AccessType.FIELD)
@Table(name = "Person")
public class PersonEntity
        implements Person,
        Serializable {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long ID;

    @Column(name = "fname")
    protected String firstName;

    @Column(name = "lname")
    protected String lastName;

    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    protected Date dateOfBirth;

    @OneToMany(targetEntity = BookingEntity.class)
    List<Booking> bookingsList = new LinkedList<>();

    public PersonEntity() {
    }

    public Long getID() {
        return this.ID;
    }

    public String getLastName() {

        return lastName;
    }

	public void setLastName(String lastName) {

        this.lastName = lastName;
    }

	public String getFirstName() {

        return firstName;
    }

	public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

	public Date getDateOfBirth() {

        return dateOfBirth;
    }

	public void setDateOfBirth(Date dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public List<Booking> getBookings() {
        return Collections.unmodifiableList(this.bookingsList);
    }

    public void addBooking(Booking booking) {
        this.bookingsList.add(booking);
    }

}
