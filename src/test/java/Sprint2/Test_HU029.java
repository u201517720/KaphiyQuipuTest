package Sprint2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.OrderedTest;
import Base.TestRunner;

//Valorar café.
@RunWith(TestRunner.class)
public class Test_HU029 extends BaseTest {
	String url = "http://kaphiyquipuweb-001-site1.itempurl.com/pages/valoracion-cafe?q=o70itfi1EUPCSRktOYR%2bVQ%3d%3d";
	
	@Before
	public void InitTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		Thread.sleep(2000);
	}
	
	@OrderedTest(order=1)
	public void Test_MostrarFormulario_ValoracionCafe() throws InterruptedException {
		assertTrue("No se encontró el control tipo de documento", ExistsElementForXPath("//ng-select[@formcontrolname=\"tipoDocumento\"]"));
		assertTrue("No se encontró el control Nro Documento", ExistsElementForXPath("//input[@formcontrolname=\"nroDocumento\"]"));
		assertTrue("No se encontró el control Nombre Apellido", ExistsElementForXPath("//input[@formcontrolname=\"nombreApellido\"]"));
		assertTrue("No se encontró el control Comentario", ExistsElementForXPath("//textarea[@formcontrolname=\"comentario\"]"));
		
		List<WebElement> listaCheckStar = driver.findElements(By.xpath("//ngb-rating/span"));
		assertEquals("No se encontró un control de valoración", 10, listaCheckStar.size());
		
		assertTrue("No se encontró botón Enviar", ExistsElementForXPath("//button[text()='Enviar']"));
		assertTrue("El botón Enviar no se encuentra activo", driver.findElement(By.xpath("//button[text()='Enviar']")).isEnabled());
		
		Thread.sleep(3000);
	}
	
	@OrderedTest(order=2)
	public void Test_NumeroDocumentoDNI_NoValido_BordeRojoEnControl() throws InterruptedException {
		
		driver.findElement(By.xpath("//ng-select[@formcontrolname=\"tipoDocumento\"]")).click();
		
		Thread.sleep(1000);
		
		List<WebElement> listaFinca = driver.findElements(By.xpath( "//ng-select[@formcontrolname=\"tipoDocumento\"]//ng-dropdown-panel[1]//descendant::span"));
		listaFinca.get(1).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"nroDocumento\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@formcontrolname=\"nombreApellido\"]")).sendKeys("Juan Carlos Rodriguez Mendoza");
		driver.findElement(By.xpath("//ngb-rating/span[10]")).click();
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"comentario\"]")).sendKeys("Estamos conforme con la atención");
		
		WebElement btnEnviar = driver.findElement(By.xpath("//button[text()='Enviar']"));
		btnEnviar.click();
		
		Thread.sleep(1000);
		
		assertTrue(driver.findElement(By.xpath("//input[@formcontrolname=\"nroDocumento\"]")).getDomAttribute("class").contains("is-invalid"));
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);
	
	}
	
	@OrderedTest(order=3)
	public void Test_RegistrarValoracionCafe_MostrarMensajeRegistroCorrecto() throws InterruptedException {
		driver.findElement(By.xpath("//ng-select[@formcontrolname=\"tipoDocumento\"]")).click();
		
		Thread.sleep(1000);
		
		List<WebElement> listaFinca = driver.findElements(By.xpath( "//ng-select[@formcontrolname=\"tipoDocumento\"]//ng-dropdown-panel[1]//descendant::span"));
		listaFinca.get(1).click();
		
	    int dni = (int)(Math.random()*(99999999-22222222+1)+22222222);
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"nroDocumento\"]")).sendKeys(String.valueOf(dni));
		
		driver.findElement(By.xpath("//input[@formcontrolname=\"nombreApellido\"]")).sendKeys("Juan Carlos Rodriguez Mendoza");
		driver.findElement(By.xpath("//ngb-rating/span[10]")).click();
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"comentario\"]")).sendKeys("Estamos conforme con la atención");
		
		WebElement btnEnviar = driver.findElement(By.xpath("//button[text()='Enviar']"));
		btnEnviar.click();
		
		Thread.sleep(1000);
		
		WebElement btnSi = driver.findElement(By.xpath("//div[@class=\"swal2-actions\"]//button[text()='Si']"));
		btnSi.click();
		
		Thread.sleep(3000);
		
		assertEquals("Su valoración ha sido registrada correctamente. Gracias", driver.findElement(By.id("swal2-content")).getText());
	}

	
	@After
	public void CerrarSesion() {
		driver.quit();
	}
}
