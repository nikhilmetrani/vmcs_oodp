/*
 * Copyright 2015 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

package sg.edu.nus.iss.vmcs.observer.pattern;

import java.util.ArrayList;

/**
 * Subject is an abstract class that provides functionality to attach and detach any number of observers. It keeps track of all observers attached. Objects that want to make use of this functionality must have their class extend the Subject subject implementation.
 * 
 * @author Nikhil Metrani - A0135935Y
 */
public abstract class Subject {
	
    ArrayList<Observer> observers = new ArrayList<>();

    /**
     * Clears the list of observers
     * @throws Throwable 
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        observers.clear();
    } 
    
    /**
     * Attaches the given Subject object to the current instance.
     * If the given Observer is already attached or null, nothing will be done.
     * 
     * @param observer The object that needs to be notified of state changes.
     */
    public void attach(Observer observer) {
        if ((null != observer) && (!observers.contains(observer))) {
            observers.add(observer);
            observer.update(this);
        }
    }

    /**
     * Detaches the given Observer if it is contained in the list of Observers.
     * 
     * @param observer The object that no longer needs to be notified.
     */
    public void detach(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    /**
     * Notifies all concrete observers that the state has been changed. Sends a reference of itself so that the Observer is aware or which object changed. <br>
 Note that concrete subjects must invoke this method whenever there is a change in state.
     */
    public void notifyPropertyChange() {
        for (Observer o: observers) {
            if (null != o) o.update(this);
        }
    }
}
