import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.BreakIterator

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
import org.apache.poi.hssf.record.PageBreakRecord.Break
import org.openqa.selenium.By

WebUI.openBrowser('')
WebDriver driver = DriverFactory.getWebDriver()
String [] keywordLokasi = ['Antapani','Depok']

WebUI.navigateToUrl('https://www.99.co/id')

for (int i = 0; i < keywordLokasi.length; i++) {
//pemilihan tipe
	WebUI.click(findTestObject('Object Repository/Search/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/div_rumah'))
	List<WebElement> listTipe= driver.findElements(By.xpath("//div[@id='__next']/main/section/form/div[2]/div/div[2]/ul/li"))
	listTipe[i].click()
	
	//tap field lokasi
	TestObject searchField = findTestObject('Object Repository/Search/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/input_search-bar')
	WebUI.setText(searchField, keywordLokasi[i])
	WebUI.click(searchField)
	//WebUI.waitForElementClickable(findTestObject('Object Repository/Search/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/div_Bandung'), 100)
	WebUI.click(findTestObject('Object Repository/Search/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/div_Bandung'))	

	String jenis =WebUI.getAttribute(findTestObject('Object Repository/Search/Page_Rumah Dijual di Antapani, Bandung  Harga Terbaik  Bisa KPR/a_Rumah Dijual'), 'innerText')
	String iklan = WebUI.getText(findTestObject('Object Repository/search_result/Page_Rumah Dijual di Bandung  Harga Terbaik, Bisa KPR  Cash/strong_181.965 properti ditemukan  1 dari 500 Halaman'))
	String lokasi = WebUI.getText(findTestObject('Object Repository/search_result/Page_Rumah Dijual di Bandung  Harga Terbaik, Bisa KPR  Cash/address_Arcamanik, Bandung'))
	int indexOfFirstSpace = iklan.indexOf(' ')
	int totalIklan = Integer.parseInt((iklan.substring(0, indexOfFirstSpace)).replaceAll("\\.", ""))
	println(totalIklan)
	println(lokasi)
	println(jenis)

	//verify terdapat iklan yang ditampilkan minimal 1
	WebUI.verifyGreaterThan(totalIklan, 0)
	//verify jika item pertama lokasi mengandung kata antapani dan dijual
		if (!lokasi.contains(keywordLokasi[i])) {
			com.kms.katalon.core.util.KeywordUtil.markFailed("Kata "+keywordLokasi[i]+" tidak ditemukan dalam item pertama")		
			break
			}
		else if (!jenis.contains("Dijual")) {
			com.kms.katalon.core.util.KeywordUtil.markFailed("Kata Dijual tidak ditemukan dalam item pertama")
			break			
			}
	WebUI.navigateToUrl('https://www.99.co/id')
}

WebUI.closeBrowser()
	
	