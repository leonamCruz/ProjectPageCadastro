package tech.leonam.servercadastro;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class input {
    @Test
    void inputPessoas() {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("www.google.com");
    }
}
