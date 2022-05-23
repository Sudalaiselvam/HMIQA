package core

import org.openqa.selenium.By

import utils.Utilities



public class ControlFactory implements IControlFactory{

	@Override
	public <T extends BaseControl>T initControl(Class<T> control,String controlName, String pageName, String[] lstArgument=null){
		try{
			By by = By.xpath(ElementFactory.loadObjectRepositoryFile(controlName, pageName));
			by = lstArgument!=null?Utilities.mapArgumentToSelector(by,lstArgument):by;
			return control.newInstance(by);
		}catch(Throwable e){
			throw new HMException(String.format("Cannot find control %s on page %s",controlName, pageName),e);
		}
	}
}