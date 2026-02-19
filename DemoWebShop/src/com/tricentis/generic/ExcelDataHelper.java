package com.tricentis.generic;

/** ExcelDataHelper contains all the method which is needed to handle the data from athe file and to save the file */
public interface ExcelDataHelper  {

	/**saveData for export from workbook to excel data file, which is used to final save int o the data file inherited from parent interface  */
	public void saveData();
	
	/**
	 *  method is used to write the data into workbook
	 * @param sheetName
	 * @param row
	 * @param col
	 * @param value
	 */
	public void writeData(String sheetName, int row, int col, String value) ;
	/**
	 * getData is  used to get the data from workbook file not from excel file 
	 * @param sheetName
	 * @param row
	 * @param col
	 * @return
	 */
	public String getData(String sheetName, int row, int col);
	/**
	 * Used to create a new sheet into the workbook file 
	 * @param sheetName
	 */
	public void CreateSheet(String sheetName) ;

	
	public int getRowLength(String sheetName);
	
	public int getColLength(String sheetName);
	
	
	public void closeWorkbook() ;
}