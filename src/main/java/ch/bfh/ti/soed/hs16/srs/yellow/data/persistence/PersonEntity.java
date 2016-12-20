
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Booking;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Person;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
    private Long ID;

    @Column(name = "fname")
    private String firstName;

    @Column(name = "lname")
    private String lastName;

    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @OneToMany(targetEntity = BookingEntity.class)
    private List<Booking> bookingsList = new LinkedList<>();

    /**
     * Default constructor. Must be used in order for O/R Mapper to function properly. Must be empty.
     */
    public PersonEntity() {
    }

    /**
     * @return Autogenerated ID value of the entity
     */
    public Long getID() {
        return this.ID;
    }

    /**
     * @return Last name of the person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName Last name of the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return first name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName First name of the person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Date of birth of the person
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth date of birth of the person
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return List of bookings this person ever performed
     */
    public List<Booking> getBookings() {
        return Collections.unmodifiableList(this.bookingsList);
    }

    /**
     * @param booking add reservation to the person's list of reservations
     */
    public void addBooking(Booking booking) {
        this.bookingsList.add(booking);
    }

}
