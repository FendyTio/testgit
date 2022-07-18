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

int flagWarning = 0
String userDir = System.getProperty('user.dir')

String filePath = userDir + GlobalVariable.Path

GlobalVariable.DataFilePath = filePath

'click menu customer main data'
WebUI.click(findTestObject('Object Repository/LoginR3BranchManagerSuperuser/a_CUSTOMERMAINDATAFL4W'))

'click button add'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Add'))

'click button lookup product offering'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Product Offering Name_btn btn-raised btn-primary'))

'input product offering code'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_ProductOfferingCode'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
        GlobalVariable.NumofColm, 2))

'click button search'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Search'))

'verify input error'
if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'), 10,
    FailureHandling.OPTIONAL)) {
	'click select'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'))
}
else{
	'click X'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabNewApplication/Button_X'))

	'Click Button Cancel'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabNewApplication/Button_Cancel'))

	'Write To Excel FAILED'
	CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData',
		0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusFailed)
	
	'Pengecekan jika new consumer finance belum diexpand'
	if(WebUI.verifyElementNotVisible(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'), FailureHandling.OPTIONAL)){
		
		'Klik new consumer finance'
		WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_New Finance Leasing'))
	}
}

'click button next'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Next'))

'Get Appno'
String appNo = WebUI.getText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/Application No'))

'Write to excel Appno'
CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData', 2, GlobalVariable.NumofColm - 
    1, appNo)

if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
    GlobalVariable.NumofColm, 4) == 'Input Data') {
    'input customer legal name'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Customer Legal Name_form-control ng-untouched ng-pristine ng-valid'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 9))

    'input birth place'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Birth Place_form-control ng-untouched ng-pristine ng-valid'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 10))

    'select id type'
    WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/select_Id Type'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 11), false)

    if (((findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
        GlobalVariable.NumofColm, 11) != 'E-KTP') && (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
        GlobalVariable.NumofColm, 11) != 'NPWP')) && (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
        GlobalVariable.NumofColm, 11) != 'AKTA')) {
        'input expired date'
        WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Id Expired Date_form-control ng-untouched ng-pristine ng-valid ng-star-inserted'), 
            findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
                GlobalVariable.NumofColm, 12))
    }
    
    'select marital status'
    WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/select_MaritalStatus'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 13), false)

    'input mobile phone'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Mobile Phone_form-control ng-untouched ng-pristine ng-valid'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 14))

    'select customer model'
    WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/select_CustomerModel'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 15), false)

    'select gender'
    WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/select_Gender'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 16), false)

    'input birth date'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Birth Date_form-control ng-untouched ng-pristine ng-valid'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 17))

    'input id no'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Id No_form-control ng-untouched ng-pristine ng-valid'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 18))

    'input tax id'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Tax Id No_form-control ng-untouched ng-pristine ng-valid'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 19))

    'input mother maiden name'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Mother Maiden Name_form-control ng-untouched ng-pristine ng-valid'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 20))

    'input email'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Email_form-control ng-untouched ng-pristine ng-valid'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 21))

    'click button department lookup'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_DEPARTMENT AML_btn btn-raised btn-primary'))

    'input department AML code'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Code_MasterCodeId'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 23))

    'click button search'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Search'))

    'verify input error'
	if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'), 10,
		FailureHandling.OPTIONAL)) {
		'click select'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'))
	}
	else{
		'click X'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabNewApplication/Button_X'))
	
		'click button back'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/Button_Back'))
	
		'Write To Excel FAILED'
		CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData',
			0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusFailed)
		'Pengecekan jika new consumer finance belum diexpand'
		if(WebUI.verifyElementNotVisible(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'), FailureHandling.OPTIONAL)){
			
			'Klik new consumer finance'
			WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_New Finance Leasing'))
		}
	}

    if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
        GlobalVariable.NumofColm, 26).length() > 1) {
        'click authority AML Lookup'
        WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Authority AML_btn btn-raised btn-primary'))

        'input authority AML code'
        WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Code_MasterCodeId'), 
            findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
                GlobalVariable.NumofColm, 25))

        'click button search'
        WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Search'))

        'verify input error'
		if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'), 10,
		FailureHandling.OPTIONAL)) {
			'click select'
			WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'))
		}
		else{
			'click X'
			WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabNewApplication/Button_X'))
			'Tambahkan 1 flag ke warning'
			flagWarning++
		}
		
    }
    
    'input address'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/textarea_Address'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 28))

    'input RT'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_RT'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 29))

    'input RW'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_RW'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 30))

    'click button zip code'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Zipcode_btn btn-raised btn-primary'))

    'input Zipcode'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Zipcode_form-control ng-untouched ng-pristine ng-valid'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 31))

    'input kecamatan'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Kecamatan'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 32))

    'input kelurahan'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Kelurahan'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 33))

    'input kota'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Kota'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 34))

    'click button search'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_SearchZipcode'))

    'verify input error'
	if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'), 10,
		FailureHandling.OPTIONAL)) {
		'click select'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'))
	}
	else{
		'click X'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabNewApplication/Button_X'))
	
		'click button back'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/Button_Back'))
	
		'Write To Excel FAILED'
		CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData',
			0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusFailed)
		'Pengecekan jika new consumer finance belum diexpand'
		if(WebUI.verifyElementNotVisible(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'), FailureHandling.OPTIONAL)){
			
			'Klik new consumer finance'
			WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_New Finance Leasing'))
		}
	}

    'select ownership'
    WebUI.selectOptionByValue(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/select_Ownership'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 35), true)

    'click button save'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Save'))

    'verify fail'
    if (WebUI.verifyMatch(WebUI.getText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/ApplicationCurrentStep')), 'CUSTOMER', false, FailureHandling.OPTIONAL)) {
        'click menu Customer main'
        WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'))

        'write to excel \'FAILED\''
        CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData', 
            0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusFailed)
    } else {
        CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData', 
            0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusSuccess)
		if(flagWarning>0){
			CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData',
				0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusWarning)
		}
    }
} else if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
    GlobalVariable.NumofColm, 4) == 'LookUp') {
    'click lookup button customer'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Customer Legal Name_btn btn-raised btn-primary'))

    'input cust id'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Customer No_custNoId'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 6))

    'input custname'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Customer Name_custNameId'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 7))

    'input Id No'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Id No_IdNoId'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
            GlobalVariable.NumofColm, 8))

    'click button search'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Search (1)'))

    'verify input error'
	if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'), 10,
    FailureHandling.OPTIONAL)) {
		'click select'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'))
	}
	else{
		'click X'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabNewApplication/Button_X'))

		'click button back'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/Button_Back'))

		'Write To Excel FAILED'
		CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData',
		0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusFailed)
		
		'Pengecekan jika new consumer finance belum diexpand'
		if(WebUI.verifyElementNotVisible(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'), FailureHandling.OPTIONAL)){
			
			'Klik new consumer finance'
			WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_New Finance Leasing'))
		}
	}
	
	if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
			GlobalVariable.NumofColm, 15).length() > 1){
	'select customer model'
	WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/select_CustomerModel'),
		findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
			GlobalVariable.NumofColm, 15), false)
	}
	
			if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
					GlobalVariable.NumofColm, 24).length() > 1){
			'click button department lookup'
			WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_DEPARTMENT AML_btn btn-raised btn-primary'))
		
			'input department AML code'
			WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Code_MasterCodeId'),
				findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
					GlobalVariable.NumofColm, 23))
		
			'click button search'
			WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Search'))
		
			'verify input error'
			if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'), 10,
				FailureHandling.OPTIONAL)) {
				'click select'
				WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'))
			}
			else{
				'click X'
				WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabNewApplication/Button_X'))
			
				'click button back'
				WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/Button_Back'))
			
				'Write To Excel FAILED'
				CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData',
					0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusFailed)
				'Pengecekan jika new consumer finance belum diexpand'
				if(WebUI.verifyElementNotVisible(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'), FailureHandling.OPTIONAL)){
					
					'Klik new consumer finance'
					WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_New Finance Leasing'))
				}
			}}
		
			if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
				GlobalVariable.NumofColm, 26).length() > 1) {
				'click authority AML Lookup'
				WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Authority AML_btn btn-raised btn-primary'))
		
				'input authority AML code'
				WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/input_Code_MasterCodeId'),
					findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData').getValue(
						GlobalVariable.NumofColm, 25))
		
				'click button search'
				WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Search'))
		
				'verify input error'
				if (WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'), 10,
				FailureHandling.OPTIONAL)) {
					'click select'
					WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/a_Select'))
				}
				else{
					'click X'
					WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabNewApplication/Button_X'))
					'Tambahkan 1 ke flag warning'
					flagWarning++
				}
			}
			
    'click button save'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/TabCustomerData/button_Save'))

    'verify fail'
    if (WebUI.verifyMatch(WebUI.getText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP1-CustomerData/ApplicationCurrentStep')), 'CUSTOMER', false, FailureHandling.OPTIONAL)) {
        'click menu Customer main'
        WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'))

        'write to excel \'FAILED\''
        CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData', 
            0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusFailed)
		
		'Pengecekan jika new consumer finance belum diexpand'
		if(WebUI.verifyElementNotVisible(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'), FailureHandling.OPTIONAL)){
			
			'Klik new consumer finance'
			WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_New Finance Leasing'))
		}
    } else {
		'Write to Excel SUCCESS'
        CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData', 
            0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusSuccess)
		if(flagWarning>0){
			'Write to Excel WARNING'
			CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '1.TabCustomerMainData',
				0, GlobalVariable.NumofColm - 1, GlobalVariable.StatusWarning)
		}
    }
}


