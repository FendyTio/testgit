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

if (WebUI.getText(findTestObject('Object Repository/NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataEmployee - Personal/CustomerModelCode')) ==
	'EMPLOYEE') {
		WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/FamilyPersonal/TabJobDataEmployeeFamily'),
			[:], FailureHandling.CONTINUE_ON_FAILURE)
	} else if (WebUI.getText(findTestObject('Object Repository/NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataEmployee - Personal/CustomerModelCode')) ==
	'PROFESSIONAL') {
		WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/FamilyPersonal/TabJobDataProfessionalFamily'),
			[:], FailureHandling.CONTINUE_ON_FAILURE)
	} else if (WebUI.getText(findTestObject('Object Repository/NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataEmployee - Personal/CustomerModelCode')) ==
	'NON PROFESSIONAL') {
		WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/FamilyPersonal/TabJobDataNonProfessionalFamily'),
			[:], FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		WebUI.callTestCase(findTestCase('NAP-FL4W-CustomerPersonal/NAP-FL4W-PersonalSingle/NAP4 - Customer Data Completion/FamilyPersonal/TabJobDataSMEFamily'),
			[:], FailureHandling.CONTINUE_ON_FAILURE)
	}