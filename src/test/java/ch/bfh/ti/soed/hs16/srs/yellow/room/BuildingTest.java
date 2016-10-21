package ch.bfh.ti.soed.hs16.srs.yellow.room;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

/**
 * Building class which holds Rooms
 */
public class BuildingTest {

	@Test
	public void testBuildingName() {
		Building build1 = new Building();
		
		String bName = "Lex Corp";
		build1.setName(bName);
		
		assertEquals(bName, build1.getName());
	}
	
	@Test
	public void testBuildingGPS() {
		Building build1 = new Building();
	}
	
	@Test
	public void testAddBuildingRoom() {
		Building build1 = new Building();
		Room rm1 = new Room();
		
		build1.addRoomToBuilding(rm1);	// Still red
		
		assertEquals(rm1, build1.getRoomsInBuilding());
	}
}