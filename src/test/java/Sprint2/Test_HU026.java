package Sprint2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.OrderedTest;
import Base.TestRunner;

//Gestionar cosecha.
@RunWith(TestRunner.class)
public class Test_HU026 extends BaseTest {
	
	@Before
	public void InitTest() throws InterruptedException
	{
		AbrirLink();
		super.email = "mablancome@gmail.com";
		super.password = "P@ssw0rd100";
		IniciarSesion();
	}
	
	@OrderedTest(order=1)
	public void Test_MostrarFormulario_NuevaCosecha() throws InterruptedException {
		//InitTest();
		
		WebElement Module1 = driver.findElement(By.xpath("//span[text()=\"Cosecha\"]"));
		Module1.click();
		
		Thread.sleep(1000);
		
		WebElement Module2 = driver.findElement(By.xpath("//span[text()=\"Gestionar Cosecha\"]"));
		Module2.click();
		
		Thread.sleep(2000);
		
		WebElement btnNuevo = driver.findElement(By.xpath("//button[@class=\"btn btn-primary mr-1 mb-1\"][text()='Nuevo']"));
		btnNuevo.click();
		
		Thread.sleep(2000);
		
		assertTrue("No se encontró el control finca", ExistsElementForXPath("//ng-select[@formcontrolname=\"finca\"]"));
		assertTrue("No se encontró el control unidadMedida", ExistsElementForXPath("//ng-select[@formcontrolname=\"unidadMedida\"]"));
		assertTrue("No se encontró el control fechaCosecha", ExistsElementForXPath("//input[@formcontrolname=\"fechaCosecha\"]"));
		assertTrue("No se encontró el control pesoNeto", ExistsElementForXPath("//input[@formcontrolname=\"pesoNeto\"]"));
		
		assertTrue("No se encontró botón Guardar", ExistsElementForXPath("//button[text()='Guardar']"));
		assertTrue("No se encontró botón Cancelar", ExistsElementForXPath("//button[text()='Cancelar']"));
		
		Thread.sleep(3000);
	}
	
	@OrderedTest(order=2)
	public void Test_IngresarDatos_ClicBotonGuardar_MostrarMensajeConfirmacion() throws InterruptedException {
	
		Test_MostrarFormulario_NuevaCosecha();
		
		driver.findElement(By.xpath("//ng-select[@formcontrolname=\"finca\"]")).click();
		Thread.sleep(1000);
		
		List<WebElement> listaFinca = driver.findElements(By.xpath( "//ng-select[@formcontrolname=\"finca\"]//ng-dropdown-panel[1]//descendant::span"));
		listaFinca.get(0).click();
		
		
		driver.findElement(By.xpath("//ng-select[@formcontrolname=\"unidadMedida\"]")).click();
		
		Thread.sleep(1000);
		List<WebElement> listaUnidadMedida = driver.findElements(By.xpath( "//ng-select[@formcontrolname=\"unidadMedida\"]//ng-dropdown-panel[1]//descendant::span"));
		listaUnidadMedida.get(0).click();
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"fechaCosecha\"]")).sendKeys("01/04/2022");
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"pesoNeto\"]")).sendKeys("12.3");
		
		WebElement btnGuardar = driver.findElement(By.xpath("//button[text()='Guardar']"));
		btnGuardar.click();
		
		assertTrue("No se encontró botón Cancelar", ExistsElementForId("swal2-content"));
		
		assertEquals("¿Está seguro de registrar la nueva cosecha?", driver.findElement(By.id("swal2-content")).getText());
		
		Thread.sleep(3000);
	}
	
	@OrderedTest(order=3)
	public void Test_ConfirmarRegistroNuevaCosecha_ClicBotonGuardar_MostrarMensajeRegistroCorrecto() throws InterruptedException {
		Test_IngresarDatos_ClicBotonGuardar_MostrarMensajeConfirmacion();
		
		WebElement btnSi = driver.findElement(By.xpath("//div[@class=\"swal2-actions\"]//button[text()='Si']"));
		btnSi.click();
		
		Thread.sleep(3000);
		
		assertEquals("Confirmación", driver.findElement(By.xpath("//h2[@class=\"swal2-title\"]")).getText());
		assertEquals("La nueva cosecha ha sido registrada correctamente.", driver.findElement(By.id("swal2-content")).getText());
		
		Thread.sleep(3000);
	}
	
	@After
	public void CerrarSesion() {
		driver.quit();
	}
	
}
