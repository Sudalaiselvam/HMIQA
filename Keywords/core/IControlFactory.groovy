package core



public interface IControlFactory {

	public abstract <T extends BaseControl>T initControl(Class<T> control,String controlName, String pageName, String[] lstArgument);
}