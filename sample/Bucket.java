package sample;
import java.util.*;

public class Bucket {
	
	int capacity = 0;
	int waterAmount = 0;
	
	Bucket(int capacity, int waterAmount){
		this.capacity = capacity;
		this.waterAmount = waterAmount;
	}
	

	public int getWater() {
		return this.waterAmount;
	}
	
	public void setWater(int waterAmount){
		this.waterAmount = waterAmount;
	}
}
