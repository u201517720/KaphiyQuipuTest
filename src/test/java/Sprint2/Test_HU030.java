package Sprint2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Base.OrderedTest;
import Base.TestRunner;

@RunWith(TestRunner.class)
public class Test_HU030 extends BaseTest {
	
	@Before
	public void InitTest() throws InterruptedException
	{
		AbrirLink();
		super.email = "mablancome@gmail.com";
		super.password = "P@ssw0rd100";
		IniciarSesion();
	}
	
	@OrderedTest(order=1)
	public void Test_ConsultarValoracionesAgricultor_SistemaMuestraGraficoBarras() throws InterruptedException {
		WebElement Module1 = driver.findElement(By.xpath("//span[text()=\"Valoraciones\"]"));
		Module1.click();
		
		Thread.sleep(500);
		
		WebElement Module2 = driver.findElement(By.xpath("//span[text()=\"Valoración del Café\"]"));
		Module2.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//ng-select[@formcontrolname=\"actor\"]")).click();
		
		Thread.sleep(1000);
		
		List<WebElement> listaActores = driver.findElements(By.xpath( "//ng-select[@formcontrolname=\"actor\"]//ng-dropdown-panel[1]//descendant::span"));
		listaActores.get(0).click();
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"fechaInicial\"]")).sendKeys("06/14/2021");
		driver.findElement(By.xpath("//input[@formcontrolname=\"fechaFinal\"]")).sendKeys("06/14/2022");
		
		WebElement btnBuscar = driver.findElement(By.xpath("//button[text()='Visualizar Valoraciones']"));
		btnBuscar.click();

		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,500)", "");
		
		Thread.sleep(2000);
	
		assertTrue("No se encontró el gráfico de barras", ExistsElementForXPath("//*[local-name()='svg' and @class=\"apexcharts-svg\"]"));
		assertTrue("No se encontró valoraciones recibidas", driver.findElements(By.xpath("//table[@class=\"table table-sm table-borderless mb-0 ng-star-inserted\"]")).size() > 0);
		
		Thread.sleep(1000);
	}
	
	@OrderedTest(order=2)
	public void Test_ConsultarValoracionesAgricultor_MensajeNoExisteInformacion() throws InterruptedException {
		WebElement Module1 = driver.findElement(By.xpath("//span[text()=\"Valoraciones\"]"));
		Module1.click();
		
		Thread.sleep(500);
		
		WebElement Module2 = driver.findElement(By.xpath("//span[text()=\"Valoración del Café\"]"));
		Module2.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//ng-select[@formcontrolname=\"actor\"]")).click();
		
		Thread.sleep(1000);
		
		List<WebElement> listaActores = driver.findElements(By.xpath( "//ng-select[@formcontrolname=\"actor\"]//ng-dropdown-panel[1]//descendant::span"));
		listaActores.get(0).click();
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"fechaInicial\"]")).sendKeys("06/14/2018");
		driver.findElement(By.xpath("//input[@formcontrolname=\"fechaFinal\"]")).sendKeys("06/14/2019");
		
		WebElement btnBuscar = driver.findElement(By.xpath("//button[text()='Visualizar Valoraciones']"));
		btnBuscar.click();

		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,500)", "");
		
		Thread.sleep(2000);
	
		assertEquals("No se encuentra información según el filtro aplicado.", driver.findElement(By.xpath("//div[@class=\"row ng-star-inserted\"]/div")).getText());
		
		Thread.sleep(3000);
	}
	
	@After
	public void CerrarSesion() {
		driver.quit();
	}
	
}
