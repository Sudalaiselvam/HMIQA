package utils

import com.kms.katalon.core.configuration.RunConfiguration

public class PlatformUtil {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static String getFolderProjectPath(String folderName){

		if(isMac()) {
			return "${RunConfiguration.getProjectDir()}/".concat(folderName);
		}
		if(isWindows()) {
			return "${RunConfiguration.getProjectDir()}/".concat(folderName).replace('/', '\\')
		}
	}

	public static String getDownloadFolderProjectPath(String folderName){

		if(isMac()) {
			return "${RunConfiguration.getProjectDir()}/ExportedFiles/".concat(folderName);
		}
		if(isWindows()) {
			return "${RunConfiguration.getProjectDir()}/ExportedFiles/".concat(folderName).replace('/', '\\')
		}
	}

	public static String getFileProjectPath(String fileName){
		return getFolderProjectPath(fileName);
	}

	public static String getDownloadedFileProjectPath(String fileName){
		return getDownloadFolderProjectPath(fileName);
	}
}
