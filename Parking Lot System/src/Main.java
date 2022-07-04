import parkingLot.model.vehicle.Color;
import parkingLot.model.vehicle.VehicleType;
import parkingLot.parkingService.DisplayType;
import parkingLot.parkingService.ParkingService;
import parkingLot.parkingService.ParkingServiceImpl;

public class Main {

	public static void main(String[] args) {

		ParkingService parkingService = ParkingServiceImpl.getParkingService();

		System.out.println("Welcome to the Parking Lot!");
		System.out.println(parkingService.createParkingLot("PR1234", 2, 6));
		
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.CAR));
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.BIKE));
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.TRUCK));
		System.out.println(parkingService.display(DisplayType.FREE_SLOTS, VehicleType.CAR));
		System.out.println(parkingService.display(DisplayType.FREE_SLOTS, VehicleType.BIKE));
		System.out.println(parkingService.display(DisplayType.FREE_SLOTS, VehicleType.TRUCK));
		System.out.println(parkingService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.CAR));
		System.out.println(parkingService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.BIKE));
		System.out.println(parkingService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.TRUCK));
		
		System.out.println(parkingService.parkVehicle(VehicleType.CAR, "KA-01-DB-1234", Color.BLACK));
		System.out.println(parkingService.parkVehicle(VehicleType.CAR, "KA-02-CB-1334", Color.RED));
		System.out.println(parkingService.parkVehicle(VehicleType.CAR, "KA-01-DB-1133", Color.BLACK));
		System.out.println(parkingService.parkVehicle(VehicleType.CAR, "KA-05-HJ-8432", Color.WHITE));
		System.out.println(parkingService.parkVehicle(VehicleType.CAR, "WB-45-HO-9032", Color.WHITE));
		System.out.println(parkingService.parkVehicle(VehicleType.CAR, "KA-01-DF-8230", Color.BLACK));
		System.out.println(parkingService.parkVehicle(VehicleType.CAR, "A-21-HS-2347", Color.RED));
		
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.CAR));
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.BIKE));
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.TRUCK));
		
		System.out.println(parkingService.unparkVehicle("PR1234_2_5"));
		System.out.println(parkingService.unparkVehicle("PR1234_2_5"));
		System.out.println(parkingService.unparkVehicle("PR1234_2_7"));
		
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.CAR));
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.BIKE));
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.TRUCK));
		System.out.println(parkingService.display(DisplayType.FREE_SLOTS, VehicleType.CAR));
		System.out.println(parkingService.display(DisplayType.FREE_SLOTS, VehicleType.BIKE));
		System.out.println(parkingService.display(DisplayType.FREE_SLOTS, VehicleType.TRUCK));
		System.out.println(parkingService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.CAR));
		System.out.println(parkingService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.BIKE));
		System.out.println(parkingService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.TRUCK));
		
		System.out.println(parkingService.parkVehicle(VehicleType.BIKE, "KA-01-DB-1541", Color.BLACK));
		System.out.println(parkingService.parkVehicle(VehicleType.TRUCK, "KA-32-SJ-5389", Color.ORANGE));
		System.out.println(parkingService.parkVehicle(VehicleType.TRUCK, "54-DN-4582", Color.GREEN));
		System.out.println(parkingService.parkVehicle(VehicleType.TRUCK, "12-HF-4542", Color.GREEN));
		
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.CAR));
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.BIKE));
		System.out.println(parkingService.display(DisplayType.FREE_COUNT, VehicleType.TRUCK));
		System.out.println(parkingService.display(DisplayType.FREE_SLOTS, VehicleType.CAR));
		System.out.println(parkingService.display(DisplayType.FREE_SLOTS, VehicleType.BIKE));
		System.out.println(parkingService.display(DisplayType.FREE_SLOTS, VehicleType.TRUCK));
		System.out.println(parkingService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.CAR));
		System.out.println(parkingService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.BIKE));
		System.out.println(parkingService.display(DisplayType.OCCUPIED_SLOTS, VehicleType.TRUCK));
		
		/* INPUT
		 * create_parking_lot PR1234 2 6 
		 * display free_count CAR 
		 * display free_count BIKE
		 * display free_count TRUCK 
		 * display free_slots CAR 
		 * display free_slots BIKE
		 * display free_slots TRUCK 
		 * display occupied_slots CAR 
		 * display occupied_slots BIKE 
		 * display occupied_slots TRUCK 
		 * park_vehicle CAR KA-01-DB-1234 black
		 * park_vehicle CAR KA-02-CB-1334 red 
		 * park_vehicle CAR KA-01-DB-1133 black
		 * park_vehicle CAR KA-05-HJ-8432 white 
		 * park_vehicle CAR WB-45-HO-9032 white
		 * park_vehicle CAR KA-01-DF-8230 black 
		 * park_vehicle CAR KA-21-HS-2347 red
		 * display free_count CAR 
		 * display free_count BIKE 
		 * display free_count TRUCK
		 * unpark_vehicle PR1234_2_5 
		 * unpark_vehicle PR1234_2_5 
		 * unpark_vehicle PR1234_2_7
		 * display free_count CAR 
		 * display free_count BIKE 
		 * display free_count TRUCK
		 * display free_slots CAR 
		 * display free_slots BIKE 
		 * display free_slots TRUCK
		 * display occupied_slots CAR 
		 * display occupied_slots BIKE 
		 * display occupied_slots TRUCK 
		 * park_vehicle BIKE KA-01-DB-1541 black 
		 * park_vehicle TRUCK KA-32-SJ-5389 orange 
		 * park_vehicle TRUCK KL-54-DN-4582 green 
		 * park_vehicle TRUCK KL-12-HF-4542 green 
		 * display free_count CAR 
		 * display free_count BIKE 
		 * display free_count TRUCK 
		 * display free_slots CAR 
		 * display free_slots BIKE 
		 * display free_slots TRUCK 
		 * display occupied_slots CAR 
		 * display occupied_slots BIKE
		 * display occupied_slots TRUCK 
		 * exit
		 */

	}

}
