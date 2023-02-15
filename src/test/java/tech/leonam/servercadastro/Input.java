package tech.leonam.servercadastro;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Input {
    private final String XPATH_CADASTRAR = "//*[@id=\"botao\"]";
    private WebDriver webDriver;
    private Random random;
    private final String XPATH_NOME = "//*[@id=\"nome\"]";
    private final String XPATH_EMAIL = "//*[@id=\"emailInput\"]";
    private final String XPATH_SENHA = "//*[@id=\"senhaInput\"]";
    private final String XPATH_SEXO = "//*[@id=\"xexo\"]";
    private final String XPATH_SEXO_FEMININO = "//*[@id=\"xexo\"]/option[2]";
    private final String XPATH_SEXO_OUTRO = "//*[@id=\"xexo\"]/option[3]";
    private final String XPATH_SEXO_MASCULINO = "//*[@id=\"xexo\"]/option[1]";
    private final String URL = "file:///C:/Users/leona/IdeaProjects/ProjectPageCadastro/Site/cadastro.html";
    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\leona\\IdeaProjects\\ProjectPageCadastro\\src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(URL);
    }

    @Test
    void inputPessoas() throws IOException, ParseException {
        var jsonParser = new JSONParser();
        var jsonArray = (JSONArray) jsonParser.parse(new FileReader("src/main/resources/pessoas_falsas.json"));
        var random = new Random();

        for (var obj : jsonArray) {
            var jsonObject = (JSONObject) obj;

            var name = (String) jsonObject.get("Nome");
            var email = (String) jsonObject.get("Email");
            var sexo = (String) jsonObject.get("Sexo");

            if(sexo.contains("Masculino")){
                sexo = XPATH_SEXO_MASCULINO;
            } else if (sexo.contains("Feminino")) {
                sexo = XPATH_SEXO_FEMININO;
            } else sexo = XPATH_SEXO_OUTRO;

            webDriver.findElement(By.xpath(XPATH_NOME)).click();
            webDriver.findElement(By.xpath(XPATH_NOME)).sendKeys(name);
            webDriver.findElement(By.xpath(XPATH_EMAIL)).click();
            webDriver.findElement(By.xpath(XPATH_EMAIL)).sendKeys(email);
            webDriver.findElement(By.xpath(XPATH_SENHA)).click();
            webDriver.findElement(By.xpath(XPATH_SENHA)).sendKeys(String.valueOf(random.nextDouble()));
            webDriver.findElement(By.xpath(XPATH_SEXO)).click();
            webDriver.findElement(By.xpath(sexo)).click();
            webDriver.findElement(By.xpath(XPATH_CADASTRAR)).click();

            webDriver.get(URL);
        }
        webDriver.close();
    }
}

