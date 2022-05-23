import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.GeneralSettingsSteps
import pages.LocationPageSteps
import pages.ProviderSetupSteps
import configs.HIIConstants

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Get Provider Display Encrypted Data Flag Setting'
String flgDisplayEncryptedData
flgDisplayEncryptedData=GeneralSettingsSteps.getDisplayEncryptedDataFlagSetting()

'Step 03 : Navigate to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Search For the Provider'
ProviderSetupSteps.setProviderSearch(ProviderSearch)

'Step 05 : Edit Provider'
ProviderSetupSteps.editProvider()

'Step 06 : Verify default Encrypted Provider details'
ProviderSetupSteps.verifyEncryptedFields(flgDisplayEncryptedData)

