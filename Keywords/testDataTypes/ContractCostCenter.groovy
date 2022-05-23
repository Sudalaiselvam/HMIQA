package testDataTypes

public class ContractCostCenter {
	public String CostCenter
	public String CostCenterRegion
	public String CostCenterLocation
	public String AllowPEoutsideCD
	public String CompModel
	public int noofPayElements
	public List<String> lstPayElements=new ArrayList<String>();
	public HashMap<String,ContractPayElement> HMContractPayElement
}
