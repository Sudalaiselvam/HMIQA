import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import pages.HeaderPageSteps as HeaderPageSteps
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderSetupSteps as ProviderSetupSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import configs.HIIConstants as HIIConstants
import testDataTypes.ProviderData as ProviderData
import testDataTypes.ContractData as ContractData
import testDataTypes.ContractYear as ContractYear
import testDataTypes.ContractCompModel as ContractCompModel
import testDataTypes.ContractCostCenter as ContractCostCenter
import testDataTypes.ContractPayElement as ContractPayElement

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

/*
 * ProviderData providerData
 * 
 * providerData = ProviderSetupSteps.getProviderData(Provider)
 * 
 * ProviderSetupSteps.verifyEmployeeStatusforProviderPayRequest(providerData.
 * getEmployeeStatus())
 */
//High 
ContractData contractData

ContractCompModel contractCompModel

ContractCostCenter contractCostCenter

ContractPayElement contractPayElement

ContractYear contractYear

contractData = ManageProviderContractSteps.getContractDetails(Provider)

println('Provider : ' + Provider)

println((('Master Contract Start Date : ' + contractData.getMasterContractStartDate()) + ' , Master Contract End Date: ') + 
    contractData.getMasterContractEndDate())

println(contractData.CurrentYear)

List<String> lstCompModel = new ArrayList<String>()

for (String currentYear : contractData.CurrentYear) {
    println('Year : ' + currentYear)

    contractYear= contractData.HMContractYear.get(currentYear)

    for (String CompModel : contractYear.lstCompModel) {
        println('Comp Model: ' + CompModel)
		contractCompModel=contractYear.HMContractCompModel.get(CompModel)
		println 'Contract Status: '+contractCompModel.ContractStatus
    }
}