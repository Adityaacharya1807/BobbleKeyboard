package Testmodule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BobbleTestscen extends BobbleTestCap {
	@Test
	public void BobbleTestCase() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		File file = new File("/Users/apple/BobbleTest/BobbleProject/dataread.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String elementpath = prop.getProperty("Add");
		driver.findElement(By.xpath(elementpath)).click();
		for (int i = 0; i < 9; i++) {
			driver.pressKey(new KeyEvent(AndroidKey.A));
		}
		Assert.assertNotNull(elementpath);
		String element = prop.getProperty("data");
		driver.findElement(By.xpath(element)).click();
		driver.getKeyboard();
		driver.findElement(By.xpath(prop.getProperty("data"))).sendKeys("😐");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("data"))).sendKeys(prop.getProperty("para"));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.xpath(prop.getProperty("data"))).sendKeys("🖐");
		driver.pressKey(new KeyEvent(AndroidKey.CAMERA));
		driver.findElement(By.xpath(prop.getProperty("click"))).click();
		driver.navigate().back();
		
		boolean isKeyboardVisible= driver.isKeyboardShown();
		System.out.println(isKeyboardVisible);
		driver.pressKey(new KeyEvent(AndroidKey.VOICE_ASSIST));
		

	}

}
