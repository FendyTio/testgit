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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

if(WebUI.verifyElementNotVisible(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/a_CUSTOMER DATA COMPLETION'),FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/a_New Consumer Finance'))
}
//

'click menu Customer Data Completion'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/a_CUSTOMER DATA COMPLETION'))

'input Appno'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/input_Application No_AppNoId'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion').getValue(
        GlobalVariable.NumofColm, 2))

'click search'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/button_Search'))

'click action'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/i_CF4W 2021_font-medium-3 ft-edit-2'))

WebDriver driver = DriverFactory.getWebDriver()

ArrayList<WebElement> variable = driver.findElements(By.cssSelector('body > app-root > app-full-layout > div > div.main-panel > div > div > div > div > app-cust-completion-detail > div > div > div > div.px-3 > lib-ucgridview > div > table > tbody tr'))

int count = variable.size()

for (int i = 1; i <= count; i++) {
    String newCustomerName = ('//*[@class="table-responsive"]/table/tbody/tr[' + i + ']/td[2]')

    'modify object customername'
    modifynewCustomerName = WebUI.modifyObjectProperty(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/AddressInformation - Personal/CustomerName'), 
        'xpath', 'equals', newCustomerName, true)

    String newCustomerType = ('//*[@class="table-responsive"]/table/tbody/tr[' + i + ']/td[3]')

    'modify object customertype'
    modifynewCustomerType = WebUI.modifyObjectProperty(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/AddressInformation - Personal/CustomerType'), 
        'xpath', 'equals', newCustomerType, true)

    String newisComplete = ('//*[@class="table-responsive"]/table/tbody/tr[' + i + ']/td[7]')

    'modify object iscomplete'
    modifynewisComplete = WebUI.modifyObjectProperty(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/td_isComplete'), 
        'xpath', 'equals', newisComplete, true)

    String newButtonAction = ('//*[@class="table-responsive"]/table/tbody/tr[' + i + ']/td[8]')
	
    'modify object button action'
    modifynewButtonAction = WebUI.modifyObjectProperty(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/buttonAction'), 
        'xpath', 'equals', newButtonAction, true)

    'get text customer name'
    String CustomerName = WebUI.getText(modifynewCustomerName)

    'get text iscomplete'
    String isComplete = WebUI.getText(modifynewisComplete)

    'get text customertype'
    String CustomerType = WebUI.getText(modifynewCustomerType)

	println(CustomerName)
    'tampung customer array excel'
    def CustomerArray = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion').getValue(
        GlobalVariable.NumofColm, 3).split(';')

    'tampung family array excel'
    def FamilyArray = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion').getValue(
        GlobalVariable.NumofColm, 5).split(';')

    'tampung guarantor array excel'
    def GuarantorArray = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion').getValue(
        GlobalVariable.NumofColm, 7).split(';')

    'verify customerarray > 0'
    if (CustomerArray.size() > 0) {
        'looping customer array'
        for (c = 1; c <= CustomerArray.size(); c++) {
            'verify if iscomplete == no'
            if (isComplete == 'NO') {
                'verify if customerarray == customename'
                if (CustomerName.equalsIgnoreCase((CustomerArray[(c - 1)]))) {
                    'click button action'
                    WebUI.click(modifynewButtonAction)

                    'call test case customer personal'
                    WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/CustomerPersonal/MAINCustomerPersonalTC'), 
                        [:], FailureHandling.CONTINUE_ON_FAILURE)
                }
            } else if (isComplete == 'YES') {
                if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion').getValue(
                    GlobalVariable.NumofColm, 4) == 'YES') {
                    'verify if customerarray == customename'
                    if (CustomerName.equalsIgnoreCase((CustomerArray[(c - 1)]))) {
                        'click button action'
                        WebUI.click(modifynewButtonAction)

                        'call test case customer personal'
                        WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/CustomerPersonal/MAINCustomerPersonalTC'), 
                            [:], FailureHandling.CONTINUE_ON_FAILURE)
                    }
                }
            }
        }
    }
    
    'verify if family array > 0'
    if (FamilyArray.size() > 0) {
        'looping family array'
        for (f = 1; f <= FamilyArray.size(); f++) {
            'verify iscomplete == NO'
            if (isComplete == 'NO') {
                'verify customername == family array'
                if (CustomerName.equalsIgnoreCase((FamilyArray[(f - 1)]))) {
                    'click button action'
                    WebUI.click(modifynewButtonAction)

                    'call test case customer personal (Family)'
                    WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/FamilyPersonal/MAINFamilyPersonalTC'), 
                        [:], FailureHandling.CONTINUE_ON_FAILURE)
                }
            } else if (isComplete == 'YES') {
                if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion').getValue(
                    GlobalVariable.NumofColm, 6) == 'YES') {
                    'verify customername == family array'
                    if (CustomerName.equalsIgnoreCase((FamilyArray[(f - 1)]))) {
                        'click button action'
                        WebUI.click(modifynewButtonAction)

                        'call test case customer personal (Family)'
                        WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/FamilyPersonal/MAINFamilyPersonalTC'), 
                            [:], FailureHandling.CONTINUE_ON_FAILURE)
                    }
                }
            }
        }
    }
    
    'verify gurantor array > 0'
    if (GuarantorArray.size() > 0) {
        'looping guarantor array'
        for (g = 1; g <= GuarantorArray.size(); g++) {
            'verify iscomplete == NO'
            if (isComplete == 'NO') {
                'verify customername == guarantorarray'
                if ((CustomerName.equalsIgnoreCase((GuarantorArray[(g - 1)]))) && (CustomerType == 'PERSONAL')) {
                    'click button action'
                    WebUI.click(modifynewButtonAction)

                    WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorPersonal/MAINGuarantorPersonalTC'), 
                        [:], FailureHandling.CONTINUE_ON_FAILURE)
                } else if ((CustomerName.equalsIgnoreCase((GuarantorArray[(g - 1)]))) && (CustomerType == 'COMPANY')) {
                    'click button action'
                    WebUI.click(modifynewButtonAction)

                    'call test case guarantor company'
                    WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/MAINGuarantorCompanyTC'), 
                        [:], FailureHandling.CONTINUE_ON_FAILURE)
                }
            } else if (isComplete == 'YES') {
                if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion').getValue(
                    GlobalVariable.NumofColm, 8) == 'YES') {
                    'verify customername == guarantorarray'
                    if ((CustomerName.equalsIgnoreCase((GuarantorArray[(g - 1)]))) && (CustomerType == 'PERSONAL')) {
                        WebUI.click(modifynewButtonAction)

                        WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorPersonal/MAINGuarantorPersonalTC'), 
                            [:], FailureHandling.CONTINUE_ON_FAILURE)
                    } else if ((CustomerName.equalsIgnoreCase((GuarantorArray[(g - 1)]))) && (CustomerType == 'COMPANY')) {
                        WebUI.click(modifynewButtonAction)

                        WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/MAINGuarantorCompanyTC'), 
                            [:], FailureHandling.CONTINUE_ON_FAILURE)
                    }
                }
            }
        }
    }
}

'click button submit'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/button_Submit'))

String userDir = System.getProperty('user.dir')

String filePath = userDir + GlobalVariable.Path

GlobalVariable.DataFilePath = filePath

if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/button_Back'),5, 
    FailureHandling.OPTIONAL)) {
    'click button back'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/button_Back'))

    'write to excel if failed'
    CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '15.CustomerDataCompletion', 
        0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusFailed)
} else {
    'write to excel if success'
    CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '15.CustomerDataCompletion', 
        0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusSuccess)
}

