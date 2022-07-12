package parkingLot.parkingService;

import java.util.ArrayList;
import java.util.List;

import parkingLot.model.ticket.Ticket;
import parkingLot.model.vehicle.Bike;
import parkingLot.model.vehicle.Car;
import parkingLot.model.vehicle.Color;
import parkingLot.model.vehicle.Truck;
import parkingLot.model.vehicle.Vehicle;
import parkingLot.model.vehicle.VehicleType;
import parkingLot.parking.ParkingFloor;
import parkingLot.parking.ParkingLot;
import parkingLot.parking.ParkingSlot;

public class ParkingServiceImpl implements ParkingService {
	static ParkingServiceImpl parkingService = null;

	List<Ticket> activeTickets;
	ParkingLot parkingLot;
	String response;

	// singleton
	private ParkingServiceImpl() {
		super();
		activeTickets = new ArrayList<>();
	}

	synchronized public static ParkingServiceImpl getParkingService() {

		if (parkingService == null) {
			synchronized (ParkingServiceImpl.class) {
				if (parkingService == null) {
					parkingService = new ParkingServiceImpl();
				}
			}
		}

		return parkingService;
	}

	// create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
	@Override
	public String createParkingLot(String lotID, int numFloors, int slotsPerFloor) {
		try {
			List<ParkingFloor> floors = createParkingFloors(numFloors, slotsPerFloor);
			parkingLot = new ParkingLot(lotID, floors);
			this.setResponse(
					"Created parking lot with " + numFloors + " floors and " + slotsPerFloor + " slots per floor");
		} catch (Exception e) {
			e.printStackTrace();
			this.setResponse("FAILURE");
		}
		return response;
	}

	private List<ParkingFloor> createParkingFloors(int numFloors, int slotsPerFloor) {
		List<ParkingFloor> floors = new ArrayList<>();
		try {
			for (int i = 1; i <= numFloors; i++) {
				List<ParkingSlot> slots = createParkingSlots(slotsPerFloor);
				ParkingFloor floor = new ParkingFloor(i, slots);
				floors.add(floor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return floors;
	}

	private List<ParkingSlot> createParkingSlots(int slotsPerFloor) {
		List<ParkingSlot> slots = new ArrayList<>();
		try {
			for (int i = 1; i <= slotsPerFloor; i++) {
				ParkingSlot slot;

				if (i == 1) {
					slot = new ParkingSlot(VehicleType.TRUCK, i);
				} else if (i > 1 && i <= 3) {
					slot = new ParkingSlot(VehicleType.BIKE, i);
				} else {
					slot = new ParkingSlot(VehicleType.CAR, i);
				}

				slots.add(slot);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return slots;
	}

	// park_vehicle <vehicle_type> <reg_no> <color>
	@Override
	public String parkVehicle(VehicleType type, String regNum, Color color) {
		Ticket ticket = null;

		switch (type) {
		case BIKE:
			ticket = parkingLot.parkVehicle(new Bike(color, regNum));
			if (ticket == null) {
				this.setResponse("Parking Lot Full for BIKE");
			} else {
				this.setResponse("Parked BIKE. Ticket ID: " + ticket.getTicketID());
			}

			break;
		case CAR:
			ticket = parkingLot.parkVehicle(new Car(color, regNum));
			if (ticket == null) {
				this.setResponse("Parking Lot Full for CAR");
			} else {
				this.setResponse("Parked CAR. Ticket ID: " + ticket.getTicketID());
			}
			break;
		case TRUCK:
			ticket = parkingLot.parkVehicle(new Truck(color, regNum));
			if (ticket == null) {
				this.setResponse("Parking Lot Full for TRUCK");
			} else {
				this.setResponse("Parked TRUCK. Ticket ID: " + ticket.getTicketID());
			}
			break;
		default:
			this.setResponse("Invalid Vehicle");
			break;
		}

		if (ticket != null) {
			this.activeTickets.add(ticket);
		}

		return response;

	}

	// unpark_vehicle <ticket_id>
	@Override
	public String unparkVehicle(String ticketId) {
		Ticket ticket = getTicketById(ticketId);
		if (ticket == null) {
			this.setResponse("Invalid Ticket");
		} else {
			Vehicle vehicleUnparked = parkingLot.unparkVehicle(ticket);
			activeTickets.remove(activeTickets.indexOf(ticket));
			this.setResponse("Unparked vehicle with Registration Number: " + vehicleUnparked.getRegNum()
					+ " and Color: " + vehicleUnparked.getColor());
		}

		return response;
	}

	private Ticket getTicketById(String ticketId) {
		for (Ticket ticket : this.activeTickets) {
			if (ticket.getTicketID().equals(ticketId)) {
				return ticket;
			}
		}
		return null;
	}

	// display <display_type> <vehicle_type>
	@Override
	public String display(DisplayType dispType, VehicleType vehicleType) {
		String msg = "";
		switch (dispType) {
		case FREE_COUNT:
			List<Integer> freeCount = parkingLot.displayFreeCount(vehicleType);
			for (int i = 1; i <= freeCount.size(); i++) {
				msg += "\nNo. of free slots for " + vehicleType + " on Floor " + i + ": " + freeCount.get(i - 1);
			}
			break;
		case FREE_SLOTS:
			List<List<Integer>> freeSlots = parkingLot.displayFreeSlots(vehicleType);
			for (int i = 1; i <= freeSlots.size(); i++) {
				msg += "\nFree slots for " + vehicleType + " on Floor " + i + ": " + freeSlots.get(i - 1).toString();
			}

			break;
		case OCCUPIED_SLOTS:
			parkingLot.displayOccupiedSlots(vehicleType);
			List<List<Integer>> occSlots = parkingLot.displayOccupiedSlots(vehicleType);
			for (int i = 1; i <= occSlots.size(); i++) {
				msg += "\nOccupied slots for " + vehicleType + " on Floor " + i + ": " + occSlots.get(i - 1).toString();
			}
			break;
		default:
			break;

		}
		this.setResponse(msg);
		return response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
