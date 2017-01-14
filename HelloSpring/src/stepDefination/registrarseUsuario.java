package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class registrarseUsuario {
	WebDriver driver = new FirefoxDriver();

	@Given("^Abrimos Mozilla Firefox4$")
	public void Abrimos_Mozilla_Firefox() throws Throwable {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		driver.get("http://localhost:8080/HelloSpring/");
		Thread.sleep(1000);
	}

	@When("^Pulsa registrarse$")
	public void Insertamos_nombre_contraseña() throws Throwable {
		WebElement boton = driver.findElement(By.name("Registrarse"));
		boton.click();
		Thread.sleep(1000);
	}
	
	@Then("^RellenoDeCampos$")
	public void aceptar() throws Throwable {
		Thread.sleep(5000);
		WebElement nombre = driver.findElement(By.name("user"));
		nombre.sendKeys("oscar");
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("oscar");
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("oscar@gmail.com");
		Thread.sleep(3000);
		WebElement boton = driver.findElement(By.name("aceptar"));
		boton.click();
		Thread.sleep(1000);
	}	

	@Then("^cerraremos el navegador4$")
	public void cerraremos_el_navegador() throws Throwable {
	    Thread.sleep(5000);
		driver.quit();
	}

}
