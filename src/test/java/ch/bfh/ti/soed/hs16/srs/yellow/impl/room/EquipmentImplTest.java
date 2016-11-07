
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license\. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for Equipment implementation
 */
public class EquipmentImplTest {

    @Test
    public void testGetEquipmentID() {

        EquipmentImpl equip1 = new EquipmentImpl();

        assertNotNull(equip1.getID());
    }

    @Test
    public void testEquipmentDescription() {

        EquipmentImpl equip1 = new EquipmentImpl();

        String desc = "This equipment has a description";

        equip1.setDescription(desc);

        assertEquals(desc, equip1.getDescription());
    }

}