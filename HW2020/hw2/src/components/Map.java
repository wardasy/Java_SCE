package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;
import utilities.Utilities;

public class Map implements Utilities {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private ArrayList<TrafficLights> lights;
	//================================

	public Map (int numOfJunctions) {
		this.junctions=new ArrayList<Junction>();
		this.lights=new ArrayList<TrafficLights>();
		boolean [] booleanElem={true,false};
		boolean isLightedJunction=booleanElem[ new Random().nextInt(booleanElem.length)];
		int valX=(new Random().nextInt(799) + 0 );
		int valY=(new Random().nextInt(599) + 0 );
		for (int i = 1; i < numOfJunctions+1; i++) {

			if(!isLightedJunction)
				this.junctions.add(new Junction(i+"" , valX, valY));
			else
			{
				boolean isSequential=booleanElem[ new Random().nextInt(booleanElem.length)];
				this.junctions.add(new LightedJunction(i+"" , valX, valY,isSequential,false));
			}
			

		}
		turnLightsOn();
		SetAllRoads();
	}
	//================================
//
	public ArrayList<Junction> getJunctions() {
		return junctions;
	}

	public ArrayList<Road> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<Road> roads) {
		this.roads =new ArrayList<Road>(roads);
	}

	public ArrayList<TrafficLights> getLights() {
		return lights;
	}

	public void setLights(ArrayList<TrafficLights> lights) {
		this.lights = lights;
	}

	public void setJunctions(ArrayList<Junction> junctions) {
		this.junctions = new ArrayList<Junction>(junctions);
	}
	//================================

	public void SetAllRoads() {
		System.out.println("================= CREATING ROADS=================");

		this.roads=new ArrayList<Road>();
		this.lights=new ArrayList<TrafficLights>();
		for(Junction start :this.junctions) {
			for(Junction end:this.junctions ) {
				if(start!=end) {
					this.roads.add(new Road(start,end));
				}
				
			}

		}
		
	}
	
	public void turnLightsOn(){
		boolean [] booleanElem={true,false};
		for (Junction junc: this.junctions) {
			if(junc instanceof LightedJunction) {
				boolean lightsOn=booleanElem[ new Random().nextInt(booleanElem.length)];
				((LightedJunction)junc).getLights().setTrafficLightsOn(lightsOn);
					System.out.print(""+junc + " has been created\n");
			}
		}
		System.out.println("kk"+this.junctions);

	}
	
	//================================
	

	public boolean addJunction(Junction junc) {
		boolean ans=false;
		if(junc!=null) {
	        for (Junction element : getJunctions()) { 
	            if (element.equals(junc)) { 
	            	ans = true; 
	                break; 
	            } 
	        } 			
			if(ans==false)
			{
				this.junctions.add(junc);
			//	System.out.println("Junction "+junc.getJunctionName() +" nas been added to the map");
			}
			
		}
		return ans;

	}
	
	//================================




	@Override
	public boolean checkValue(double Val, double min, double max) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void correctingMessage(double wrongVal, double correctVal, String varName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void errorMessage(double wrongVal, String varName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean getRandomBoolean() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean getRandomDouble(double min, double max) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public double getRandomInt(int min, int max) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void successMessage(String objName) {
		// TODO Auto-generated method stub
		
	}
	public void setTrafficLightsOn(boolean trafficLightsOn) {
	}
}
