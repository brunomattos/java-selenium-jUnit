package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SiemensENFormsPage {
	private WebDriver driver;
	
	By contactButton = By.id("cc_4");
	By formContainerFinder = By.id("section-contact-form");
	By firstNameFinder = By.id("firstname");
	By lastNameFinder = By.id("lastname");
	By emailFinder = By.id("email");
	By companyFinder = By.id("companyname");
	By messageFinder = By.id("message");
	By submitButton = By.cssSelector(".contact-form__submit-button");
	By nameAlert = By.cssSelector(".fieldset--fields .layout__item:nth-child(2) .field-alert");
	By lastNameAlert = By.cssSelector(".fieldset--fields .layout__item:nth-child(3) .field-alert");
	By emailAlert = By.cssSelector(".fieldset--fields .layout__item:nth-child(4) .field-alert");
	By companyAlert = By.cssSelector(".fieldset--fields .layout__item:nth-child(5) .field-alert");
	By messageAlert = By.cssSelector(".fieldset--fields .layout__item:nth-child(6) .field-alert");
	
	WebElement formContainer;
	
	public SiemensENFormsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean isElementPresent(By finder) {
		try {
			driver.findElement(finder);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void visita(){
		driver.get("http://www.ad.siemens.com.cn/ingenuity-for-life/cn_en/index.html");
	}
	
	public SiemensENFormsPage(){
		formContainer = driver.findElement(formContainerFinder);
	}
	
	public SiemensENFormsPage (By formContainerFinder){
		this.formContainerFinder = formContainerFinder;
	}
	
	//Methods finders
	public SiemensENFormsPage clickContactButton(){
		driver.findElement(contactButton).click();
		return this;
	}
	public SiemensENFormsPage fillName(String name){
		driver.findElement(firstNameFinder).sendKeys(name);
		return this;
	}
	public SiemensENFormsPage fillLastName(String lastName){
		driver.findElement(lastNameFinder).sendKeys(lastName);
		return this;
	}
	public SiemensENFormsPage fillEmail(String email){
		driver.findElement(emailFinder).sendKeys(email);
		return this;
	}
	public SiemensENFormsPage fillCompany(String company){
		driver.findElement(companyFinder).sendKeys(company);
		return this;
	}
	public SiemensENFormsPage fillMessage(String message){
		driver.findElement(messageFinder).sendKeys(message);
		return this;
	}
	public SiemensENFormsPage clickSubmitButton(){
		driver.findElement(submitButton).click();
		return this;
	}
	
	//Gets alerts
	public String getNameAlert(){
		return driver.findElement(nameAlert).getText();
	}
	public String getLastNameAlert(){
		return driver.findElement(lastNameAlert).getText();
	}
	public String getEmailAlert(){
		return driver.findElement(emailAlert).getText();
	}
	public String getCompanyAlert(){
		return driver.findElement(companyAlert).getText();
	}
	public String getMessageAlert(){
		return driver.findElement(messageAlert).getText();
	}
}
