package components;

import java.util.ArrayList;

public class Route  implements RouteParts{

	private ArrayList<RouteParts> RouteParts;
	private Vehicle vehicle;

	public Route(RouteParts start, Vehicle vehicle) {
		
	}
	
	
	
	//===================================================
	//get/set
	
	
	
	
	
	//===================================================
	//methods
	
	@Override
	public boolean checkValue(double Val, double min, double max) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean getRandomBoolean() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public double getRandomInt(int min, int max) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void successMessage(String objName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcEstimatedTime(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	public boolean canLeave(Vehicle vehicle){
		return false;
		
	}
	public void checkIn(Vehicle vehicle){
		
	}
	public void checkout(Vehicle vehicle){
		
	}
	public RouteParts findNextPart(Vehicle vehicle){
		return null;
		
	}
	public void stayOnCurrentPart(Vehicle vehicle){
		
	}
	
	//================================

	
	



	@Override
	public void correctingMessage(double wrongVal, double correctVal, String varName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void errorMessage(double wrongVal, String varName) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean getRandomDouble(double min, double max) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize) {
		// TODO Auto-generated method stub
		return null;
	}


}
