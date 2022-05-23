package core

public class HMException extends Exception {
	public HMException(){}

	//	public HMException(String message){
	//		super(message);
	//		Logger.logERROR(message);
	//	}
	//
	//	public HMException(String message, Exception e){
	//		super(message,e);
	//		Logger.logERROR(String.format("%s - %s",message,e.getMessage()));
	//	}

	public HMException(String message,  Throwable e){
		super(message,e);
		Logger.logERROR(String.format("%s - %s",message,e.getMessage()));
		Browser.takeScreenshot();
	}
}
