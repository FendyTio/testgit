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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
'open browser'
WebUI.openBrowser('')

'input web R3 LOS'
WebUI.navigateToUrl(findTestData('Login/Login').getValue(1, 1))

'Hover LOS module'
WebUI.mouseOver(findTestObject('LoginR3BranchManagerSuperuser/NewLogin/card_LOS'))

WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/NewLogin/button_Go Inside'))

'input username'
WebUI.setText(findTestObject('LoginR3BranchManagerSuperuser/input_Loan Origination System_inputUser'), findTestData('Login/Login').getValue(
        2, 1))

'input password'
WebUI.setText(findTestObject('LoginR3BranchManagerSuperuser/input_Loan Origination System_inputPass'), findTestData('Login/Login').getValue(
        3, 1))

'click button login'
WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/button_LOGIN'))

WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/NewLogin/input_Choose Your Role_Office'))

WebUI.selectOptionByLabel(findTestObject('LoginR3BranchManagerSuperuser/NewLogin/select_Role'),findTestData('Login/Login').getValue(
        4, 1),false)

WebUI.sendKeys(findTestObject('LoginR3BranchManagerSuperuser/NewLogin/select_Role'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/NewLogin/button_Choose Role'))

'click menu finance leasing 4w'
WebUI.click(findTestObject('Object Repository/LoginR3BranchManagerSuperuser/a_FinanceLeasing4W'))

'click menu new finance leasing 4w'
WebUI.click(findTestObject('Object Repository/LoginR3BranchManagerSuperuser/a_NewFinanceLeasing4W'))

'click menu customer main data'
WebUI.click(findTestObject('Object Repository/LoginR3BranchManagerSuperuser/a_CUSTOMERMAINDATAFL4W'))

