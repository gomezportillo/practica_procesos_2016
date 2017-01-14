package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class anadirNuevaTarea {
	WebDriver driver = new FirefoxDriver();

	@Given("^Abrimos Mozilla Firefox2$")
	public void Abrimos_Mozilla_Firefox() throws Throwable {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		driver.get("http://localhost:8080/HelloSpring/");
		Thread.sleep(1000);
	}

	@When("^Insertamos nombre y password en la barra2$")
	public void Insertamos_nombre_contraseña() throws Throwable {
		WebElement barraNombre = driver.findElement(By.name("user"));
		WebElement password = driver.findElement(By.name("password"));
		barraNombre.sendKeys("pablo");
		password.sendKeys("pablo");
		Thread.sleep(2000);
	}
	
	@Then("^boton aceptar2$")
	public void aceptar() throws Throwable {
		WebElement boton= driver.findElement(By.name("aceptar"));
		boton.click();
	}	
	
	@Then("^boton anadir$")
	public void anadir() throws Throwable {;
		Thread.sleep(8000);
		WebElement nombre = driver.findElement(By.name("nombre"));
		nombre.sendKeys("Tarea1");
		Thread.sleep(2000);
		WebElement prioridad = driver.findElement(By.name("prioridad"));
		prioridad.sendKeys("2");
		Thread.sleep(2000);
		WebElement fecha = driver.findElement(By.name("fecha_limite"));
		fecha.sendKeys("2018/01/02");
		Thread.sleep(2000);
		WebElement estado = driver.findElement(By.name("estado"));
		estado.sendKeys("En curso");
		Thread.sleep(2000);
		WebElement pertenece = driver.findElement(By.name("pertenece"));
		pertenece.sendKeys("pablo");
		Thread.sleep(2000);
		WebElement notas = driver.findElement(By.name("notas"));
		notas.sendKeys("Tarea1");
		Thread.sleep(2000);
		WebElement boton= driver.findElement(By.name("boton1"));
		boton.click();
		Thread.sleep(2000);
	}

	@Then("^cerraremos el navegador2$")
	public void cerraremos_el_navegador() throws Throwable {
	    Thread.sleep(10000);
		driver.quit();
	}
}
