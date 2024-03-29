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

'Assign directori file excel ke global variabel'
String userDir = System.getProperty('user.dir')

'Assign directori file excel ke global variabel'
String filePath = userDir + GlobalVariable.Path

'Assign directori file excel ke global variabel'
GlobalVariable.DataFilePath = filePath


if(WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_MOOfficer'),10, FailureHandling.OPTIONAL)){
	'Click Lookup Officer'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_MOOfficer'))
	'Input MO Code'
	WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_MO Code'),
		findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
			GlobalVariable.NumofColm, 3))
	
	'Input MO Office Name'
	WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_MOOfficeName'),
		findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
			GlobalVariable.NumofColm, 5))
	
	'Click Search'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Search'))
	
	'verify input error'
	if(WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/a_Select'),10,FailureHandling.OPTIONAL)){
		'Click Select'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/a_Select'),
			FailureHandling.OPTIONAL)
	}
	else{
		'click X'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/Button_X'))
	
		'click cancel'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Cancel'))
	
		'write to excel failed'
		CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '6.TabApplicationData', 0, GlobalVariable.NumofColm -
			1, GlobalVariable.StatusFailed)
		
		'Pengecekan jika new consumer finance belum diexpand'
		if(WebUI.verifyElementNotVisible(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'), FailureHandling.OPTIONAL)){
			
			'Klik new consumer finance'
			WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_New Finance Leasing'))
		}
	}
	
}

'Input MO Notes'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/textarea_MONotes'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 6))

'Select option dropdownlist App Source'
WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_ApplicationSource'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 8), false, FailureHandling.OPTIONAL)

'Select option dropdownlist First Installment Type'
WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_FirstInstallmentType'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 9), false)

'Inisialisasi Variabel'
String payFreq = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
    GlobalVariable.NumofColm, 10)

'Select option dropdownlist Payment Frequency'
WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_PaymentFrequency'), 
    payFreq, false)

'Inisialisasi Variabel'
String tenorString = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
    GlobalVariable.NumofColm, 11)
println(tenorString)
'Input tenor'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Tenor'), 
    tenorString)
'Inisialisasi Variabel'
int numOfInstallment

if(tenorString!=""){
	'Inisialisasi Variabel'
	double tenor = Double.parseDouble(tenorString)
	'Verify numofinstallment berdasarkan tenor dan payment Frequency'
	if (payFreq == 'Monthly') {
		numOfInstallment = ((Math.ceil(tenor / 1)) as int)
	} else if (payFreq == 'Bimonthly') {
		numOfInstallment = ((Math.ceil(tenor / 2)) as int)
	} else if (payFreq == 'Quarterly') {
		numOfInstallment = ((Math.ceil(tenor / 3)) as int)
	} else if (payFreq == 'Trimester') {
		numOfInstallment = ((Math.ceil(tenor / 4)) as int)
	} else if (payFreq == 'Semi Annually') {
		numOfInstallment = ((Math.ceil(tenor / 6)) as int)
	} else if (payFreq == 'Annually') {
		numOfInstallment = ((Math.ceil(tenor / 12)) as int)
	} else {
		numOfInstallment = (((((4) as int) * tenor)) + (Math.round(tenor - 1) / 3)+1)
	}
}


'Click label numofInstallment untuk merefresh numofinstallment'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/label_NumOfInstallment'))

'Verify numofinstallment sesuai perhitungan'
WebUI.verifyElementText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/label_NumOfInstallment'), 
    numOfInstallment.toString())

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 12).length()>0){
	'Select option dropdownlist DPSourcePaymentType'
	WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_DPSourcePaymentType'),
		findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
			GlobalVariable.NumofColm, 12), false)
}


String textInterestType = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
    GlobalVariable.NumofColm, 13)

'Verify Jika ada dropdown list interest type'
if(WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_InterestType'),5,FailureHandling.OPTIONAL)){
	'Select option dropdownlist Interest Type'
	WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_InterestType'),
		textInterestType, false)
}


scheme = findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_InstallmentScheme')

wop = findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_WayOfPayment')

notif = findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_CustomerNotification')

inssource = findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_InstallmentSourcePaymentType')

'Verify/Jika Interest Type = Float Rate'
if (textInterestType == 'Float Rate' && WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_FloatingPeriod'),5,FailureHandling.OPTIONAL)) {
    'Select option dropdownlist Floating Period'
    WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_FloatingPeriod'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 14), false, FailureHandling.OPTIONAL)
}

'Select option dropdownlist installment scheme'
WebUI.selectOptionByLabel(scheme, findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 15), false)

textwop = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
    GlobalVariable.NumofColm, 16)

'Select option dropdownlist Way of Payment'
WebUI.selectOptionByLabel(wop, textwop, false)

'Verify/Jika Way of Payment = Auto Debit'
if (textwop == 'Auto Debit') {
    bankacc = findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_CustomerBankAccount')
	
    'Select option dropdownlist Customer Bank Account'
    WebUI.selectOptionByIndex(bankacc, findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 17), FailureHandling.OPTIONAL)
}

'Select option dropdownlist Customer Notification By'
WebUI.selectOptionByLabel(notif, findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 18), false)

if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 19).length()>0){
	'Select option dropdownlist Installment Source Payment'
	WebUI.selectOptionByLabel(inssource, findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
			GlobalVariable.NumofColm, 19), false)
}


'Pengecekan jika MOU Customer terisi atau tidak pada excel'
if(findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 20).length()>0){
	'Select option dropdownlist MOU Customer'
	WebUI.selectOptionByLabel(findTestObject('Object Repository/NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_MOUCustomer'),
		findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
			GlobalVariable.NumofColm, 20), false, FailureHandling.OPTIONAL)
}
		


'Jika/Verify Copy Address From ada isi/tidak kosong pada excel'
if (findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
    GlobalVariable.NumofColm, 22).length() > 1) {
    'Select option dropdownlist Copy Address From '
    WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_CopyAddressFrom'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 22), false)

    'Click copy'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Copy'))
} else {
    'Input Address'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/textarea_Address'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 23))

    'Input RT'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_RT'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 24))

    'Input RW'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_RW'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 25))

    'Click Lookup Zipcode'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Zipcode'))

    'Input Zipcode'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_ZipCodeLookup'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 26))

    'Input Kelurahan'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Kelurahan_Kelurahan'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 27))

    'Input Kecamatan'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Kecamatan_kecamatan'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 28))

    'Input Kota'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Kota_kota'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 29))

    'Click search'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Search'))

    'verify input error'
	if(WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/a_Select'),10,FailureHandling.OPTIONAL)){
		'Click Select'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/a_Select'),
			FailureHandling.OPTIONAL)
	}
	else{
		'click X'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/Button_X'))
	
		'click cancel'
		WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Cancel'))
	
		'write to excel failed'
		CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '6.TabApplicationData', 0, GlobalVariable.NumofColm -
			1, GlobalVariable.StatusFailed)
		'Pengecekan jika new consumer finance belum diexpand'
		if(WebUI.verifyElementNotVisible(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'), FailureHandling.OPTIONAL)){
			
			'Klik new consumer finance'
			WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_New Finance Leasing'))
		}
	}
}

'Input Phone 1 Area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Phone 1 area'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 30))

'Input Phone 1 Number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Phone 1 number'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 31))

'Input Phone 1 Extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Phone 1 extension'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 32))

'Input Phone 2 Area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Phone 2 area'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 33))

'Input Phone 2 Number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Phone 2 number'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 34))

'Input Phone 2 Extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Phone 2 extension'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 35))

'Input Phone 3 Area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Phone 3 area'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 36))

'Input Phone 3 Number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Phone 3 number'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 37))

'Input Phone 3 Extension'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Phone 3 extension'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 38))

'Input Fax Area'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Fax area'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 39))

'Input Fax Number'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Fax number'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 40))

String coc = findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
    GlobalVariable.NumofColm, 42)

slikbtn = findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Economic Sector (Slik)')

'Select option dropdownlist characteristic of credit'
WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_CharacteristicOfCredit'), 
    coc, false)

'Verify/Jika coc selain lainnya'
if (coc != 'Lainnya') {
    'Input prev agreement no'
    WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_PrevAgreementNo'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 43))

    'Select option dropdownlist way of restructure '
    WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_WayOfRestructure'), 
        findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
            GlobalVariable.NumofColm, 44), false)
}

'Click lookup slik'
WebUI.click(slikbtn)

'Input Economic Sector Code'
WebUI.setText(findTestObject('Object Repository/NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_Economic Sector Code'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 45))

'Click Search'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Search'))

'verify input error'
if(WebUI.verifyElementPresent(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/a_Select'),10,FailureHandling.OPTIONAL)){
	'Click Select'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/a_Select'),
		FailureHandling.OPTIONAL)
}
else{
	'click X'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/Button_X'))

	'click cancel'
	WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Cancel'))

	'write to excel failed'
	CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '6.TabApplicationData', 0, GlobalVariable.NumofColm -
		1, GlobalVariable.StatusFailed)
	'Pengecekan jika new consumer finance belum diexpand'
	if(WebUI.verifyElementNotVisible(findTestObject('LoginR3BranchManagerSuperuser/a_CUSTOMER MAIN DATA'), FailureHandling.OPTIONAL)){
		
		'Klik new consumer finance'
		WebUI.click(findTestObject('LoginR3BranchManagerSuperuser/a_New Finance Leasing'))
	}
}

'Select option dropdownlist Blacklist APPI'
WebUI.selectOptionByLabel(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/select_BlackListAppi'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 48), false)

'Input APPI Score'
WebUI.setText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/input_APPI SCORE'), 
    findTestData('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData').getValue(
        GlobalVariable.NumofColm, 49))


WebUI.delay(3)

'click Save'
WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Save'))

WebUI.delay(5)

'Verify input data'
if (WebUI.verifyMatch(WebUI.getText(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/ApplicationCurrentStep')), 'APPLICATION DATA', false, FailureHandling.OPTIONAL)) {
    'click cancel'
    WebUI.click(findTestObject('NAP-FL4W-CustomerPersonal/NAP-FL4W-CustomerPersonalSingle/NAP2-ApplicationData/TabApplicationData/button_Cancel'))

    'write to excel failed'
    CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '6.TabApplicationData', 0, GlobalVariable.NumofColm - 
        1, GlobalVariable.StatusFailed)
} else {
    'write to excel success'
    CustomKeywords.'writetoexcel.writeToExcel.writeToExcelFunction'(GlobalVariable.DataFilePath, '6.TabApplicationData', 0, 
        GlobalVariable.NumofColm - 1, GlobalVariable.StatusSuccess)
}