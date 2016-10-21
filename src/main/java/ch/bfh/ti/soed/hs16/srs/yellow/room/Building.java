package ch.bfh.ti.soed.hs16.srs.yellow.room;

import java.util.Set;

/**
 * Building class which holds Rooms
 */
public class Building {

	/**
     * 
     */
    private String Name;
    
    private GPSTag gpsTag;
    
    private Set<Room> roomsInBuilding;
	
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

	public GPSTag getGpsTag() {
		return gpsTag;
	}

	public void setGpsTag(GPSTag gpsTag) {
		this.gpsTag = gpsTag;
	}

	public Set<Room> getRoomsInBuilding() {
		return roomsInBuilding;
	}

	public void addRoomToBuilding(Room newRoom) {
		this.roomsInBuilding.add(newRoom);
	}
}