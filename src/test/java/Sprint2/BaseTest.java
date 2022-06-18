package Sprint2;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	protected String email = "";
	protected String password = "";
	protected WebDriver driver;
	private final String url = "http://kaphiyquipuweb-001-site1.itempurl.com/pages/login";
	
	public void AbrirLink() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	protected void IniciarSesion() throws InterruptedException {
		WebElement Userbox = driver.findElement(By.xpath("//input[@placeholder=\"Email\"]"));
		Userbox.clear();
		Userbox.sendKeys(email);
		
		WebElement Passbox = driver.findElement(By.xpath("//input[@placeholder=\"Contraseña\"]"));
		Passbox.clear();
		Passbox.sendKeys(password);
		
		WebElement Accederbtn = driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]"));
		
		Accederbtn.click();
		
		Thread.sleep(4000);	
	}
	
	protected boolean ExistsElementForXPath(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
    }
	
	protected boolean ExistsElementForId(String id) {
		try {
			driver.findElement(By.id(id));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
    }
	
	protected boolean Exists(WebElement element)
    {
        if (element == null)
        { return false; }
        return true;
    }
}
