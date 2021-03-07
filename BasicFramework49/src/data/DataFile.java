package data;

import utilities.Xls_Reader;

public class DataFile {
	
	//login test
	
	Xls_Reader d = new Xls_Reader("C:\\Learning\\variables.xlsx");
	
	public String correctEmail = d.getCellData("Sheet1", "values", 2);
	public String wrongEmail = d.getCellData("Sheet1", "values", 3);
	public String wrongPass = d.getCellData("Sheet1", "values", 4);
	public String passwordError = d.getCellData("Sheet1", "values", 5);
	public String emailError = d.getCellData("Sheet1", "values", 6);
	
	

}
