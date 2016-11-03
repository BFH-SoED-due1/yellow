package ch.bfh.ti.soed.hs16.srs.yellow.impl.room;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * BuildingImpl class which holds Rooms
 */
public class BuildingImplTest {

    @Test
    public void testBuildingName() {
        BuildingImpl build1 = new BuildingImpl();

        String bName = "Lex Corp";
        build1.setName(bName);

        assertEquals(bName, build1.getName());
    }

    @Test
    public void testBuildingGPS() {
        BuildingImpl build1 = new BuildingImpl();
    }

//	@Test
//	public void testAddBuildingRoom() {
//		BuildingImpl build1 = new BuildingImpl();
//		RoomImpl rm1 = new RoomImpl();
//		
//		build1.addRoomToBuilding(rm1);	// Still red
//		
//		assertEquals(rm1, build1.getRoomsInBuilding());
//	}
}