package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import page.SiemensFormPage;

public class SiemensFormTest {
	static String name;
	static SiemensFormPage pageContainer;
	private FirefoxDriver driver;

	@Before
	public void starter() {
		this.driver = new FirefoxDriver();
		driver.get("http://www.ad.siemens.com.cn/ingenuity-for-life/cn_en/index.html");
		driver.manage().window().maximize();
	}

	
	@Test
	public void testAlert(){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SiemensFormPage pageContainer = new SiemensFormPage(driver);
		pageContainer.clickContactButton();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pageContainer.clickSubmitButton();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		assertEquals("First name is required.", pageContainer.getNameAlert());
		assertEquals("Last name is required.", pageContainer.getLastNameAlert());
		assertEquals("E-mail is required. E-mail has to be of format 'text@text.text'.", pageContainer.getEmailAlert());
		assertEquals("Company/Organisation is required.", pageContainer.getCompanyAlert());
		assertEquals("Message is required.", pageContainer.getMessageAlert());
		
		driver.close();
	}
	
	@Test
	public void fillFields() {
		SiemensFormPage pageContainer = new SiemensFormPage(driver);
		pageContainer.clickContactButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.notify();
			System.out.println("Error on sleep");
		}
		fillFieldsTest();
		pageContainer.clickSubmitButton();

	}

	public void fillFieldsTest() {
		SiemensFormPage pageContainer = new SiemensFormPage(driver);
		
		assertNotNull("The field is not visible", pageContainer.fillName("Name"));
		assertNotNull("The field is not visible", pageContainer.fillLastName("lastName"));
		assertNotNull("The field is not visible", pageContainer.fillEmail("email_br@"));
		assertNotNull("The field is not visible", pageContainer.fillCompany("company"));
		assertNotNull("The field is not visible", pageContainer.fillMessage("Lorem ipsum dolor sit amet"));
	}
}