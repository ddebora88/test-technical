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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Get the list of Test Objects from the Object Repository
List<TestObject> testObjectsList = new ArrayList<TestObject>()
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Rumah Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Apartemen Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Ruko Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Tanah Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Kios Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Vila Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Komersial Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Ruang Kantor Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Gudang Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Hotel Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Kost Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Pabrik Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Gedung Bertingkat Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Kondotel Dijual'))
testObjectsList.add(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Toko Dijual'))


//open browser
WebUI.openBrowser('https://www.99.co/id')

for (TestObject testObject : testObjectsList) {
	WebUI.click(findTestObject('Object Repository/TC-01/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/button_properti dijual'))
	String hyperlinkText = WebUI.getAttribute(testObject, 'innerText')
	WebUI.click(testObject)
	WebUI.verifyTextPresent('Rumah Dijual', false)
	
	String title = WebUI.getText(findTestObject('Object Repository/TC-01/Page_Rumah Dijual di Indonesia  Harga Terbaru 2024/strong_1.358.330 properti ditemukan  1 dari 500 Halaman'))
	int indexOfFirstSpace = title.indexOf(' ')
	int totalIklan = Integer.parseInt((title.substring(0, indexOfFirstSpace)).replaceAll("\\.", ""))
	println(totalIklan)
	
	WebUI.verifyGreaterThan(totalIklan, 0)
	WebUI.click(findTestObject('Object Repository/TC-01/Page_Rumah Dijual di Indonesia  Harga Terbaru 2024/a_Home'))
}
WebUI.closeBrowser()

