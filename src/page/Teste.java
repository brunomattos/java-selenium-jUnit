package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Teste {
public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.ad.siemens.com.cn/ingenuity-for-life/cn_en/index.html");
	
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	WebElement contactButton = driver.findElement(By.id("cc_4"));
	contactButton.click();
	
	WebElement alert = driver.findElement(By.cssSelector(".fieldset--fields .layout__item:nth-child(3) .field-alert"));
	
	System.out.println(alert.getText());
	
	WebElement submitButton = driver.findElement(By.cssSelector(".contact-form__submit-button"));
	submitButton.submit();
}
}
