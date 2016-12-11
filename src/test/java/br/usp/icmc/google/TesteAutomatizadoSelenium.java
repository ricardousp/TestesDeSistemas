package br.usp.icmc.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizadoSelenium {
	
	public static void main(String[] args) {
	
		// WebDriver é a abstração que representa todos os browsers do Selenium
		WebDriver driver = new FirefoxDriver();
		
		// Invoca o método get passando a url do site que queremos abrir
		driver.get("http://www.google.com.br");
		
		// Webelement representa o objeto da página HTML que desejamos encontrar
		// FindElement recebe a maneira que devemos buscar o elemento na página HTML
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		
		// Enviamos um texto para o campo de texto
		campoDeTexto.sendKeys("Universidade de São Paulo");
		
		// O Selenium submete o formulário do Google
		campoDeTexto.submit();
	}
	
}
