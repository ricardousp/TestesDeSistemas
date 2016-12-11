package br.usp.icmc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlteraUsuarioPage {
	
	private WebDriver driver;
	
	public AlteraUsuarioPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void para(String nome, String email){
		// Informa ao Selenium os elementos html correspondentes ao nome e email (Pega os elementos html por meio do nome de cada elemento)
		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));
		
		txtNome.clear();
		txtEmail.clear();
		
		// Preenche os campos do formulário com dados abaixo (Preenche os elementos)
		txtNome.sendKeys(nome);
		txtEmail.sendKeys(email);
		
		txtNome.submit();
	}
	
}
