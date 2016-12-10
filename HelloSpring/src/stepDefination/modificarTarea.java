package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class modificarTarea {
	WebDriver driver = new FirefoxDriver();
	//WebDriver driver = new ChromeDriver();
	//funciona
	@Given("^Abrimos Mozilla Firefox5$")
	public void Abrimos_Mozilla_Firefox() throws Throwable {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver.get("http://localhost:8080/HelloSpring/");
	//	driver.get("http://www.marca.es");

		Thread.sleep(1000);
	}

	@When("^Insertamos nombre y password en la barra5$")
	public void Insertamos_nombre_contraseña() throws Throwable {
		WebElement barraNombre = driver.findElement(By.name("user"));
		WebElement password = driver.findElement(By.name("password"));
		Thread.sleep(3000);
		barraNombre.sendKeys("pablo");
		Thread.sleep(3000);
		password.sendKeys("pablo");
		Thread.sleep(1000);
	}
	
	@Then("^boton aceptar5$")
	public void aceptar() throws Throwable {
		Thread.sleep(7000);
		WebElement boton= driver.findElement(By.name("aceptar"));
		boton.click();
		Thread.sleep(2000);
	}	
	
	@Then("^boton modificar$")
	public void anadir() throws Throwable {
		Thread.sleep(4000);
		WebElement nombre = driver.findElement(By.name("nombre"));
		nombre.sendKeys("pablooo");
		Thread.sleep(4000);
		WebElement prioridad = driver.findElement(By.name("prioridad"));
		prioridad.sendKeys("oooo");
		Thread.sleep(4000);
		WebElement pertenece = driver.findElement(By.name("pertenece"));
		pertenece.sendKeys("pablo");
		Thread.sleep(4000);
		WebElement fecha = driver.findElement(By.name("fecha_limite"));
		fecha.sendKeys("ooo");
		Thread.sleep(4000);
		WebElement notas = driver.findElement(By.name("notas"));
		notas.sendKeys("dasf");
		Thread.sleep(4000);
		WebElement estado = driver.findElement(By.name("estado"));
		estado.sendKeys("oo");
		Thread.sleep(4000);
		notas.sendKeys("TareaCambiada");
		Thread.sleep(4000);
		WebElement botonModificar = driver.findElement(By.name("modificar"));
		botonModificar.click();
		Thread.sleep(7000);
	}

	@Then("^cerraremos el navegador5$")
	public void cerraremos_el_navegador() throws Throwable {
	    Thread.sleep(5000);
		driver.quit();
	}
}
