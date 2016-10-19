package ch.bfh.ti.soed.hs16.srs.yellow.building;

/**
 * Tag in global positioning system
 */
public class GPSTag {

    /**
     * Default constructor
     */
    public GPSTag() {
    	
    }

    /**
     * 
     */
    private String XCoor;
    
	/**
     * 
     */
    public String YCoor;
    

    public String getXCoor() {
		return XCoor;
	}

	public void setXCoor(String xCoor) {
		XCoor = xCoor;
	}

	public String getYCoor() {
		return YCoor;
	}

	public void setYCoor(String yCoor) {
		YCoor = yCoor;
	}

}