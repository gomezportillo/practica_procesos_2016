package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class modificarUsuario {
	WebDriver driver = new FirefoxDriver();
	
	@Given("^Abrimos Mozilla Firefox8$")
	public void Abrimos_Mozilla_Firefox() throws Throwable {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		driver.get("http://localhost:8080/HelloSpring/");

		Thread.sleep(1000);
	}

	@When("^Insertamos nombre y password en la barra8$")
	public void Insertamos_nombre_contraseņa() throws Throwable {
		WebElement barraNombre = driver.findElement(By.name("user"));
		WebElement password = driver.findElement(By.name("password"));
		barraNombre.sendKeys("pablo");
		password.sendKeys("pablo");
		Thread.sleep(1000);
	}
	
	@Then("^boton aceptar8$")
	public void aceptar() throws Throwable {
		WebElement boton= driver.findElement(By.name("aceptar"));
		boton.click();
	}	
	
	@Then("^boton admin2$")
	public void anadirUsuario() throws Throwable {
		Thread.sleep(7000);
		WebElement botonAdmin = driver.findElement(By.name("Panel_admin"));
		botonAdmin.click();
		Thread.sleep(7000);
		WebElement nombre = driver.findElement(By.name("user"));
		nombre.sendKeys("_CAMBIADO");
//		Thread.sleep(2000);
//		WebElement email = driver.findElement(By.name("email"));
//		email.sendKeys("paco@gmail.com");
//		Thread.sleep(2000);
//		WebElement rol = driver.findElement(By.name("rol"));
//		rol.sendKeys("Usuario");
		Thread.sleep(2000);
		WebElement boton= driver.findElement(By.name("boton2"));
		boton.click();
	}

	@Then("^cerraremos el navegador8$")
	public void cerraremos_el_navegador() throws Throwable {
	    Thread.sleep(5000);
		driver.quit();
	}
}
