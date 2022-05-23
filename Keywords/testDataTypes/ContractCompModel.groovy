package testDataTypes
public class ContractCompModel {

	public String CompModel
	public String ContractStatus
	public String ContractStartDate
	public String ContractEndDate
	public String ContractMaxCompensation
	public String ContractMaxCompensationDuration
	public String CostCenter
	public int noofCostCenters
	public String Region
	public String Location
	public List<String> lstCostCenters=new ArrayList<String>();

	public HashMap<String,ContractCostCenter> HMContractCostCenter
}
