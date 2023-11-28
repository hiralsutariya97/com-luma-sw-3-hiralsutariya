package testsuite;
/**
 * Write down the following test into WomenTestclass
 * 1. verifyTheSortByProductNameFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Product Name”
 * * Verify the products name display in
 * alphabetical order
 * 2. verifyTheSortByPriceFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Price”
 * * Verify the products price display in
 * Low to High
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //Mouse hover on women menu
        mouseHoverElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));

        //Mouse hover on tops
        mouseHoverElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        //CLick o jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select sort by filter "Product Name"
        WebElement sortby = driver.findElement(By.id("sorter"));
        Select select = new Select(sortby);   //creating object of select
        select.selectByVisibleText("Product Name");

        //Verify the products name display in alphabetical order
        displayNameAlphabetically();
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        //Mouse hover on women menu
        mouseHoverElement(By.cssSelector("a[id='ui-id-4'] span:nth-child(2)"));

        //Mouse hover on tops
        mouseHoverElement(By.cssSelector("a[id='ui-id-9'] span:nth-child(2)"));

        //CLick o jackets
        clickOnElement(By.cssSelector("a[id='ui-id-11'] span"));

        //select sort by filter 'price'
        WebElement sortby = driver.findElement(By.id("sorter"));
        Select select = new Select(sortby);
        select.selectByVisibleText("Price");
        Thread.sleep(10);

        //verify the products price display in low to high
        sortPriceLowToHigh();
        Thread.sleep(10);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
