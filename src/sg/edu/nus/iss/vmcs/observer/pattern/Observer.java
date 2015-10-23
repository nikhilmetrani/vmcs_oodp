/*
 * Copyright 2015 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */

package sg.edu.nus.iss.vmcs.observer.pattern;

/**
 * Interface that must be implemented by any entities that intend to be notified of changes to other entities.
 * @author Nikhil Metrani - A0135935Y
 */
public interface Observer {
    /**
     * Method called by the changedSubject to notify changes in its state. This must be implemented by all concrete observers
     * @param changedSubject The object whose state was changed.
     */
	public void update(Subject changedSubject);
}
