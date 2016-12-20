
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Equipment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Room;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "RoomEntity")
@Access(AccessType.FIELD)
@Table(name = "Room")
public class RoomEntity
        implements Room,
        Serializable {

    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Long ID;

    @OneToMany(targetEntity = EquipmentEntity.class)
    private Set<Equipment> equSet = new HashSet<>();

    /**
     * Default constructor. Must be used in order for O/R Mapper to function properly. Must be empty.
     */
    public RoomEntity() {
    }

    /**
     * @return Autogenerated ID value of the entity
     */
    public Long getID() {
        return this.ID;
    }

    /**
     * @return Equipments of this room as set
     */
    public Set<Equipment> getEquSet() {
        return Collections.unmodifiableSet(equSet);
    }

    /**
     * @param newEquipment Equipment to add
     */
    public void addEquipment(Equipment newEquipment) {
        this.equSet.add(newEquipment);
    }

    /**
     * @param equipmentToRemove remove this equipment from the list
     */
    public void removeEquipment(Equipment equipmentToRemove) {
        this.equSet.remove(equipmentToRemove);
    }

}
