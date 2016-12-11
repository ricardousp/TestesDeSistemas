package br.usp.icmc.google;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizadoComSeleniumEJUnit {

	private WebDriver driver;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void testeGoogle() {
		driver.get("http://www.google.com.br");
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys("Universidade de São Paulo");
		campoDeTexto.submit();
		WebElement linkResultado = driver.findElement(By.partialLinkText("USP - Universidade de São Paulo"));
		assertTrue(linkResultado.getText().contains("USP - Universidade de São Paulo"));
		assertEquals("Universidade de São Paulo - Pesquisa Google", driver.getTitle());
	}

	@After
	public void finaliza() throws Exception {
		driver.quit();
	}

}
