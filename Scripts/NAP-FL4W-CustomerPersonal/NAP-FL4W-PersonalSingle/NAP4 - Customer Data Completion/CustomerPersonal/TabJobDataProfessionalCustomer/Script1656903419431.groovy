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

int flagWarning = 0
String userDir = System.getProperty('user.dir')

String filePath = userDir + GlobalVariable.DataFileCustomerPersonal

GlobalVariable.DataFilePath = filePath

'click lookup profesi'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Profession Name_btn btn-raised btn-primary'))

'input kode profesi'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Profession Code_professionCodeId'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 17))

'click button search'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Search'))

'verify input error'
if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/a_Select'),
	10, FailureHandling.OPTIONAL)) {
	'click select'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/a_Select'))
} else {
	'click X'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_X'))

	'click button back'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Back'))

	'write to excel if failed'
	CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '3.JobData', 0, GlobalVariable.NumofColm -
		1, GlobalVariable.StatusFailed)
}

if (WebUI.verifyElementNotChecked(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Is Well Known Company'),
	2, FailureHandling.OPTIONAL)) {
	'check is well known company'
	if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 19) == 'Yes') {
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Is Well Known Company'))
	}
} else if (WebUI.verifyElementChecked(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Is Well Known Company'),
	2)) {
	'check is well known company'
	if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 19) == 'No') {
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Is Well Known Company'))
	}
}

'input nama perusahaan'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Company Name'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 20))

'click button lookup industry type'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Industry Type_btn btn-raised btn-primary'))

'input industry code'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Industry Type Code_industryTypeCodeId'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 21))

'click button search'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Search'))

'verify input error'
if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/a_Select'),
	10, FailureHandling.OPTIONAL)) {
	'click select'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/a_Select'))
} else {
	'click X'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_X'))

	'click button back'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Back'))

	'write to excel if failed'
	CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '3.JobData', 0, GlobalVariable.NumofColm -
		1, GlobalVariable.StatusFailed)
}

'input professional no'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Professional No'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 23), FailureHandling.CONTINUE_ON_FAILURE)

'input start working date'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Start Working Date'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 24))

'input job title'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Job Title Name'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 25))

	
'input address'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/textarea_Address_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 44))

'input RT'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_RT  Job Addres'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 45))

'input RW'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_RW_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 46))

'click search zipcode'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Zipcode_Job Address'))

'input zipcode'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Zip Code_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 47))

'input Kecamatan'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Kecamatan_Job address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 49))

'input kelurahan'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Kelurahan_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 48))

'input kota'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Kota_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 50))

'click search'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Search'))

'verify input error'
if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/a_Select'),
	10, FailureHandling.OPTIONAL)) {
	'click select'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/a_Select'))
} else {
	'click X'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_X'))

	'click button back'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Back'))

	'write to excel if failed'
	CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '3.JobData', 0, GlobalVariable.NumofColm -
		1, GlobalVariable.StatusFailed)
}

'input note'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/textarea_Notes_JobAddress'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 51), FailureHandling.OPTIONAL)

'input phone1 Area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 1_Area_JobAddress'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 52), FailureHandling.OPTIONAL)

'input phone1 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 1_Number_JobAddress'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 53), FailureHandling.OPTIONAL)

'input phone1 Extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 1_Ext_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 54), FailureHandling.OPTIONAL)

'input phone2 area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 2_Area_JobAddress'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 55), FailureHandling.OPTIONAL)

'input phone2 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 2_Number_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 56), FailureHandling.OPTIONAL)

'input phone2 extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 2_Ext_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 57), FailureHandling.OPTIONAL)

'input phone3 area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 3__Area_JobAddress'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 58), FailureHandling.OPTIONAL)

'input phone3 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 3_Number_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 59), FailureHandling.OPTIONAL)

'input phone3 extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 3_Ext_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 60), FailureHandling.OPTIONAL)

'input fax'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Fax_Area_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 61), FailureHandling.OPTIONAL)

'input fax'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Fax_Number_Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 62), FailureHandling.OPTIONAL)

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 63).length()>0){
'select ownership'
WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/select_OwnerShip Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 63), false)
}

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 65).length()>0){
'input Previous Company Name'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Previous Company Name_Previous Job Data'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 65))
}

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 66).length()>0){
'input previous employment date'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Previous Employment Date'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 66))
}

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 68).length()>0){
'input address'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/textarea_Address_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 68))

'input RT'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_RT__Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 69))

'input RW'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_RW_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 70))
if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
	GlobalVariable.NumofColm, 71).length()>0){
'click search zipcode'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Zipcode_Previous Job Address'))

'input zipcode'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_ZipCode _Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 71))

'input Kecamatan'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Kecamatan_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 73))

'input kelurahan'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Kelurahan_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 72))

'input kota'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Kota_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 74))

'click search'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Search'))

'verify input error'
if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/a_Select'),
	10, FailureHandling.OPTIONAL)) {
	'click select'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/a_Select'))
} else {
	'click X'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_X'))
	flagWarning++
}
}
'input note'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/textarea_Note_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 75))

'input phone1 Area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 1_Area_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 76))

'input phone1 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 1_Number_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 77))

'input phone1 Extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 1_Ext__Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 78))

'input phone2 area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 2_Area_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 79))

'input phone2 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 2_Number_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 80))

'input phone2 extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 2_Ext_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 81))

'input phone3 area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 3_Area_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 82))

'input phone3 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 3_Number_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 83))

'input phone3 extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 3_Ext_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 84))

'input fax'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Fax_Area_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 85))

'input fax'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Fax_Number_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 86))

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 87).length()>0){
'select ownership'
WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/select_Select OwnerShip_Previous Job Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 87), false)
}
}

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 89).length()>0){
	
'input other business name'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Other Business Name'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 89))

}
		
if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 90).length()>0){
'input other business type'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Other Business Type'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 90))
}

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 91).length()>0){
'input other business industry type'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Other Business Industry Type'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 91))
}
if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 92).length()>0){
'input other job position'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Other Job Position'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 92))
}
if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 93).length()>0){
'input establishment date'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Establishment Date'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 93))
}

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 95).length()>0){
'input address'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/textarea_Address_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 95))

'input RT'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_RT_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 96))

'input RW'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_RW_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 97))
if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 98).length()>0){
'click search zipcode'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Zipcode_Other Business Address'))

'input zipcode'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Zip Code_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 98))

'input Kecamatan'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Kecamatan_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 100))

'input kelurahan'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Kelurahan_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 99))

'input kota'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Kota_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 101))

'click search'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Search'))

'verify input error'
if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/a_Select'),
	10, FailureHandling.OPTIONAL)) {
	'click select'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/a_Select'))
} else {
	'click X'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_X'))
	flagWarning++
}
}
'input note'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/textarea_Notes_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 102))

'input phone1 Area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 1_Area_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 103))

'input phone1 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 1_Number_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 104))

'input phone1 Extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 1_Ext_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 105))

'input phone2 area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 2_Area_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 106))

'input phone2 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 2_Number_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 107))

'input phone2 extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 2_Ext_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 108))

'input phone3 area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 3_Area_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 109))

'input phone3 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 3_Number_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 110))

'input phone3 extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Phone 3_Ext_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 111))

'input fax'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Fax_Area_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 112))

'input fax'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/input_Fax_Number_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 113))

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 114).length()>0){
'select ownership'
WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/select_Select Ownership_Other Business Address'),
	findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobData - Personal - Customer').getValue(
		GlobalVariable.NumofColm, 114), false)
}
}
		
'Click check ekyc'
WebUI.click(findTestObject('Object Repository/NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataEmployee - Personal/button_Check eKYC'))

'click save and continue button'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Save  Continue'))



if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/label_Profession Name'),
	5, FailureHandling.OPTIONAL)) {
	'click button back'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerPersonal/JobDataProfessional - Personal/button_Back'))

	'write to excel if failed'
	CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '3.JobData', 0, GlobalVariable.NumofColm -
		1, GlobalVariable.StatusFailed)
} else {
	'write to excel if success'
	CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '3.JobData', 0, GlobalVariable.NumofColm -
		1, GlobalVariable.StatusSuccess)
	if(flagWarning>0){
		'write to excel if warning'
		CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '3.JobData', 0, GlobalVariable.NumofColm -
			1, GlobalVariable.StatusWarning)
	}
}

