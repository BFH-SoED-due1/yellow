package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class EquipmentImplTest {

    /**
     * Default constructor
     */

    @Test
    public void testGetEquipmentID() {
        EquipmentImpl equip1 = new EquipmentImpl();
        assertNotNull(equip1.getID());
    }

    @Test
    public void testEqupmentDescription() {
        EquipmentImpl equip1 = new EquipmentImpl();

        String desc = "This equipment, has a description";
        equip1.setDescription(desc);

        assertEquals(desc, equip1.getDescription());
    }

}