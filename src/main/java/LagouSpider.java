import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LagouSpider {
    public static void main(String[] args) {
        //设置webdriver路径
        System.setProperty("webdriver.chrome.driver",LagouSpider.class.getClassLoader().getResource("chromedriver.exe").getPath());
        //创建webdriver
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.lagou.com/zhaopin/Java/?labelWords=label/");
        webDriver.findElement(By.className("body-btn")).click();
        //通过xpath选中
        clickOption(webDriver, "工作经验", "在校/应届");
        clickOption(webDriver, "学历要求", "不要求");
        clickOption(webDriver, "融资阶段", "不限");
        clickOption(webDriver, "公司规模", "15-50人");
        clickOption(webDriver, "行业领域", "移动互联网");
    }

    private static void clickOption(WebDriver webDriver, String choseTitle, String optionTitle) {
        WebElement chosenElement = webDriver.findElement(By.xpath("//li[@class='multi-chosen']//span[contains(text(),'" + choseTitle + "')]"));
        WebElement optionElement = chosenElement.findElement(By.xpath("../a[contains(text(),'" + optionTitle + "')]"));
        optionElement.click();
    }
}
