package parkingLot.model.vehicle;

public class Vehicle {
	VehicleType type;
	Color color;
	String regNum;
	
	
	public Vehicle(VehicleType type, Color color, String regNum) {
		super();
		this.type = type;
		this.color = color;
		this.regNum = regNum;
	}
	
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getRegNum() {
		return regNum;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	
	
	
}
