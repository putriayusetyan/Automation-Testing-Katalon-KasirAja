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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.waitForElementVisible(findTestObject('Login/welcoming_page'), 10)

WebUI.setText(findTestObject('Login/email_form'), 'sumbermakmur@store.com')

WebUI.setEncryptedText(findTestObject('Login/password_form'), 'AtelZsWJcEGTZ93ys0Z68A==')

WebUI.click(findTestObject('Login/login button'))

WebUI.waitForElementVisible(findTestObject('Dashboard/welcoming_text'), 20)

WebUI.click(findTestObject('Dashboard/profile_account_user'))

WebUI.click(findTestObject('Dashboard/profile_account_user2'))

WebUI.sendKeys(findTestObject('Profile_Acc/nama_form'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Profile_Acc/nama_form'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Profile_Acc/nama_form'), 'sumber makmur')

WebUI.sendKeys(findTestObject('Profile_Acc/email_form'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Profile_Acc/email_form'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Profile_Acc/email_form'), 'sumbermakmur@store.com')

WebUI.setEncryptedText(findTestObject('Profile_Acc/password_form'), 'AtelZsWJcEGTZ93ys0Z68A==')

WebUI.click(findTestObject('Profile_Acc/simpan_button'))

WebUI.waitForElementVisible(findTestObject('Profile_Acc/alert_message'), 10)

String successMessage = WebUI.getText(findTestObject('Profile_Acc/alert_message'))

if (!(successMessage.contains('No changes'))) {
    // If the success message doesn't contain the expected content, mark the test as failed
    WebUI.comment('Test Failed: Incorrect success message displayed.')

    WebUI.takeScreenshot('Test_Failed_Incorrect_Success_Message')

    assert false
}

WebUI.closeBrowser()

