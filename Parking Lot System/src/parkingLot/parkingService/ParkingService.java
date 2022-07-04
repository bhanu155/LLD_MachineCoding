package parkingLot.parkingService;

import parkingLot.model.vehicle.Color;
import parkingLot.model.vehicle.VehicleType;

public interface ParkingService {
	String createParkingLot(String lotID, int numFloors, int slotsPerFloor);

	String parkVehicle(VehicleType type, String regNum, Color color);

	String unparkVehicle(String ticketId);

	String display(DisplayType dispType, VehicleType vehicleType);
}
