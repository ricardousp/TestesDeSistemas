package br.usp.icmc.page;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Representará a página de listagens dos usuários
public class ListarUsuariosPage {

	// Vamos receber o driver do mundo de fora
	// Recebe-lo do nosso teste
	private WebDriver driver;

	public ListarUsuariosPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get("http://www.labes.icmc.usp.br:8788/usuarios");
	}

	public NovoUsuarioPage novo() {
		// Não busca pelo nome e nem pelo id, mas pelo texto que está dentro do
		// link
		driver.findElement(By.linkText("Novo Usuário")).click();
		return new NovoUsuarioPage(driver);
	}

	public List<WebElement> getRegistrosDeUsuarios() {
		List<WebElement> linhasUsuarios = driver.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		return linhasUsuarios;
	}

	// Teste que cadastra um usuário para testar a exclusão do mesmo de forma
	// independente
	public void deletaUsuarioNaPosicao(int posicao) {
		driver.findElements(By.tagName("button")).get(posicao - 1).click();
		// Permite buscar o alert que está aberto
		Alert alert = driver.switchTo().alert();
		// confirma a operação
		alert.accept();
	}
	
	public AlteraUsuarioPage alteraUsuarioNaPosicao(int posicao){		
		 // 1o link de editar que aparecer
		driver.findElements(By.linkText("editar")).get(posicao-1).click();					
		return new AlteraUsuarioPage(driver);
	}	

	public void deletaUsuarioNaUltimaPosicao() {
		driver.findElements(By.linkText("Deletar")).get(getRegistrosDeUsuarios().size() - 1).click();
	}

	public boolean existeNaListagem(String nome, String email) {
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(email);
	}
}
