package parkingLot.parking;

import java.util.ArrayList;
import java.util.List;

import parkingLot.model.ticket.Ticket;
import parkingLot.model.vehicle.Vehicle;
import parkingLot.model.vehicle.VehicleType;

public class ParkingLot {
	String lotID;
	List<ParkingFloor> parkingFloors;

	public ParkingLot(String lotID, List<ParkingFloor> parkingFloors) {
		super();
		this.lotID = lotID;
		this.parkingFloors = parkingFloors;
	}

	public String getLotID() {
		return lotID;
	}

	public void setLotID(String lotID) {
		this.lotID = lotID;
	}

	public List<ParkingFloor> getParkingFloors() {
		return parkingFloors;
	}

	public void setParkingFloors(List<ParkingFloor> parkingFloors) {
		this.parkingFloors = parkingFloors;
	}

	public synchronized Ticket parkVehicle(Vehicle vehicle) {
		// TODO : separate out a class for parking allcoation strategy
		try {
			for (ParkingFloor floor : this.getParkingFloors()) {
				for (ParkingSlot slot : floor.getParkingSlots()) {
					if (!slot.isOccupied() && slot.getType() == vehicle.getType()) {
						Ticket ticket = new Ticket(vehicle, slot, floor, this);
						slot.setOccupied(true);
						return ticket;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public Vehicle unparkVehicle(Ticket ticket) {
		try {
			ticket.getSlot().setOccupied(false);
			return ticket.getVehicle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> displayFreeCount(VehicleType type) {
		List<Integer> freeCounts = new ArrayList<>();
		for (ParkingFloor floor : this.getParkingFloors()) {
			Integer freeCountOnCurrFloor = 0;
			for (ParkingSlot slot : floor.getParkingSlots()) {
				if (!slot.isOccupied() && slot.getType() == type) {
					freeCountOnCurrFloor++;
				}
			}
			freeCounts.add(freeCountOnCurrFloor);
		}
		return freeCounts;
	}

	public List<List<Integer>> displayFreeSlots(VehicleType type) {
		List<List<Integer>> freeFloorSlots = new ArrayList<>();
		for (ParkingFloor floor : this.getParkingFloors()) {
			List<Integer> freeSlots = new ArrayList<>();
			for (ParkingSlot slot : floor.getParkingSlots()) {
				if (!slot.isOccupied() && slot.getType() == type) {
					freeSlots.add(slot.getSlotNumber());
				}
			}
			freeFloorSlots.add(freeSlots);
		}
		return freeFloorSlots;
	}

	public List<List<Integer>> displayOccupiedSlots(VehicleType type) {
		List<List<Integer>> occupiedFloorSlots = new ArrayList<>();
		for (ParkingFloor floor : this.getParkingFloors()) {
			List<Integer> occupiedSlots = new ArrayList<>();
			for (ParkingSlot slot : floor.getParkingSlots()) {
				if (slot.isOccupied() && slot.getType() == type) {
					occupiedSlots.add(slot.getSlotNumber());
				}
			}
			occupiedFloorSlots.add(occupiedSlots);
		}
		return occupiedFloorSlots;
	}

}
