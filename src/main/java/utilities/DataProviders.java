package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//DataProvider 1
	
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			String path="C:\\Users\\2125103\\eclipse-workspace\\RediffMail\\TestData\\RediffPortFolioLaunch.xlsx";//taking xl file from testData
			
			ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
			
			int totalrows=xlutil.getRowCount("RediffMailLoginTest");	
			int totalcols=xlutil.getCellCount("RediffMailLoginTest",1);
					
			String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
			
			for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
			{		
				for(int j=0;j<totalcols;j++)  //0    i is rows j is col
				{
					logindata[i-1][j]= xlutil.getCellData("RediffMailLoginTest",i, j);  //1,0  i-1 because as we will ignore heading when taking data from the sheet
					
				}
			}
		return logindata;//returning two dimension array
					
		}
}
