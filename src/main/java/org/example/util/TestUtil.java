package org.example.util;

import org.example.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    private static String currentDir = System.getProperty("user.dir");
    public static String TESTDATA_SHEET_PATH = currentDir
            + "/src/main/java/org/example/testdata/sample-test-data.xlsx";
    public static String TESTDATA_PATH = currentDir
            + "/src/main/java/org/example/testdata/";

    static Workbook book;
    static Sheet sheet;
    static JavascriptExecutor js;

    public void switchToFrameById(String id) {
        driver.switchTo().frame(id);
    }

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                // System.out.println(data[i][k]);
            }
        }
        return data;
    }

    public static void uploadFile(WebElement element, String file) {
        element.sendKeys(TESTDATA_PATH+file);
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    public static void flash(WebElement element, WebDriver driver) {
        js = (JavascriptExecutor) driver;
        String currentColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0)", element, driver);
            changeColor(currentColor, element, driver);
        }
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    private static void changeColor(String color, WebElement element, WebDriver driver) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {

        }
    }

    public static void drawBorder(WebElement element, WebDriver driver) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void generateAlert(WebDriver driver, String message) {
        js = (JavascriptExecutor) driver;
        js.executeScript("alert('"+message+"')");
    }

    public static void clickElementByJS(WebElement element, WebDriver driver) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void refreshBrowserByJS(WebDriver driver) {
        js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0)");
    }

    public static String getTitleByJS(WebDriver driver) {
        js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public String getPageInnerText(WebDriver driver) {
        js = (JavascriptExecutor) driver;
        String pageText = js.executeScript("return document.documentElement.innerText").toString();
        return pageText;
    }

    public static void scrollPageDown(WebDriver driver) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight");
    }

    public static void scrollIntoView(WebElement element, WebDriver driver) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }



    public static void runTimeInfo(String messageType, String message) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        // Check for jQuery on the page, add it if need be
        js.executeScript("if (!window.jQuery) {"
                + "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
                + "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
                + "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
        Thread.sleep(5000);

        // Use jQuery to add jquery-growl to the page
        js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

        // Use jQuery to add jquery-growl styles to the page
        js.executeScript("$('head').append('<link rel=\"stylesheet\" "
                + "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
        Thread.sleep(5000);

        // jquery-growl w/ no frills
        js.executeScript("$.growl({ title: 'GET', message: '/' });");
//'"+color+"'"
        if (messageType.equals("error")) {
            js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
        }else if(messageType.equals("info")){
            js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
        }else if(messageType.equals("warning")){
            js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
        }else
            System.out.println("no error message");
        // jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
        Thread.sleep(5000);
    }

}
