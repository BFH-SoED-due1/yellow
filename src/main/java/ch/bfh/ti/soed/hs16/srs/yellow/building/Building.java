package ch.bfh.ti.soed.hs16.srs.yellow.building;

import java.util.Set;

import ch.bfh.ti.soed.hs16.srs.yellow.room.RoomTest;

/**
 * Building class which holds Rooms
 */
public class Building {

	/**
     * 
     */
    private String Name;
    
    private GPSTagTest gpsTag;
    
    private Set<RoomTest> roomsInBuilding;
	
    /**
     * Default constructor
     */
    public Building() {
    }

    public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public GPSTagTest getGpsTag() {
		return gpsTag;
	}

	public void setGpsTag(GPSTagTest gpsTag) {
		this.gpsTag = gpsTag;
	}

	public Set<RoomTest> getRoomsInBuilding() {
		return roomsInBuilding;
	}

	public void setRoomsInBuilding(Set<RoomTest> roomsInBuilding) {
		this.roomsInBuilding = roomsInBuilding;
	}
}