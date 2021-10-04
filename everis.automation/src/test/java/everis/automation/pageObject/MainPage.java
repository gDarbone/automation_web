package everis.automation.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clicarEmUmProdutoNaTelaMain(String produto) {
		driver.findElement(By.partialLinkText(produto)).click();
	}

	public void clicarEmOutroProdutoNaTelaMain() {
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
	}

	public void clicarAddToCart() {
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
	}

	public void voltarTelaMain() {
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
	}

	public void clicarIrParaCarrinho() {
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")).click();
		
	}
	public void clicarContinuarComprando() {
		driver.findElement(By.cssSelector("body.product.product-1.product-faded-short-sleeve-tshirts.category-5.category-tshirts.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div.clearfix div.layer_cart_cart.col-xs-12.col-md-6 div.button-container:nth-child(5) span.continue.btn.btn-default.button.exclusive-medium > span:nth-child(1)")).click();
	}
	public void clicarFechar() {
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/span[1]")).click();
	}

	public void clicarCarrinho() {
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")).click();
	}

	public void removerPrimeiroProduto() {
		driver.findElement(By.className("cart_quantity_delete")).click();
	}

	public void aumentarQuantidadePrimeiroProduto() {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/a[2]")).click();
	}

	public void diminuirQuantidadePrimeiroProduto() {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/a[1]")).click();
	}
}
