package Sprint2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Base.OrderedTest;
import Base.TestRunner;

//Valorar gestión de Acopiador.
@RunWith(TestRunner.class)
public class Test_HU028 extends BaseTest {
	String contrato = "CC00000087";
	
	@Before
	public void InitTest() throws InterruptedException
	{
		AbrirLink();
		super.email = "krafaelac@gmail.com";
		super.password = "P@ssw0rd100";
		IniciarSesion();
	}
	
	@OrderedTest(order=1)
	public void Test_Registrar_ValoracionGestionOperativa_MostrarMensajeConfirmacion() throws InterruptedException {
		//InitTest();
		
		WebElement Module1 = driver.findElement(By.xpath("//span[text()=\"Acopio\"]"));
		Module1.click();
		
		Thread.sleep(500);
		
		WebElement Module2 = driver.findElement(By.xpath("//span[text()=\"Contratos\"]"));
		Module2.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"fechaInicial\"]")).sendKeys("06/18/2021");
		driver.findElement(By.xpath("//input[@formcontrolname=\"fechaFinal\"]")).sendKeys("06/18/2022");
		
		WebElement btnBuscar = driver.findElement(By.xpath("//button[text()='Buscar']"));
		btnBuscar.click();
		
		Thread.sleep(4000);
		WebElement itemContrato = driver.findElement(By.xpath("//a[text()='"+ contrato + "']"));
		itemContrato.click();
		
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,500)", "");
		
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,1000)", "");
		
		Thread.sleep(1000);
		
		WebElement checkStar = driver.findElement(By.xpath("//ngb-rating/span[10]"));
		checkStar.click();
		
		driver.findElement(By.xpath("//textarea[@placeholder=\"Registre su comentario\"]")).sendKeys("Pedido realizado de manera conforme y satisfecho con la gestión.");
		
		Thread.sleep(2000);
		
		WebElement btnGuardar = driver.findElement(By.xpath("//button[text()='Confirmar Recepción del Producto']"));
		btnGuardar.click();
		
		//assertTrue("No se encontró el popup de confirmación", ExistsElementForId("swal2-content"));
		
		assertEquals("¿Está seguro de confirmar la recepción del producto?", driver.findElement(By.id("swal2-content")).getText());
		
		Thread.sleep(3000);
	}
	
	@OrderedTest(order=2)
	public void Test_Confirmar_ValoracionGestionOperativa_ClicBotonGuardar_MostrarMensajeRegistroCorrecto() throws InterruptedException {
		Test_Registrar_ValoracionGestionOperativa_MostrarMensajeConfirmacion();

		WebElement btnSi = driver.findElement(By.xpath("//div[@class=\"swal2-actions\"]//button[text()='Si']"));
		btnSi.click();
		
		Thread.sleep(15000);
		
		assertEquals("Se ha confirmado la recepción del producto terminado.", driver.findElement(By.id("swal2-content")).getText());
		
		Thread.sleep(2000);
	}

	@After
	public void CerrarSesion() {
		driver.quit();
	}
}
