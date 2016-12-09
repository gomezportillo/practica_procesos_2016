package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login {

	WebDriver driver = new FirefoxDriver();

	@Given("^Abrimos Mozilla Firefox$")
	public void Abrimos_Mozilla_Firefox() throws Throwable {
		
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		driver.get("http://localhost:8080/HelloSpring/");

		Thread.sleep(1000);
	}

	@When("^Insertamos nombre y password en la barra$")
	public void Insertamos_nombre_contraseña() throws Throwable {
		WebElement barraNombre = driver.findElement(By.name("user"));
		WebElement password = driver.findElement(By.name("password"));
		Thread.sleep(2000);
		barraNombre.sendKeys("pablo");
		//barraNombre.submit();
		Thread.sleep(2000);
		password.sendKeys("pablo");
		Thread.sleep(1000);
	}
	
	@Then("^boton aceptar$")
	public void aceptar() throws Throwable {
		Thread.sleep(2000);
		WebElement boton= driver.findElement(By.name("aceptar"));
		boton.click();
	}	

	@Then("^cerraremos el navegador$")
	public void cerraremos_el_navegador() throws Throwable {
	    driver.quit();
	}
}
