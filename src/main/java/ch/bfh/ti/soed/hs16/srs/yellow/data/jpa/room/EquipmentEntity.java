
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Equipment;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Describes equipment which is available to the room
 */
@Entity
@Table(name = "Equipment")
public class EquipmentEntity
        implements Equipment {

	private Long ID;

    private String Description;

    public EquipmentEntity() {
        Description = "";
    }

	public Long getID() {
		return ID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
}
