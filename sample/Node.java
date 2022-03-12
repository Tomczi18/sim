package sample;
import java.util.*;

public class Node {
	Integer val = null;
	Node next = null;
	Node prev = null;
	Bucket bucket = null;
	Random rand = new Random();
	
	Node(Node prev, Node next, Integer val){
		this.next = next;
		this.val = val;
		this.prev = prev;
	}
	
	Node(){}
	
	public Bucket checkBucket() {
		return this.bucket;
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public Node getPrev(){
		return this.prev;
	}
	
	public void getBucket(Bucket bucket) {
		this.bucket = bucket;
	}
	
	public Boolean hasBucket() {
		if(this.bucket == null) return false;
		else { return true; }
	}
	
	public Bucket giveBucket() {
		Bucket bck = this.bucket;
		this.bucket = null;
		return bck;
	}
	

	public void setNext(Node next) {
		this.next = next; 
	}
	
	public void setVal(Integer val) {
		this.val = val;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Integer getVal() {
		return this.val;
	}
	
	public void pourWater() {
		if(this.hasBucket()) {
			int val = this.rand.nextInt(6);
			double temp = (double)this.bucket.getWater()*(1-(double)val/100);
			this.bucket.setWater((int)temp);
		} else {
			System.out.println("Nie mam wiadra");
		}
	}
}
