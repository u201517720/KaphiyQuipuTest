package kaphiyQuipu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CPA34_SP2 {
	
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
		
		WebElement Module1 = driver.findElement(By.xpath("//span[text()=\"Planta\"]"));
		Module1.click();
		
		Thread.sleep(1000);
		
		WebElement Module2 = driver.findElement(By.xpath("//span[text()=\"Notas de Ingreso\"]"));
		Module2.click();
		
		Thread.sleep(5000);
		
		WebElement Buscarbtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary mr-1 mb-1\"]"));
		Buscarbtn.click();
		
		Thread.sleep(3000);
		
		WebElement Pag3 = driver.findElement(By.xpath("//li[@aria-label=\"page 3\"]"));
		Pag3.click();
		
		Thread.sleep(3000);
		
		WebElement NotaIngreso = driver.findElement(By.xpath("//a[@href=\"/planta/operaciones/notaingreso/update/23\"]"));
		NotaIngreso.click();
		
		Thread.sleep(3000);
		
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
				
		Thread.sleep(7000);
				
		js.executeScript("window.scrollBy(0,500)", "");
				
		Thread.sleep(3000);
				
		js.executeScript("window.scrollBy(0,1000)", "");
		
		WebElement ResultTransf = driver.findElement(By.xpath("//*[contains(text(), 'Resultados Transformación')]"));
		ResultTransf.click();
		
		Thread.sleep(3000);
		
		WebElement Input1 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeExportSacos\"]"));
		Input1.sendKeys("11");
		
		WebElement Input2 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeExportMCSacos\"]"));
		Input2.sendKeys("0");
		
		WebElement Input3 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeSegundaSacos\"]"));
		Input3.sendKeys("0");
		
		WebElement Input4 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeDescarteMaquinaSacos\"]"));
		Input4.sendKeys("0");
		
		WebElement Input5 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeDescarteEscojoSacos\"]"));
		Input5.sendKeys("0");
		
		WebElement Input6 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeBolaSacos\"]"));
		Input6.sendKeys("0");
		
		WebElement Input7 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeCiscoSacos\"]"));
		Input7.sendKeys("0");
		
		WebElement Input8 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeExportKilos\"]"));
		Input8.sendKeys("0");
		
		WebElement Input9 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeExportMCKilos\"]"));
		Input9.sendKeys("1");
		
		WebElement Input10 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeSegundaKilos\"]"));
		Input10.sendKeys("1");
		
		WebElement Input11 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeDescarteMaquinaKilos\"]"));
		Input11.sendKeys("1");
		
		WebElement Input12 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeDescarteEscojoKilos\"]"));
		Input12.sendKeys("1");
		
		WebElement Input13 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeBolaKilos\"]"));
		Input13.sendKeys("1");
		
		WebElement Input14 = driver.findElement(By.xpath("//input[@formcontrolname=\"cafeCiscoKilos\"]"));
		Input14.sendKeys("1");
		
		WebElement Input15 = driver.findElement(By.xpath("//input[@formcontrolname=\"piedrasOtrosKgNetos\"]"));
		Input15.sendKeys("3");
		
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
