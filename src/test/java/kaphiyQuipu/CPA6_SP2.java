package kaphiyQuipu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CPA6_SP2 {
	
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
		Userbox.sendKeys("aalbertotn@gmail.com");
		
		WebElement Passbox = driver.findElement(By.xpath("//input[@placeholder=\"Contraseña\"]"));
		Passbox.clear();
		Passbox.sendKeys("P@ssw0rd100");
		
		WebElement Accederbtn = driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]"));
		
		Accederbtn.click();
		
		Thread.sleep(10000);
		
		WebElement Module1 = driver.findElement(By.xpath("//span[text()=\"Acopio\"]"));
		Module1.click();
		
		Thread.sleep(1000);
		
		WebElement Module2 = driver.findElement(By.xpath("//span[text()=\"Notas de Ingreso\"]"));
		Module2.click();
		
		Thread.sleep(5000);
		
		WebElement Buscarbtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary mr-1 mb-1\"]"));
		Buscarbtn.click();
		
		Thread.sleep(3000);
		
		WebElement Solicitantelnk = driver.findElement(By.xpath("//a[@href=\"/acopio/operaciones/notaingresoalmacen/update/2\"]"));
		Solicitantelnk.click();
		
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(7000);
		
		js.executeScript("window.scrollBy(0,500)", "");
		
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,1000)", "");
		
		Thread.sleep(3000);
		
		WebElement GenerarEtiquetasbtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary mr-1 ng-star-inserted\"]"));
		GenerarEtiquetasbtn.click();
		
		Thread.sleep(3000);
		
		WebElement Confirmbtn = driver.findElement(By.xpath("//button[@class=\"swal2-confirm swal2-styled\"]"));
		Confirmbtn.click();

		Thread.sleep(7000);
		
		//Regresar a pantalla 1
		
		WebElement FinalizarEtiquetabtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary mr-1 ng-star-inserted\"][1]"));
		FinalizarEtiquetabtn.click();
		
		Thread.sleep(3000);
		
		//Confirmbtn.click();
		
		Thread.sleep(7000);
	}

	@After
	public void CerrarSesion() {
		driver.quit();
	}

}
