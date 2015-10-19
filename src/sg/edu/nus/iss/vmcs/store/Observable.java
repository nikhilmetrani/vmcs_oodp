package sg.edu.nus.iss.vmcs.store;

import java.util.ArrayList;

public abstract class Observable {
	
	ArrayList<Observer> observers = new ArrayList<>();
	
	public void attach(Observer observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}
	
	public void detach(Observer observer) {
		if (observers.contains(observer)) {
			observers.remove(observer);
		}
	}
	
	public void notifyChange() {
		for (Observer o: observers) {
			o.update(this);
		}
	}
}
