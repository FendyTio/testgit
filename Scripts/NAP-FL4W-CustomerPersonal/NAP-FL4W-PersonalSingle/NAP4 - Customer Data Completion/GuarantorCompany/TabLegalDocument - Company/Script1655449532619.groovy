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

	
	def LegalDocTypeArray = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
            GlobalVariable.NumofColm, 2).split(';')
			
	def DocumentNoArray = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
            GlobalVariable.NumofColm, 3).split(';')
			
	def DateIssuedArray = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
            GlobalVariable.NumofColm, 4).split(';')
			
	def ExpiredDateArray = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
            GlobalVariable.NumofColm, 5).split(';')
			
	def NotaryNameArray = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
            GlobalVariable.NumofColm, 6).split(';')
			
	def NotaryLocationArray = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
            GlobalVariable.NumofColm, 7).split(';')
			
	def NotesArray = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
            GlobalVariable.NumofColm, 8).split(';')
			
	if (LegalDocTypeArray.size() > 0) {
	for(i = 1; i <= LegalDocTypeArray.size(); i++){
		
	
    'click button add'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/button_Add'))

    'select legal doc type'
    WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/select_NIP  SIUP  TDP'), 
        LegalDocTypeArray[i - 1], false)

    'input doc no'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/input_Document No'), 
        DocumentNoArray[i - 1])

	
	
    'input date issued'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/input_Issued Date'), 
        DateIssuedArray[i - 1])

	
	
	if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
            GlobalVariable.NumofColm, 5).length() >0){
		
    'input expired date'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/input_Expired Date'), 
    		ExpiredDateArray[i - 1])
	}
	
    if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
    		GlobalVariable.NumofColm, 6).length() > 0){
    	
    	'input notary name'
    	WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/input_Notary Name'), 
    			NotaryNameArray[i - 1])
    }
			
	if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
            GlobalVariable.NumofColm, 7).length()>0){
		
    'input notary location'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/input_Notary Location'), 
        NotaryLocationArray[i - 1])
	}
		
	if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company - Guarantor').getValue(
            GlobalVariable.NumofColm, 8).length() >0){
		
    'input Notes'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/textarea_Notes'), 
        NotesArray[i - 1])

	}
    'click button save'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/button_Save'))
}
	}

'click button save and continue'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/button_Save  Continue'))

if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/GuarantorCompany/LegalDocument - Company/th_Expired Date'),10,
	FailureHandling.OPTIONAL)) {
	'click button back'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP4-CustomerDataCompletion/CustomerDataCompletion/button_Back'))
	
	'write to excel if failed'
	CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '6.LegalDocument', 0, GlobalVariable.NumofColm -
		1, GlobalVariable.StatusFailed)
}else{
	
'write to excel if success'
CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '6.LegalDocument', 0, GlobalVariable.NumofColm -
	1, GlobalVariable.StatusSuccess)
}