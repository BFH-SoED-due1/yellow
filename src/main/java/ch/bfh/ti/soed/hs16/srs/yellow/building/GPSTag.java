package ch.bfh.ti.soed.hs16.srs.yellow.building;

/**
 * Tag in global positioning system
 */
public class GPSTag {

    /**
     * 
     */
    private final String XCoor;
    
	/**
     * 
     */
    private final String YCoor;
	
    /**
     * Default constructor
     */
    public GPSTag(String XCoor, String YCoor) {
    	this.XCoor= XCoor;
    	this.YCoor = YCoor;
    }

    public String getXCoor() {
		return XCoor;
	}

	public String getYCoor() {
		return YCoor;
	}

}