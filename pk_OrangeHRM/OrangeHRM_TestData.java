package pk_OrangeHRM;

import org.testng.annotations.DataProvider;

import pk_SmartBear.ReadExcel;

public class OrangeHRM_TestData {
	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Admin", "admin123" },
				{"priya", "admin123" },
				{"dixit", "admin123" },
				{"deepp", "admin123" }
				};

	}
	@DataProvider(name = "LoginScenario")
	public Object[][] getDataforLoginDifferentScenarios() {
		return new Object[][] { 
				{ "admin", "", "Password cannot be empty"},
				{ "", "admin123", "Username cannot be empty" }, 
				{ "AdminWrong", "admin123", "Invalid credentials" },
				{ "admin", "admin", "Invalid credentials" }, 
				{ "admin", "admin123", "Dashboard" } };

	}
	@DataProvider(name = "AddUserScenario")
	public Object[][] getDataforLoginAllScenarios() {
		return new Object[][] { 
			{"testuser", "", "","","Employee does not exist"},
			{"David Morris", "", "","","Required"},
			{"David Morris", "TestUser", "","","Required"},
			{"David Morris", "TestUser" , "admin1234","","Passwords do not match"},
			{"David Morris", "TestUser1" , "admin1234","admin12","Passwords do not match"},
			{"David Morris","testUser1","admin1234", "admin1234", "Username"}};
				
		};
		@DataProvider(name = "LoginExcelData")
		public Object[][] Authentication() throws Exception{
			//ReadExcel excel = new ReadExcel();
			BaseClass excel = new BaseClass();
			//String RelativePath = System.getProperty("user.dir");
			Object[][] testObjArray = excel.getExcelData("D:\\selenium_training\\Workspace\\OrangeHRM_Training\\weborders.xls","Login");
			//Object[][] testObjArray = excel.getExcelData(RelativePath+"\\OrangeHRM_TestData.xls","SignIn");
			System.out.println(testObjArray);
			return testObjArray;

		}

	}
	

