package sg.edu.nus.iss.vmcs.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This data Store provides Property type based storage mechanism 
 * @author barlam
 *
 */
public class PropertyDataStore implements DataStore {

	private String fileName;

	public PropertyDataStore(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * This method saves the data in property file
	 */
	@Override
	public void saveProperties(Properties properties) throws IOException {
		FileOutputStream stream = new FileOutputStream(fileName);
		properties.store(stream, "");
		stream.close();
	}
	
	/**
	 * This method load the data from property file
	 */
	@Override
	public void initialize(Properties properties) throws IOException {
		FileInputStream stream = new FileInputStream(fileName);
		properties.load(stream);
		stream.close();
	}

}
