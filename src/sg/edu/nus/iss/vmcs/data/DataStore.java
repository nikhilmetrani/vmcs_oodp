package sg.edu.nus.iss.vmcs.data;

import java.io.IOException;
import java.util.Properties;
/**
 * This interface provides data store mechanism.
 * @author barlam
 *
 */
public interface DataStore {
	/**
	 * This method save the data to file
	 * @param properties
	 * @throws IOException
	 */
	void saveProperties(Properties properties) throws IOException;
	/**
	 *  This method reads the data from file
	 * @param properties
	 * @throws IOException
	 */
	void initialize(Properties properties) throws IOException;
	
}
