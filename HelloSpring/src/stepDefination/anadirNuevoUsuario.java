package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class anadirNuevoUsuario {
	
	WebDriver driver = new FirefoxDriver();
	//WebDriver driver = new ChromeDriver();
	//funciona
	@Given("^Abrimos Mozilla Firefox3$")
	public void Abrimos_Mozilla_Firefox() throws Throwable {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver.get("http://localhost:8080/HelloSpring/");
	//	driver.get("http://www.marca.es");

		Thread.sleep(1000);
	}

	@When("^Insertamos nombre y password en la barra3$")
	public void Insertamos_nombre_contraseña() throws Throwable {
		WebElement barraNombre = driver.findElement(By.name("user"));
		WebElement password = driver.findElement(By.name("password"));
		barraNombre.sendKeys("julio");
		barraNombre.submit();
		password.sendKeys("julio");
		password.submit();
		Thread.sleep(1000);
	}
	
	@Then("^boton aceptar3$")
	public void aceptar() throws Throwable {
		WebElement boton= driver.findElement(By.name("aceptar"));
		boton.click();
	}	
	
	@Then("^boton admin$")
	public void anadirUsuario() throws Throwable {
		Thread.sleep(7000);
		WebElement botonAdmin = driver.findElement(By.name("Panel_admin"));
		botonAdmin.click();
		Thread.sleep(7000);
		WebElement nombre = driver.findElement(By.name("user"));
		nombre.sendKeys("Paquito");
		nombre.submit();
		WebElement prioridad = driver.findElement(By.name("password"));
		prioridad.sendKeys("paquito");
		prioridad.submit();
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("paco@gmail.com");
		email.submit();
		WebElement rol = driver.findElement(By.name("rol"));
		rol.sendKeys("Usuario");
		rol.submit();
		WebElement boton= driver.findElement(By.name("anadir"));
		boton.click();
	}

	@Then("^cerraremos el navegador3$")
	public void cerraremos_el_navegador() throws Throwable {
	    Thread.sleep(5000);
		driver.quit();
	}
	
}
