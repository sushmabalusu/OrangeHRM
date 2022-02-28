package pk_SmartBear;

import org.testng.annotations.DataProvider;

public class WebOrder_TestData {
	@DataProvider(name = "WebOrder_Login")
	public Object[][] getDataforLogin() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Tester", "test" },
				//{"priya", "admin123" },
				//{"dixit", "admin123" },
				//{"deepp", "admin123" }
				};

	}

}
