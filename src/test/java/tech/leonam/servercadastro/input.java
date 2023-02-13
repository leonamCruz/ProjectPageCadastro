package tech.leonam.servercadastro;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class input {
    @Test
    void inputPessoas() {
        System.setProperty("webdriver.gecko.driver","/home/leonam/IdeaProjects/ServerCadastro/src/main/resources/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.google.com.br");
        System.out.println(driver.getTitle());
    }
}
