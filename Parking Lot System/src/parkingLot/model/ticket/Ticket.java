package parkingLot.model.ticket;

import parkingLot.model.vehicle.Vehicle;
import parkingLot.parking.ParkingFloor;
import parkingLot.parking.ParkingLot;
import parkingLot.parking.ParkingSlot;

public class Ticket {
	String ticketID;
	Vehicle vehicle;
	ParkingSlot slot;
	ParkingFloor floor;
	ParkingLot lot;
	/*
	 * Extra features : Date startTime; Date endTime;
	 */

	public Ticket(Vehicle vehicle, ParkingSlot slot, ParkingFloor floor, ParkingLot lot) {
		super();
		this.vehicle = vehicle;
		this.slot = slot;
		this.floor = floor;
		this.lot = lot;
		this.ticketID = lot.getLotID() + "_" + floor.getFloorNum() + "_" + slot.getSlotNumber();
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSlot getSlot() {
		return slot;
	}

	public void setSlot(ParkingSlot slot) {
		this.slot = slot;
	}

	public ParkingFloor getFloor() {
		return floor;
	}

	public void setFloor(ParkingFloor floor) {
		this.floor = floor;
	}

	public ParkingLot getLot() {
		return lot;
	}

	public void setLot(ParkingLot lot) {
		this.lot = lot;
	}

}
