package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class InvokedListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            ITestContext iTestContext = testResult.getTestContext();
            WebDriver driver = (WebDriver) iTestContext.getAttribute("WebDriver");

            try {
                Allure.addAttachment(UUID.randomUUID().toString(),
                        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            } catch (NoSuchSessionException ex) {

            }
        }
    }
}
