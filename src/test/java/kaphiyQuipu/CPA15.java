package kaphiyQuipu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CPA15 {
	
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
		Userbox.sendKeys("aasisdl@gmail.com");
		
		WebElement Passbox = driver.findElement(By.xpath("//input[@placeholder=\"Contraseña\"]"));
		Passbox.clear();
		Passbox.sendKeys("P@ssw0rd100");
		
		WebElement Accederbtn = driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]"));
		
		Accederbtn.click();
		
		Thread.sleep(10000);
		
		WebElement Module1 = driver.findElement(By.xpath("//span[text()=\"Compras\"]"));
		Module1.click();
		
		Thread.sleep(1000);
		
		WebElement Module2 = driver.findElement(By.xpath("//span[text()=\"Solicitud de Compra\"]"));
		Module2.click();
		
		Thread.sleep(5000);
		
		WebElement Buscarbtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary mr-1 mb-1\"]"));
		Buscarbtn.click();
		
		Thread.sleep(3000);
		
		WebElement Solicitudlnk = driver.findElement(By.xpath("//a[text()=\"SC00000035\"]"));
		Solicitudlnk.click();
		
		Thread.sleep(7000);
		
		WebElement GenerarContratobtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary mr-1 ng-star-inserted\"]"));
		GenerarContratobtn.click();
		
		Thread.sleep(3000);
		
		WebElement Aceptarbtn = driver.findElement(By.xpath("//button[@class=\"swal2-confirm swal2-styled\"]"));
		Aceptarbtn.click();
		
		Thread.sleep(12000);
	}

	@After
	public void CerrarSesion() {
		driver.quit();
	}

}
