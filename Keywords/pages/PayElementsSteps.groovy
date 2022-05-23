package pages
import configs.PageLocatorReader as pageName
import core.BaseSteps
import core.ControlFactory

public class PayElementsSteps {


	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static String ddlPayElementType='ddlPayElementType'
	private static String txtPayElementDesc='txtPayElementDesc'
	private static String grdPayElement='grdPayElement'
	private static String btnClear='btnClear'


	//Open Pay Element new tab
	public static void openPayElements_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuPayElementConfig', 'mnuPayElements', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//To Navigate Pay Element Screen
	public static void gotoPayElements() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuPayElements', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayElementType(String strPayElementType) {
		getBaseSteps().selectByVisibleText(ddlPayElementType, strPayElementType, pageName.PayElements)
	}

	public static void selectLastPageSize() {
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setPayElementDesc(String PayElementDesc) {
		getBaseSteps().setTextToControl(txtPayElementDesc, PayElementDesc, pageName.PayElements)
		getBaseSteps().clickEnter()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickClear() {
		getBaseSteps().clickToControl(btnClear, pageName.PayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static List<String> getPayElement(){
		/*//getBaseSteps().setWindowsSize(75)
		 List<String> lstDescription=new ArrayList<String>()
		 lstDescription=getBaseSteps().getColumnTableText('grdPayElement', 'Description', pageName.PayElements)
		 //getBaseSteps().setWindowsSize(100)
		 return lstDescription*/
		return getBaseSteps().getColumnTableText(grdPayElement, 'Description', pageName.PayElements)
	}

	public static List<String> getUniversalPayElements() {
		getBaseSteps().setWindowsSize(75)

		List<String> lstUniversal=new ArrayList<String>()
		lstUniversal=getBaseSteps().getColumnTableActiveandDpdcy('grdPayElement', 'Description','Universal','Frequency','As Requested', pageName.PayElements)


		/*for(int i=0;i<lstUniversal.size();i++) {
		 println lstUniversal.get(i)
		 }*/

		getBaseSteps().setWindowsSize(100)

		return lstUniversal
	}

	public static List<String> getPayElementsFrequencyAsRequested() {
		getBaseSteps().setWindowsSize(75)

		List<String> lstPayElements=new ArrayList<String>()
		lstPayElements=getBaseSteps().getColumnTableDpdcy('grdPayElement', 'Description','Frequency','As Requested', pageName.PayElements)


		getBaseSteps().setWindowsSize(100)

		return lstPayElements
	}

	public static Collection<String> getActivePayElementsWRTNotAutoApproved() {
		getBaseSteps().setWindowsSize(75)

		Set<String> lstPayElements=new HashSet<String>()
		lstPayElements=getBaseSteps().getColumnTableInActive('grdPayElement', 'Description', 'Auto Approved', pageName.PayElements)
		getBaseSteps().setWindowsSize(100)

		return lstPayElements
	}

	public static Collection<String> getActivePayElements() {
		getBaseSteps().setWindowsSize(75)

		Set<String> lstPayElements=new HashSet<String>()
		lstPayElements=getBaseSteps().getColumnTableActiveText('grdPayElement', 'Description', 'Active', pageName.PayElements)
		getBaseSteps().setWindowsSize(100)

		return lstPayElements
	}

	public static Collection<String> getActivePayElement() {
		getBaseSteps().setWindowsSize(75)

		Set<String> lstPayElements=new HashSet<String>()
		lstPayElements=getBaseSteps().getColumnTableActiveText('grdPayElement', 'Description', 'Active', pageName.PayElements)
		getBaseSteps().setWindowsSize(100)

		return lstPayElements
	}

	public static List<String> getAttachmentRequiredPayElements() {

		List<String> lstAttchRePayElements=new ArrayList<String>()
		PayElementsSteps.openPayElements_newTab()
		PayElementsSteps.selectPayElementType('Variable')
		PayElementsSteps.selectLastPageSize()
		getBaseSteps().setWindowsSize(75)
		lstAttchRePayElements=getBaseSteps().getColumnTableActiveandDpdcy('grdPayElement', 'Description','Attachment Required','Frequency','As Requested', pageName.PayElements)
		getBaseSteps().setWindowsSize(100)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)
		return lstAttchRePayElements
	}

	public static List<String> getCommentsRequiredPayElements() {
		getBaseSteps().setWindowsSize(65)

		List<String> lstCmntsPayElements=new ArrayList<String>()
		lstCmntsPayElements=getBaseSteps().getColumnTableActiveandDpdcy('grdPayElement', 'Description','Comments Required','Frequency','As Requested', pageName.PayElements)

		getBaseSteps().setWindowsSize(100)

		return lstCmntsPayElements
	}

	public static Collection<String> getPayElementDescriptionPayrollRefCode_Combination(Collection<String> clnPayElementDescription){

		String Description,PayrollRefCode

		Set<String> DescPRefCode=new HashSet<String>()

		openPayElements_newTab()

		for(int i=0;i<clnPayElementDescription.size();i++) {
			clickClear()
			setPayElementDesc(clnPayElementDescription.getAt(i))
			Description=getBaseSteps().getCellTableText(grdPayElement, 'Description', pageName.PayElements)
			PayrollRefCode=getBaseSteps().getCellTableText(grdPayElement, 'Payroll Ref. Code', pageName.PayElements)
			DescPRefCode.add(Description +' - '+PayrollRefCode)
		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return DescPRefCode
	}

	public static HashMap<String,String> getActivePayElementDescriptionPayrollRefCode_Combination(){

		String Description,PayrollRefCode

		//Set<String> DescPRefCode=new HashSet<String>()

		HashMap<String,String> hmPayElement=new HashMap<String,String>()

		openPayElements_newTab()

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().setWindowsSize(75)
		int NoofRows=Integer.parseInt(getBaseSteps().getRowTableCounts(grdPayElement, pageName.PayElements))

		for(int i=2;i<=NoofRows;i++) {
			Description=getBaseSteps().getCellDataActive(grdPayElement, i.toString(), 'Description', 'Active', pageName.PayElements)
			PayrollRefCode=getBaseSteps().getCellDataActive(grdPayElement, i.toString(),'Payroll Ref. Code','Active', pageName.PayElements)
			//DescPRefCode.add(Description +' - '+PayrollRefCode)
			if(Description!=null)
				hmPayElement.put(Description, Description +' - '+PayrollRefCode)
		}
		/*
		 for(Map.Entry map:hmPayElement.entrySet()) {
		 println (map.getKey()+":"+map.getValue())
		 }
		 */
		getBaseSteps().setWindowsSize(100)

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)

		return hmPayElement
	}


	public static boolean verifyPayElementIsUniversalPayElement(String PayElement) {
		String Description
		boolean blnUniversal=false
		openPayElements_newTab()
		setPayElementDesc(PayElement)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().setWindowsSize(75)
		int NoofRows=Integer.parseInt(getBaseSteps().getRowTableCounts(grdPayElement, pageName.PayElements))
		int i=2
		while(i<=NoofRows){
			Description=getBaseSteps().getCellDataActive(grdPayElement, i.toString(), 'Description', 'Active', pageName.PayElements)
			if(Description.equals(PayElement)) {
				blnUniversal=getBaseSteps().isCellTableCheckBoxActive(grdPayElement, i.toString(), 'Universal', pageName.PayElements)
				break
			}

			i++
		}
		getBaseSteps().setWindowsSize(100)

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)
		return blnUniversal


	}

	public static boolean verifyPayElementIsAutoApproved(String PayElement) {
		String Description
		boolean blnAutoApproved=false
		openPayElements_newTab()
		setPayElementDesc(PayElement)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().setWindowsSize(75)
		int NoofRows=Integer.parseInt(getBaseSteps().getRowTableCounts(grdPayElement, pageName.PayElements))
		int i=2
		while(i<=NoofRows){
			Description=getBaseSteps().getCellDataActive(grdPayElement, i.toString(), 'Description', 'Active', pageName.PayElements)
			if(Description.equals(PayElement)) {
				blnAutoApproved=getBaseSteps().isCellTableCheckBoxActive(grdPayElement, i.toString(), 'Auto Approved', pageName.PayElements)
				break
			}

			i++
		}
		getBaseSteps().setWindowsSize(100)

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		//getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)
		return blnAutoApproved


	}

	public static HashMap<String,String> getPayElementDetails(String PayElement){
		HashMap<String,String> PayElementDetails=new HashMap<>()
		openPayElements_newTab()
		setPayElementDesc(PayElement)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		int NoofRows=Integer.parseInt(getBaseSteps().getRowTableCounts(grdPayElement, pageName.PayElements))
		int i=2
		while(i<=NoofRows){
			String Description=getBaseSteps().getCellDataActive(grdPayElement, i.toString(), 'Description', 'Active', pageName.PayElements)
			if(Description.equals(PayElement)) {
				PayElementDetails.put('Type',getBaseSteps().getCellTableText(grdPayElement, i.toString(), 'Type', pageName.PayElements))
				PayElementDetails.put('AutoApproved',getBaseSteps().isCellTableCheckBoxActive(grdPayElement, i.toString(), 'Auto Approved', pageName.PayElements).toString())
				break
			}
		
			i++	
		}
		
		
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)
		return PayElementDetails
		
		}

	
	
	
	}
