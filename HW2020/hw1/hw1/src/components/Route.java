package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Route {
	private ArrayList<Junction> junctions; // list of junctions on the route by the order of movement.
	private ArrayList<Road> roads; // list of roads on the route by the order of movement
	private double delay; //time that will take the vehicle to make this route.
	private VehicleType vehicleType;
	/*******************************************************/
	public Route(ArrayList<Junction> junctions, ArrayList<Road> roads, VehicleType vehicleType) {
		this.setJunctions(junctions);
		this.setRoads(roads);
		this.setVehicleType(vehicleType);
		this.setDelay(new Random().nextInt(400000) + 1200000 );
		init();
	}
	


	private void init() {
		
		this.junctions.add(new Junction("1", new Point(6,3)));
		this.roads.add(new Road(new Junction("1", new Point(3,2)),new Junction("2", new Point(3,2))));
		this.junctions.add(new Junction("2", new Point(3,2)));
		this.roads.add(new Road(new Junction("3", new Point(3,2)),new Junction("2", new Point(3,2))));
		this.junctions.add(new Junction("3", new Point(3,2)));
		this.roads.add(new Road(new Junction("2", new Point(3,2)),new Junction("3", new Point(3,2))));
		
	}



	public Route(Junction start, Junction end, VehicleType vehType) {} // no implemented in this task
	
	/*******************************************************/

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}
	

	public boolean setJunctions(ArrayList<Junction> junctions) {
		boolean ans=false;
		if(junctions instanceof ArrayList) {
			this.junctions=new ArrayList<Junction>(junctions);
			ans=true;
		}
		return ans;	
	}
	
	public ArrayList<Road> getRoads() {
		return roads;
	}
	
	public boolean setRoads(ArrayList<Road> roads) {
		boolean ans=false;
		if(roads instanceof ArrayList) {
			this.roads=new ArrayList<Road>(roads);
			ans=true;
		}
		return ans;
	}
	public double getDelay() {
		return delay;
	}
	public void setDelay(double delay) {
		this.delay = delay;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	/*******************************************************/

	@Override
	public String toString() {
		return "Route [junctions=" + junctions + ", roads=" + roads + ", delay=" + delay + ", vehicleType="
				+ vehicleType + "]";
	}

	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Route) {
			ans=( this.junctions==((Route)other).junctions   &&  this.roads==((Route)other).roads && this.delay ==((Route)other).delay &&  this.vehicleType ==((Route)other).vehicleType);
		}
		return ans;
	}	

	
	/**
	 * @return *****************************************************/
	
	public Junction getStart() {
		return junctions.get(0);
	}
	
	public Junction getEnd() {
		return junctions.get(this.junctions.size());
	}
	public double calcDelay() {
		double length=0;
		double speed=0;
		double delay2=0;
		int count=0;
		double res = 0;
		for( int i=0; i< this.roads.size();i++)
		{
			length= this.roads.get(i).countLength();
			speed=Math.min(this.vehicleType.getSpeed(),this.roads.get(i).getMaxSpeed());

			for (int j = 0; j < this.junctions.get(j).getEnteringRoads().size() ; j++)
					count+=1;
			for (int j = 0; j < this.junctions.size() ; j++) 
				delay2=this.junctions.get(j).getDelay()*count;
		}
		for( int i=0; i< this.junctions.size();i++)
		{
			if(this.junctions.get(i).isHasLights()==true)
			{
				res= (length/speed)+delay2;
			}
			else
				res= (length/speed)*this.junctions.get(i).getDelay();
			
		}
		return res;
		
	}

	
}
