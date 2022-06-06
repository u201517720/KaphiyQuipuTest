package kaphiyQuipu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CPA31_SP2 {
	
	private WebDriver driver;
	
	@Before
	public void AbrirLink() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://kaphiyquipu.azurewebsites.net/pages/login");
	}
	
	 @Test
	public void Test() throws InterruptedException {
		
		WebElement Userbox = driver.findElement(By.xpath("//input[@placeholder=\"Email\"]"));
		Userbox.clear();
		Userbox.sendKeys("jcparadao@gmail.com");
		
		WebElement Passbox = driver.findElement(By.xpath("//input[@placeholder=\"Contraseña\"]"));
		Passbox.clear();
		Passbox.sendKeys("P@ssw0rd100");
		
		WebElement Accederbtn = driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]"));
		
		Accederbtn.click();
		
		Thread.sleep(10000);
		
		WebElement Module1 = driver.findElement(By.xpath("//span[text()=\"Acopio\"]"));
		Module1.click();
		
		Thread.sleep(1000);
		
		WebElement Module2 = driver.findElement(By.xpath("//span[text()=\"Ordenes de Proceso\"]"));
		Module2.click();
		
		Thread.sleep(5000);
		
		WebElement Buscarbtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary mr-1 mb-1\"]"));
		Buscarbtn.click();
		
		Thread.sleep(3000);
		
		WebElement Pag3 = driver.findElement(By.xpath("//li[@aria-label=\"page 4\"]"));
		Pag3.click();
		
		Thread.sleep(3000);
		
		WebElement NotaIngreso = driver.findElement(By.xpath("//a[@href=\"/acopio/operaciones/ordenproceso/update/37\"]"));
		NotaIngreso.click();
		
		Thread.sleep(3000);
		
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
				
		Thread.sleep(7000);
				
		js.executeScript("window.scrollBy(0,500)", "");
				
		Thread.sleep(3000);
				
		js.executeScript("window.scrollBy(0,1000)", "");
		
		WebElement IniciarTransf = driver.findElement(By.xpath("//button[@class=\"btn btn-primary mr-1 ng-star-inserted\"]"));
		IniciarTransf.click();
		
		Thread.sleep(3000);
		
		WebElement Confirmbtn = driver.findElement(By.xpath("//button[@class=\"swal2-confirm swal2-styled\"]"));
		Confirmbtn.click();

		Thread.sleep(15000);
		
	}

	@After
	public void CerrarSesion() {
		driver.quit();
	}

}
