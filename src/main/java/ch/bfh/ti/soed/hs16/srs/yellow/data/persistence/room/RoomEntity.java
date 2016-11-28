
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence.room;

import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Equipment;
import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Room;

import javax.persistence.*;
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

    public RoomEntity() {

    }

    public Long getID() {
        return this.ID;
    }

    public Set<Equipment> getEquSet() {
        return Collections.unmodifiableSet(equSet);
    }

    public void addEquipment(Equipment newEquipmentImpl) {
        this.equSet.add(newEquipmentImpl);
    }

    public void removeEquipment(Equipment equipmentImplToRemove) {
        this.equSet.remove(equipmentImplToRemove);
    }

}
