package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.firefox.FirefoxDriver;

import page.SiemensENFormsPage;

public class SiemensENFormsTest {
	static String name;
	static SiemensENFormsPage pageContainer;
	private FirefoxDriver driver;

/*	
 	* The ErrorCollector rule allows execution of a test to 
 	*	continue after the first problem is found 
*/
	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();
	
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
		
		SiemensENFormsPage pageContainer = new SiemensENFormsPage(driver);
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
		
		try {assertEquals("First name is required.", pageContainer.getNameAlert());
		}catch(AssertionError e){
			errorCollector.addError(e);
		}
		try{assertEquals("Last name is required.", pageContainer.getLastNameAlert());
		}catch(AssertionError e){
			errorCollector.addError(e);
		}
		try{assertEquals("E-mail is required. E-mail has to be of format 'text@text.text'.", pageContainer.getEmailAlert());
		}catch(AssertionError e){
			errorCollector.addError(e);
		}
		try{assertEquals("Company/Organisation is required.", pageContainer.getCompanyAlert());
		}catch(AssertionError e){
			errorCollector.addError(e);
		}
		try{assertEquals("Your message is required.", pageContainer.getMessageAlert());
		}catch(AssertionError e){
			errorCollector.addError(e);
		}
		
		
		driver.close();
	}
	
	@Test
	public void fillFields() {
		SiemensENFormsPage pageContainer = new SiemensENFormsPage(driver);
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
		driver.close();

	}

	public void fillFieldsTest() {
		SiemensENFormsPage pageContainer = new SiemensENFormsPage(driver);
		
		assertNotNull("The field is not visible", pageContainer.fillName("Name"));
		assertNotNull("The field is not visible", pageContainer.fillLastName("lastName"));
		assertNotNull("The field is not visible", pageContainer.fillEmail("email_br@"));
		assertNotNull("The field is not visible", pageContainer.fillCompany("company"));
		assertNotNull("The field is not visible", pageContainer.fillMessage("Lorem ipsum dolor sit amet"));
	}
}