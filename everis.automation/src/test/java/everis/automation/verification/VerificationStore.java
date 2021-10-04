package everis.automation.verification;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationStore {

	private WebDriver driver;

	public VerificationStore(WebDriver driver) {
		this.driver = driver;
	}

	public void verificarValorDeCadaProdutoEValorFinal( String valorFinal, String... todosValores) {
		int cont = 0;
		List<WebElement> valores = driver.findElements(By.cssSelector(
				"body.order.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 div.table_block.table-responsive:nth-child(5) table.table.table-bordered.stock-management-on tbody:nth-child(3) tr > td.cart_total"));
		for (WebElement valor : valores) {
			for (String valoresEnviados : todosValores) {
				if (valor.getText().contains(valoresEnviados)) {
					cont++;
				}
			}
		}
		String valorFinalTela = driver.findElement(By.id("total_price_container")).getText();
		
		Assert.assertEquals(todosValores.length, cont++);
		Assert.assertEquals(valorFinal, valorFinalTela);
	}

	public void verificarCarrinhoVazio() {
		String msgCarrinhoVazio = driver.findElement(By.cssSelector("body.order.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 > p.alert.alert-warning")).getText();
		Assert.assertEquals("Your shopping cart is empty.", msgCarrinhoVazio);
	}
}