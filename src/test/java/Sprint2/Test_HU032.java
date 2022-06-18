package Sprint2;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.OrderedTest;
import Base.TestRunner;

@RunWith(TestRunner.class)
public class Test_HU032 extends BaseTest {
	@Before
	public void InitTest() throws InterruptedException
	{
		AbrirLink();
		super.email = "mablancome@gmail.com";
		super.password = "P@ssw0rd100";
		IniciarSesion();
	}
	
	@OrderedTest(order=1)
	public void Test_ProyectarCosechasAgricultor_SistemaMuestraCosechaProyectada() throws InterruptedException {
		WebElement Module1 = driver.findElement(By.xpath("//span[text()=\"Proyecciones\"]"));
		Module1.click();
		
		Thread.sleep(500);
		
		WebElement Module2 = driver.findElement(By.xpath("//span[text()='Proyecciones']/parent::a/parent::li/ul/li/a/span[text()='Cosecha']"));
		Module2.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//ng-select[@formcontrolname=\"periodo\"]")).click();
		
		Thread.sleep(1000);
		
		List<WebElement> listaActores = driver.findElements(By.xpath( "//ng-select[@formcontrolname=\"periodo\"]//ng-dropdown-panel[1]//descendant::span"));
		listaActores.get(3).click();
		
		
		WebElement btnProyectar = driver.findElement(By.xpath("//button[text()='Proyectar']"));
		btnProyectar.click();

		Thread.sleep(3000);
	
		assertTrue("No se encontró el encabezado de la proyección", driver.findElements(By.xpath("//table/thead/tr/th")).size() > 0);
		assertTrue("No se encontró el detalle de la proyección", driver.findElements(By.xpath("//table/tbody/tr/td")).size() > 0);
		
		Thread.sleep(1000);
	}
	
	@After
	public void CerrarSesion() {
		driver.quit();
	}
}
