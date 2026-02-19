package com.tricentis.generic;

/**
 * contains all the method used to handle data from properties file 
 */
public interface PropertiesDataHelper {

	/**
	 * used to fetch or access the data from properties file 
	 * @param id
	 * @return
	 */
	public String getData(String id);
/**
 * writeData used write the data into the properties file 
 * @param key
 * @param value
 */
	public void writeData(String key, String value);

	/**
	 * to final save or to export back to the file 
	 */
	public void saveData();
}
