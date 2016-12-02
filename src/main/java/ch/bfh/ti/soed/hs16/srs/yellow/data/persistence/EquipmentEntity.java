
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.data.persistence;


import ch.bfh.ti.soed.hs16.srs.yellow.data.service.Equipment;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Describes equipment which is available to the room
 */
@Entity(name = "EquipmentEntity")
@Access(AccessType.FIELD)
@Table(name = "Equipment")
public class EquipmentEntity
		implements Equipment,
		Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equ_id")
	private Long ID;

	@Column(name = "desc")
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
