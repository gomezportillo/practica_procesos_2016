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
		driver.get("http://localhost:8080/HelloSpring/");

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
		Thread.sleep(8000);
//		WebElement nombre = driver.findElement(By.name("nombre"));
//		nombre.sendKeys("Tarea1");
//		Thread.sleep(2000);
//		WebElement prioridad = driver.findElement(By.name("prioridad"));
//		prioridad.sendKeys("2");
//		Thread.sleep(2000);
//		WebElement fecha = driver.findElement(By.name("fecha_limite"));
//		fecha.sendKeys("2018/01/02");
//		Thread.sleep(2000);
//		WebElement estado = driver.findElement(By.name("estado"));
//		estado.sendKeys("En curso");
//		Thread.sleep(2000);
//		WebElement pertenece = driver.findElement(By.name("pertenece"));
//		pertenece.sendKeys("pablo");
//		Thread.sleep(2000);
		WebElement notas = driver.findElement(By.name("notas"));
		notas.sendKeys("_TareaCambiada");
		Thread.sleep(2000);
		WebElement boton= driver.findElement(By.name("boton2"));
		boton.click();
		Thread.sleep(2000);
	}

	@Then("^cerraremos el navegador5$")
	public void cerraremos_el_navegador() throws Throwable {
	    Thread.sleep(5000);
		driver.quit();
	}
}
