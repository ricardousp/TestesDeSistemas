package br.usp.icmc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoUsuarioPage {
	
	private WebDriver driver;
	
	public NovoUsuarioPage(WebDriver driver){
		this.driver = driver;
	}

	public void cadastrar(String nome, String email){
		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));
		
		txtNome.sendKeys(nome);
		txtEmail.sendKeys(email);
		
		txtNome.submit();
	}
	
	public boolean verificaMsgExecaoNome(){
		return driver.getPageSource().contains("Nome obrigatorio!");
	}
	
	public boolean verificaMsgExecaoEmail(){
		return driver.getPageSource().contains("E-mail obrigatorio!");
	}
	
	public boolean verificaCampoNome(){
		return driver.getPageSource().contains("Nome:");
	}
	
	public boolean verificaCampoEmail(){
		return driver.getPageSource().contains("E-mail:");		
	}
	
}
