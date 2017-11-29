package subject;

import java.util.ArrayList;
import java.util.List;

import observer.Observer;

public class Observable {
	
	protected final List<Observer> observers ;
	
	public Observable(){
		observers = new ArrayList<Observer>();
		
	}
	
	public void notifyObservers() {
		for(Observer o:observers){
			
		}
	}
	
	public synchronized void addObserver(Observer o) {
		observers.add(o);
	}
	
	public synchronized void deleteObserver(Observer o) {
		observers.remove(o);
	}

}
