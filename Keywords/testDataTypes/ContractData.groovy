package testDataTypes

public class ContractData {


	private String MasterContractStartDate;
	private String MasterContractEndDate;
	private String TerminationDate;
	
	public List<String> CurrentYear=new ArrayList<String>();
	public int noofCompModels
	public List<String> lstCompModel=new ArrayList<String>();

	public HashMap<String,List<String>> hmYearCModel=new HashMap<String,List<String>>();
	public HashMap<String,ContractYear> HMContractYear

	public HashMap<String, ContractCompModel> HMContractCompModel

	ContractData() {}

	public setMasterContractStartDate(String MasterContractStartDate) {
		this.MasterContractStartDate=MasterContractStartDate
	}

	public String getMasterContractStartDate() {
		return MasterContractStartDate
	}

	public setMasterContractEndDate(String MasterContractEndDate) {
		this.MasterContractEndDate=MasterContractEndDate
	}

	public String getMasterContractEndDate() {
		return MasterContractEndDate
	}

	public setTerminationDate(String TerminationDate) {
		this.TerminationDate=TerminationDate
	}

	public String getTerminationDate() {
		return TerminationDate
	}

	public setCompModels(List<String> lstCompModel) {
		this.lstCompModel=lstCompModel
	}

	public List<String> getCompModels(){
		return lstCompModel
	}
}
