package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.BMWCarsPage;
import pages.HomePage;
import pages.KiaCarsPage;
import pages.NewCarsPage;
import pages.TataCarsPage;
import pages.ToyotaCarsPage;
import utilities.DataUtil;

public class FindNewCarTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public void findNewCarTest(String browser, String runMode, String carBrand, String carTitle) {

		if (runMode.equals("N")) {

			throw new SkipException("Skipping the test as the Run mode is NO");
		}

		setUp(browser);
		HomePage home = new HomePage(driver);
		NewCarsPage newCar = home.findNewCars();

		if (carBrand.equals("kia")) {

			newCar.gotoKia();

		} else if (carBrand.equals("bmw")) {

			newCar.gotoBMW();
		} else if (carBrand.equals("toyota")) {

			newCar.gotoToyota();
		} else if (carBrand.equals("tata")) {

			newCar.gotoTata();

		}

		System.out.println(BasePage.carBase.getCarTitle());
		Assert.assertTrue(BasePage.carBase.getCarTitle().contains(carTitle));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
