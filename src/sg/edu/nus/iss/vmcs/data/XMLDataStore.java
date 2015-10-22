package sg.edu.nus.iss.vmcs.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This data Store provides XML type based storage mechanism 
 * @author barlam
 *
 */
public class XMLDataStore implements DataStore {

	private String fileName;

	public XMLDataStore(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * This method saves the data in XML file
	 */
	@Override
	public void saveProperties(Properties properties) throws IOException {
		FileOutputStream stream = new FileOutputStream(fileName);
		properties.storeToXML(stream, "");
		stream.close();
	}
	
	/**
	 * This method load the data from XML file
	 */
	@Override
	public void initialize(Properties properties) throws IOException {
		FileInputStream stream = new FileInputStream(fileName);
		properties.loadFromXML(stream);
		stream.close();
	}

}
