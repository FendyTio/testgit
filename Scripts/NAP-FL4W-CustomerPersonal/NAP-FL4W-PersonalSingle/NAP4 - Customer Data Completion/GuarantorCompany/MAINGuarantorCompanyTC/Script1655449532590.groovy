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

String userDir = System.getProperty('user.dir')

String filePath = userDir + GlobalVariable.DataFileGuarantorCompany

GlobalVariable.DataFilePath = filePath

CustomKeywords.'opencloseExcel.opencloseExcel.Open_File'(GlobalVariable.DataFilePath)



def CountofGuarantor = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/CustomerDetail - Company - Guarantor').getColumnNumbers()

WebUI.delay(10)

for (GlobalVariable.NumofGuarantor = 2; GlobalVariable.NumofGuarantor <= CountofGuarantor; (GlobalVariable.NumofGuarantor)++) {
	if ((findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/CustomerDetail - Company - Guarantor').getValue(
        GlobalVariable.NumofGuarantor, 2) == findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
        GlobalVariable.NumofColm, 3)) && (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/CustomerDetail - Company - Guarantor').getValue(
        GlobalVariable.NumofGuarantor, 3).equalsIgnoreCase(WebUI.getText(findTestObject('Object Repository/NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/CustomerDetail - Personal/CustomerNameDetail'))))){
			if(GlobalVariable.Role=="Data Entry"){
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabCustomerDetail - Company'),
					[:], FailureHandling.CONTINUE_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabAddressInformation - Company'),
					[:], FailureHandling.CONTINUE_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabContactInformation - Company'),
					[:], FailureHandling.CONTINUE_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabFinancialData - Company'),
					[:], FailureHandling.CONTINUE_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabCustomerAsset - Company'),
					[:], FailureHandling.CONTINUE_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabLegalDocument - Company'),
					[:], FailureHandling.CONTINUE_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabOtherAttribute - Company'),
					[:], FailureHandling.CONTINUE_ON_FAILURE)
			}
			else if(GlobalVariable.Role=="Testing"){
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabCustomerDetail - Company'),
					[:], FailureHandling.STOP_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabAddressInformation - Company'),
					[:], FailureHandling.STOP_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabContactInformation - Company'),
					[:], FailureHandling.STOP_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabFinancialData - Company'),
					[:], FailureHandling.STOP_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabCustomerAsset - Company'),
					[:], FailureHandling.STOP_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabLegalDocument - Company'),
					[:], FailureHandling.STOP_ON_FAILURE)
				
				WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/GuarantorCompany/TabOtherAttribute - Company'),
					[:], FailureHandling.STOP_ON_FAILURE)
			}
		
	}
}