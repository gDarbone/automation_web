package everis.automation.testExecutionE2E;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import everis.automation.core.SystemSettings;
import everis.automation.pageObject.MainPage;
import everis.automation.verification.VerificationStore;

public class MyStoreTest {

	private MainPage mainPage;
	private SystemSettings set;
	private VerificationStore vStore;

	@BeforeEach
	public void beforeEach() {
		set = new SystemSettings();
		mainPage = new MainPage(getDriver());
		vStore = new VerificationStore(getDriver());
	}

	@AfterEach
	public void afterEach() {
		// driver.quit();
	}

	@Test
	public void adicionarUmProdutoCarrinho() {
		mainPage.clicarEmUmProdutoNaTelaMain("Faded Short Sleeve T");
		mainPage.clicarAddToCart();
		esperar(4000);
		mainPage.clicarFechar();
		mainPage.clicarCarrinho();
		vStore.verificarValorDeCadaProdutoEValorFinal("$18.51", "16.51");
	}

	@Test
	public void adicionarDoisProdutoCarrinho() {
		mainPage.clicarEmUmProdutoNaTelaMain("Faded Short Sleeve T");
		mainPage.clicarAddToCart();
		esperar(4000);
		mainPage.clicarContinuarComprando();
		mainPage.voltarTelaMain();
		mainPage.clicarEmUmProdutoNaTelaMain("Blouse");
		mainPage.clicarAddToCart();
		esperar(5000);
		mainPage.clicarFechar();
		mainPage.clicarCarrinho();
		vStore.verificarValorDeCadaProdutoEValorFinal("$45.51", "16.51", "27.00");
	}

	@Test
	public void adicionarUmProdutoCarrinhoRemoverProduto() {
		mainPage.clicarEmUmProdutoNaTelaMain("Faded Short Sleeve T");
		mainPage.clicarAddToCart();
		esperar(4000);
		mainPage.clicarFechar();
		mainPage.clicarCarrinho();
		mainPage.removerPrimeiroProduto();
		esperar(3000);
		vStore.verificarCarrinhoVazio();
	}

	@Test
	public void adicionarDoisProdutoCarrinhoRemoverUmProduto() {
		mainPage.clicarEmUmProdutoNaTelaMain("Faded Short Sleeve T");
		mainPage.clicarAddToCart();
		esperar(4000);
		mainPage.clicarContinuarComprando();
		mainPage.voltarTelaMain();
		mainPage.clicarEmUmProdutoNaTelaMain("Blouse");
		mainPage.clicarAddToCart();
		esperar(5000);
		mainPage.clicarFechar();
		mainPage.clicarCarrinho();
		mainPage.removerPrimeiroProduto();
		esperar(3000);
		vStore.verificarValorDeCadaProdutoEValorFinal("$29.00", "27.00");
	}
	
	@Test
	public void adicionarUmProdutoAumentarQuantidade() {
		mainPage.clicarEmUmProdutoNaTelaMain("Faded Short Sleeve T");
		mainPage.clicarAddToCart();
		esperar(4000);
		mainPage.clicarFechar();
		mainPage.clicarCarrinho();
		mainPage.aumentarQuantidadePrimeiroProduto();
		esperar(3000);
		vStore.verificarValorDeCadaProdutoEValorFinal("$35.02", "33.02");
	}
	
	@Test
	public void adicionarDoisProdutoDiminuirQuantidade() {
		mainPage.clicarEmUmProdutoNaTelaMain("Faded Short Sleeve T");
		mainPage.clicarAddToCart();
		esperar(4000);
		mainPage.clicarContinuarComprando();
		mainPage.voltarTelaMain();
		mainPage.clicarEmUmProdutoNaTelaMain("Blouse");
		mainPage.clicarAddToCart();
		esperar(5000);
		mainPage.clicarFechar();
		mainPage.clicarCarrinho();
		mainPage.diminuirQuantidadePrimeiroProduto();
		esperar(3000);
		vStore.verificarValorDeCadaProdutoEValorFinal("$29.00", "27.00");
	}

	
	
	
	public WebDriver getDriver() {
		return set.getDriver();

	}

	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
