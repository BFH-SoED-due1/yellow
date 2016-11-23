
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.jpa.room;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.room.Equipment;
import java.util.UUID;

/**
 * Describes equipment which is available to the room
 */
public class EquipmentEntity
        implements Equipment {

    private final UUID ID;

    private String Description;

    public EquipmentEntity() {
        this.ID = UUID.randomUUID();
        Description = "";
    }

    public UUID getID() {
		return ID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
}