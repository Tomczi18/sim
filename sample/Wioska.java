package sample;
import java.util.*;
public class Wioska {
	static Node temp = new Node();
	static Node root = new Node();
	static int tank = 0;
	
	public static void main(String [] args){
		init(Arrays.asList(1,2,4,5,6,3,8,7));	// ustawiamy kolejkê - z ludzi o zadanych id
		
		root = temp.getNext(); // root - pierwsza osoba w kolejce 
		Bucket bck = new Bucket(100, 100); // inicjalizacja wiadra - pojemnoœæ oraz iloœæ wody
		root.getBucket(bck); // pierwsza osoba nabiera wodê
		
		// kilka cykli ¿eby wiadro mog³o przejœæ
		for(int i = 0; i < 8; i++) {
			oneCycle(getLastNode());
		} 
	}
	// zak³adam, ¿e przekazywane jest tylko jedno wiadro, ale dodanie wiêkszej iloœci to zrobienie obiektu bucket i danie go 1 osobie
	
	public static void oneCycle(Node node){// w cyklu musimy przechodziæ przez litê od koñca
		while(node.getPrev() != null) {
			if(node.getNext()!= null) {
				if(node.getPrev().hasBucket()) {
					node.getBucket(node.getPrev().giveBucket());
					node.pourWater();
					
					System.out.println("Id osoby: " + node.getVal() +" Iloœæ wody: " + node.checkBucket().getWater());
				}
			}else{ // ostatnia osoba w kolejce
				if(node.getPrev().hasBucket()) {
					tank += node.getPrev().giveBucket().getWater(); // wlewanie wody do zbiornika
					System.out.println("Pojemnik " + tank);
					}
				}
			node = node.getPrev();
		}
	}
	
	
	//ustawianie kolejki n - kolejne osoby w kolejce
	public static void init(List<Integer> n) {
		if(temp.getNext() == null) {
			temp.setNext(root); 
		}
		Node prev = null;
		for(int i = 0; i < n.size(); i++) {	
			root.setVal(n.get(i));
			root.setPrev(prev);
			if(prev != null) {
				prev.setNext(root);
			}
			prev = root;
			root = new Node();
		}
	}
	
	public static Node getLastNode() { // przechodzimy do ostatniej osoby
		Node firstNode = getFirstNode();
		while(firstNode.getNext() != null) {
			firstNode = firstNode.getNext();
		}	
	return firstNode;
	}
	
	public static Node getFirstNode() { // przechodzimy do pierwszej osoby
		return temp.getNext();
	}
}