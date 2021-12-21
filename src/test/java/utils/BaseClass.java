package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public WebDriver driver;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement $(String locator) {
		if (locator.startsWith("//")) {
			return driver.findElement(By.xpath(locator));
		} else {
			return driver.findElement(By.id(locator));
		}
	}
	
	public List<WebElement> elems(String locator) {
		if (locator.startsWith("//")) {
			return driver.findElements(By.xpath(locator));
		} else {
			return driver.findElements(By.id(locator));
		}
	}

	protected int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(500000);
	}

	public boolean goThroughMultipleStuff(String locator, String textToSearch) {
		boolean flag = false;
		List<WebElement> lista = driver.findElements(By.xpath(locator));
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getText().contains(textToSearch)) {
				flag = true;
			}
		}
		return flag;
	}
	
//	public void selectDropdown(String locator, String text) {
//		WebElement dropdownList = $(locator);
//		List<WebElement> options = dropdownList.findElements(By.tagName("option"));
//		for (int i = 0; i < options.size(); i++) {
//			if (options.get(i).getText().equals(text)) {
//				options.get(i).click();
//			}
//		}
//	}

	public void selectDropdownByText(String locator, String text){
		Select dropdownList;
		if (locator.startsWith("//")) {
			dropdownList = new Select(driver.findElement(By.xpath(locator)));
		} else {
			dropdownList = new Select(driver.findElement(By.id(locator)));
		}
		dropdownList.selectByVisibleText(text);
	}

	public void selectFromListByText(String locator, String text){
		List<WebElement> lista = driver.findElements(By.xpath(locator));
		for (int i=1;i<=lista.size(); i++){
			if($(locator+"/li["+i+"]/span").getText().equals(text)){
				$(locator+"/li["+i+"]/span").click();
			}else break;
		}
	}

	public void navigate_to_section(List<WebElement> links, String menu_section) {
		for (WebElement link : links) {
			System.out.println("Section: " + link.getText());
			if (link.getText().equalsIgnoreCase(menu_section)) {
				link.click();
			}
		}
	}
	
	public void scrollToXpathElement(String locator) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement Project = driver.findElement(By.xpath(locator));
		je.executeScript("arguments[0].scrollIntoView(true);", Project);
	}

	public void scrollToIdElement(String locator) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement Project = driver.findElement(By.id(locator));
		je.executeScript("arguments[0].scrollIntoView(true);", Project);
	}

	public void scrollOnElement(String locator1, String locator2) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		WebElement container, element;

		if(locator1.startsWith("//")){
			container = driver.findElement(By.xpath(locator1));
		}else{
			container = driver.findElement(By.id(locator1));
		}

		if(locator2.startsWith("//")){
			element = driver.findElement(By.xpath(locator2));
		}else{
			element = driver.findElement(By.id(locator2));
		}
		actions.moveToElement(container).perform();
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void hoverOnElement(String locator) {
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(locator));
		actions.moveToElement(element).perform();
	}
	
	public void wait_for_id_elem_to_be_visible(String locator, int time) {
//        System.out.println("and the element is: "+locator);
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }
	
	public void wait_for_xpath_elem_to_be_visible(String locator, int time) {
//        System.out.println("and the element is: "+locator);
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
   

    public void wait_for_id_elem_to_be_clickable(String locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(
                ExpectedConditions.elementToBeClickable(By.id(locator)));
    }

    public void wait_for_xpath_elem_to_be_clickable(String locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
    
    public  Properties readPropertiesFile(String fileName) {
        Properties propFile = new Properties();
        InputStream input = null;
        Path currentRelativePath = Paths.get("");

        String file = currentRelativePath.toAbsolutePath().toString() + "/src/test/resources/" + fileName + ".properties";
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // load a properties file
        try {
            Reader reader = null;
            if (input != null) {
                reader = new InputStreamReader(input, "UTF-8");
            }
            propFile.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propFile;
    }

    public void writePropertiesFile(String fileName, String value) {
    	Path currentRelativePath = Paths.get("");
        String file = currentRelativePath.toAbsolutePath().toString() + "/src/test/resources/" + fileName + ".properties";
    	
        try (OutputStream output = new FileOutputStream(file)) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("formName", value);
           

            // save properties to project root folder
            prop.store(output, null);
           
            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
