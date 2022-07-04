package parkingLot.parking;

import java.util.List;

public class ParkingFloor {
	int floorNum;
	List<ParkingSlot> parkingSlots;

	public ParkingFloor(int floorNum, List<ParkingSlot> parkingSlots) {
		super();
		this.floorNum = floorNum;
		this.parkingSlots = parkingSlots;
	}

	public int getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(int floorNum) {
		this.floorNum = floorNum;
	}

	public List<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(List<ParkingSlot> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

}
