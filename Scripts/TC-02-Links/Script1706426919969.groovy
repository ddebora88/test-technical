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
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Rumah Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Apartemen Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Ruko Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Tanah Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Kost Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Vila Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Komersial Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Ruang Kantor Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Gudang Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Hotel Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Kios Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Pabrik Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Gedung Bertingkat Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Kondotel Disewa'))
testObjectsList.add(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/a_Toko Disewa'))

//open browser
WebUI.openBrowser('https://www.99.co/id')
println(testObjectsList.size())
for (TestObject testObject : testObjectsList) {
// Perform actions on each Test Object
	WebUI.click(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/span_properti disewa'))
	String hyperlinkText = WebUI.getAttribute(testObject, 'innerText')
	WebUI.click(testObject)
	print(hyperlinkText)
	WebUI.verifyTextPresent(hyperlinkText, false)
	
	String title = WebUI.getText(findTestObject('Object Repository/TC-02/Page_99.co Indonesia Jual Beli Rumah Jadi Mudah/Page_Daftar Rumah Kontrakan di Indonesia  Harga Murah 2024/strong_105.347 properti ditemukan  1 dari 500 Halaman'))
	int indexOfFirstSpace = title.indexOf(' ')
	int totalIklan = Integer.parseInt((title.substring(0, indexOfFirstSpace)).replaceAll("\\.", ""))
	println(totalIklan)	
	WebUI.verifyGreaterThan(totalIklan, 0)
	
	WebUI.click(findTestObject('Object Repository/TC-01/Page_Rumah Dijual di Indonesia  Harga Terbaru 2024/a_Home'))
}
WebUI.closeBrowser()

