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

//Valorar café pergamino.
@RunWith(TestRunner.class)
public class Test_HU027 extends BaseTest {
	String contrato = "CC00000091";
	
	@Before
	public void InitTest() throws InterruptedException {
		AbrirLink();
		super.email = "jmalvareza@gmail.com";
		super.password = "P@ssw0rd100";
		IniciarSesion();
	}
	
	@OrderedTest(order=1)
	public void Test_Registrar_ResultadoCalidad_MostrarMensajeConfirmacion() throws InterruptedException {
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
		
		Thread.sleep(8000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,1000)", "");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder=\"Porcentaje de humedad\"]")).sendKeys("15.6");
		driver.findElement(By.xpath("//input[@placeholder=\"Porcentaje de humedad\"]/parent::div/parent::div/parent::div/parent::div/parent::div/div[4]/div/div/div/descendant::textarea")).sendKeys("El café tiene buena calidad.");
		
		Thread.sleep(1000);
		
		WebElement checkMoho = driver.findElement(By.xpath("//table/thead/th[1][text()='OLOR']/parent::thead/parent::table/tbody/tr[1]/td[2]/input[@type='checkbox']"));
		checkMoho.click();
		
		Thread.sleep(1000);
		
		WebElement checkLimpioFreso = driver.findElement(By.xpath("//table/thead/th[1][text()='OLOR']/parent::thead/parent::table/tbody/tr[3]/td[2]/input[@type='checkbox']"));
		checkLimpioFreso.click();
		
		Thread.sleep(1000);
		
		WebElement checkColorManchado = driver.findElement(By.xpath("//table/thead/th[1][text()='COLOR']/parent::thead/parent::table/tbody/tr[1]/td[2]/input[@type='checkbox']"));
		checkColorManchado.click();
		
		Thread.sleep(1000);
		
		WebElement checkColorNegruzco = driver.findElement(By.xpath("//table/thead/th[1][text()='COLOR']/parent::thead/parent::table/tbody/tr[2]/td[2]/input[@type='checkbox']"));
		checkColorNegruzco.click();
		
		Thread.sleep(1000);
		
		WebElement checkStar = driver.findElement(By.xpath("//ngb-rating/span[8]"));
		checkStar.click();
		
		driver.findElement(By.xpath("//textarea[@placeholder=\"Registre su comentario\"]")).sendKeys("Excelente trabajo.");
		
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,1000)", "");
		
		Thread.sleep(3000);
		
		WebElement btnGuardar = driver.findElement(By.xpath("//button[text()='Guardar']"));
		btnGuardar.click();
		
		assertTrue("No se encontró el popup de confirmación", ExistsElementForId("swal2-content"));
		
		assertEquals("¿Está seguro de registrar el control de calidad realizado a la materia prima de los agricultores?", driver.findElement(By.id("swal2-content")).getText());
		
		Thread.sleep(3000);
	}
	
	@OrderedTest(order=2)
	public void Test_Confirmar_ResultadoCalidad_ClicBotonGuardar_MostrarMensajeRegistroCorrecto() throws InterruptedException {
		Test_Registrar_ResultadoCalidad_MostrarMensajeConfirmacion();

		WebElement btnSi = driver.findElement(By.xpath("//div[@class=\"swal2-actions\"]//button[text()='Si']"));
		btnSi.click();
		
		Thread.sleep(28000);
		
		assertEquals("Se ha registrado el control de calidad realizado a la materia prima de los agricultores.", driver.findElement(By.id("swal2-content")).getText());
		
		Thread.sleep(3000);
	}

	@After
	public void CerrarSesion() {
		driver.quit();
	}
}
