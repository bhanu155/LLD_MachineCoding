LLD_MachineCoding
Low Level System Design | Design Patterns | Machine Coding

# Design A Parking Lot System

## Requirements:
  Create the parking lot.
  Add floors to the parking lot.
  Add a parking lot slot to any of the floors.
  Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket.
  Unparks a vehicle given the ticket id.
  Displays the number of free slots per floor for a specific vehicle type.
  Displays all the free slots per floor for a specific vehicle type.
  Displays all the occupied slots per floor for a specific vehicle type.
  Optional:
  Extensible code to accommodate new types of vehicles.
  Allow a new strategy for finding the first available slot.
  Allow new commands
  Allow addition of new parking lots.
  Thread-safe to ensure concurrent requests.



## Entities: 
##### Vehicle:
Every vehicle will have a type, registration number, and color.
Different Types of Vehicles: Car / Bike / Truck
##### Parking Slots:
  Each type of slot can park a specific type of vehicle.
  No other vehicle should be allowed by the system.
  Numbered serially from 1 to n for each floor where n is the number of parking slots on that floor.
  Finding the first available slot should be based on:
    The slot should be of the same type as the vehicle.
    The slot should be on the lowest possible floor in the parking lot.
    The slot should have the lowest possible slot number on the floor.
##### Parking Lot Floors:
  Numbered serially from 1 to n where n is the number of floors.
  Might contain one or more parking lot slots of different types.
  We will assume that the first slot on each floor will be for a truck, the next 2 for bikes, and all the other slots for cars.
##### Ticket:
  The ticket id would be of the following format:
    <parking_lot_id>_<floor_no>_<slot_no>
    Example: PR1234_2_5 (denotes 5th slot of 2nd floor of parking lot PR1234)
  We can assume that there will only be 1 parking lot with ID = PR1234.

# Input / Output:
##### Input Commands:
  * create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
  * park_vehicle <vehicle_type> <reg_no> <color>
  * unpark_vehicle <ticket_id>  
  * display <display_type> <vehicle_type>
    * Possible values of display_type: free_count, free_slots, occupied_slots
  * Exit
##### Output:
  * Create_parking_lot
    * Created parking lot with <no_of_floors> floors and <no_of_slots_per_floor> slots per floor
  * park_vehicle
    * Parked vehicle. Ticket ID: <ticket_id>
    * Print "Parking Lot Full" if the slot is not available for that vehicle type.
  * unpark_vehicle
    * Unparked vehicle with Registration Number: <reg_no> and Color: <color>
    * Print "Invalid Ticket" if ticket is invalid or parking slot is not occupied.  
  * display free_count <vehicle_type>
    * No. of free slots for <vehicle_type> on Floor <floor_no>: <no_of_free_slots>
    * The above will be printed for each floor.
  * display free_slots <vehicle_type>
    * Free slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
    * The above will be printed for each floor.
  * display occupied_slots <vehicle_type>
    * Occupied slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
    * The above will be printed for each floor.

