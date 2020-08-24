package Testmodule;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BobbleTestCap {
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;
		
		File appDir = new File("src");
		File app = new File(appDir, "Notepad Free_v1.10.0_apkpure.com.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "42009babd330a453");
		capabilities.setCapability("BobbleAIKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		return driver;
	}

}


