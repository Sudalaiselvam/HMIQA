import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.GeneralSettingsSteps as GeneralSettingsSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import testDataTypes.ContractCompModel as ContractCompModel
import testDataTypes.ContractCostCenter as ContractCostCenter
import testDataTypes.ContractData as ContractData
import testDataTypes.ContractPayElement as ContractPayElement
import testDataTypes.ContractYear as ContractYear
import testDataTypes.ProviderData as ProviderData
import testDataTypes.ProviderPayRequest as ProviderPayRequest

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

ContractData contractData

ContractCompModel contractCompModel

ContractCostCenter contractCostCenter

ContractPayElement contractPayElement

ContractYear contractYear

contractData = ProviderPayRequestSteps.getProviderContractData(Provider)

for (String currentYear : contractData.CurrentYear) {
    contractYear = contractData.HMContractYear.get(currentYear)

    for (String compModel : contractYear.lstCompModel) {
        contractCompModel = contractYear.HMContractCompModel.get(compModel)

        println(contractCompModel.ContractStatus)

        println(contractCompModel.ContractStartDate)

        println(contractCompModel.ContractEndDate)

        println(contractCompModel.ContractMaxCompensation)

        println(contractCompModel.ContractMaxCompensationDuration)

        for (String costCenter : contractCompModel.lstCostCenters) {
            contractCostCenter = contractCompModel.HMContractCostCenter.get(costCenter)

            for (String payElement : contractCostCenter.lstPayElements) {
                contractPayElement = contractCostCenter.HMContractPayElement.get(payElement)

                if (contractPayElement.PayElementType.equals('Variable')) {
                    println((((payElement.split('-').getAt(0) + '~ ') + contractPayElement.StartDate) + '-') + contractPayElement.EndDate)
                }
            }
        }
    }
}