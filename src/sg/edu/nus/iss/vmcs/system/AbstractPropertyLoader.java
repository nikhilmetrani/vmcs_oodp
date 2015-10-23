/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
package sg.edu.nus.iss.vmcs.system;

import java.io.IOException;

/*
 * Copyright 2003 ISS.
 * The contents contained in this document may not be reproduced in any
 * form or by any means, without the written permission of ISS, other
 * than for the purpose for which it has been supplied.
 *
 */
import java.util.Properties;

import sg.edu.nus.iss.vmcs.data.DataStore;
import sg.edu.nus.iss.vmcs.data.PropertyDataStore;
import sg.edu.nus.iss.vmcs.data.XMLDataStore;
import sg.edu.nus.iss.vmcs.store.PropertyLoader;
import sg.edu.nus.iss.vmcs.store.StoreItem;

/**
 * This control object implements the interface, PropertyLoader, to provide the generic functionality
 * required to initialize the stores.
 *
 * @version 3.0 5/07/2003
 * @author Olivo Miotto, Pang Ping Li
 */

public abstract class AbstractPropertyLoader implements PropertyLoader {
	private static final String PROP_NUM_ITEMS = "NumOfItems";

	private Properties prop;
	private DataStore dataStore;

	/**
	 * This constructor creates an instance of the FilePropertyLoader object.
	 * @param fileName the filename of the property file.
	 */
	public AbstractPropertyLoader(String fileName) {
		this.dataStore = getDataStore(fileName);
	}
	
	/**
	 * This methos creates relevant DataStore implementation based on dataStore type
	 * @param fileName
	 * @return
	 */
	private DataStore getDataStore(String fileName) {
		DataStore result = null;
		String dataStoreType = Environment.getDataStoreType();
		if("PROP".equalsIgnoreCase(dataStoreType)){
			result = new PropertyDataStore(fileName);
		} else if("XML".equalsIgnoreCase(dataStoreType)) {
			result = new XMLDataStore(fileName);
		} else {
			throw new RuntimeException("DataStore not defined, dataStoreType : " + dataStoreType);
		}
		return result;
	}

	/**
	 * This method reads the properties file into a hash table.
	 * @throws IOException if fail to load properties from properties file.
	 */
	public void initialize() throws IOException {
		prop = new Properties();
		dataStore.initialize(prop);
	}

	/**
	 * This method writes the properties from the hash table to the file.
	 * @throws IOException if fail to store properties to properties file.
	 */
	public void saveProperty() throws IOException {
		dataStore.saveProperties(prop);
	}

	/**
	 * This method returns the number of items (either CashStoreItem or DrinkStoreItem)
	 * stored in the hash table.
	 * @return the number of items.
	 */
	public int getNumOfItems() {
		String nm = prop.getProperty(PROP_NUM_ITEMS);
		int nmi;
		nmi = Integer.parseInt(nm);
		return nmi;
	}

	/**
	 * This method sets the number of items (either CashStoreItem or DrinkStoreItem) stored in the hash table.
	 * @param vl the number of items.
	 */
	public void setNumOfItems(int vl) {
		prop.setProperty(PROP_NUM_ITEMS, String.valueOf(vl));
	}
	
	/**
	 * This method reads the data from the hash table and creates a StoreItem.
	 * @param index the index of the StoreItem.
	 * @return the store item of the given index.
	 */
	public abstract StoreItem getItem(int index);

	/**
	 * This method updates the hash table with data from the StoreItem.
	 * @param index the index of the StoreItem.
	 * @param item the StoreItem.
	 */
	public abstract void setItem(int index, StoreItem item);
 
	/**
	 * This method retrieve the value from the hash table.
	 * @param key the key.
	 * @return the value of the given key.
	 */
	public String getValue(String key) {
		return prop.getProperty(key);
	}

	/**
	 * The method sets a value into the hash table.
	 * @param key the key.
	 * @param value the value.
	 */
	public void setValue(String key, String value) {
		prop.setProperty(key, value);
	}
}//End of class FilePropertyLoader