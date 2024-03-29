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

'input name'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Name_'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(
        GlobalVariable.NumofColm, 3))

'input job title'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Job Title_'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 4))

if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 5).length() > 2) {
    'select id type'
    WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/select_Id Type'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 5), false)

    'input id no'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Id No_'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 6))
}

if (((findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 5) != 'E-KTP') && (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(
    GlobalVariable.NumofColm, 5) != 'AKTA')) && (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 
    5) != 'NPWP')) {
    'input idexpired date'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Id Expired Date'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 7))
}

'input mobile phone 1'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Mobile Phone 1_'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 8))

'input email1'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Email 1_'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 9))

'select gender'
WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/select_Select One Female  Male'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 10), false)

'select job position'
WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/select_Select Job Position'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 11), false)

'input birth place'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Birth Place_'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 12))

'input birth date'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Birth Date_'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 13))

if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 14).length() > 2) {
    'select relation'
    WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/select_Relation'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 14), false)
}

'input mobile 2'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Mobile Phone 2'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 15))

'input email 2'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Email 2_'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 16))

'input address'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/textarea_Address_'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 18))

'input RT'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_RT'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 19))

'input RW'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_RW'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 20))

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 21).length()>0){
	'click button zipcode'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/button_Zipcode_btn btn-raised btn-primary'))
	
	'input Zipcode'
	WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Zip Code_ZipCode'),
		findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 21))
	
	'input kecamatan'
	WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Kecamatan_kecamatan'),
		findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 23))
	
	'input kelurahan'
	WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Kelurahan_Kelurahan'),
		findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 22))
	
	'input kota'
	WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Kota_kota'),
		findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 24))
	
	'click search'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/button_Search'))
	
	'verify input error'
	if(WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/a_Select'),10,FailureHandling.OPTIONAL)){
		
		'click select'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/a_Select'))
	}
	else{
		'click X'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/Button_X'))
	}
}

'input phone 1 area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Phone 1_Area'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 25))

'input phone 1 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Phone 1_Number'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 26))

'input phone 1 extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Phone 1_Ext'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 27))

'input phone 2 area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Phone 2_Area'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 28))

'input phone 2 number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Phone 2_Number'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 29))

'input phone 2 extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Phone 2_Ext'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 30))

'input fax'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Fax_Area'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 31))

'input fax number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/input_Fax_Number'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company - Guarantor').getValue(GlobalVariable.NumofColm, 32))

'click button save and continue'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/button_Save  Continue'))

if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/ContactInformation - Company/label_Name'),10,
	FailureHandling.OPTIONAL)) {
	'click button back'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/button_Back'))
	
	'write to excel if failed'
	CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '3.ContactInformation', 0, GlobalVariable.NumofColm -
		1, GlobalVariable.StatusFailed)
}else{
	
'write to excel if success'
CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '3.ContactInformation', 0, GlobalVariable.NumofColm -
	1, GlobalVariable.StatusSuccess)
}