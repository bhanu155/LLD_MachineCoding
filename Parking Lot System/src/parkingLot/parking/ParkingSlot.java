package parkingLot.parking;

import parkingLot.model.vehicle.VehicleType;

public class ParkingSlot {
	VehicleType type;
	int slotNumber;
	boolean isOccupied;

	public ParkingSlot(VehicleType type, int slotNumber) {
		super();
		this.type = type;
		this.slotNumber = slotNumber;
		this.isOccupied = false;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

}
