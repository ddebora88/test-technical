import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.FindWebElementKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.console.ui.BytecodeCollector
import internal.GlobalVariable

import org.openqa.selenium.By.ByXPath
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

WebUI.openBrowser('')
WebDriver driver = DriverFactory.getWebDriver()

WebUI.navigateToUrl('https://www.99.co/id')
WebUI.click(findTestObject('Object Repository/Search/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/div_rumah'))

List<WebElement> listTipe= driver.findElements(By.xpath("//div[@id='__next']/main/section/form/div[2]/div/div[2]/ul/li"))
WebUI.verifyEqual(listTipe.size(), 15)
//verify list terakhir harus bernama toko
WebUI.verifyEqual(listTipe[14].getText(), 'Toko')

//verify data yang muncul di di setelah tipe dipilih adalah sama
listTipe[1].click()
String tipe =WebUI.getAttribute(findTestObject('Object Repository/Search/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/span_rumah'), 'innerText')
WebUI.verifyEqual(tipe,'Apartment')

WebUI.closeBrowser()
	