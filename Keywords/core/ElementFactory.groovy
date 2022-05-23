package core

import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.TrueFileFilter

import com.google.api.client.util.Strings

import configs.Path
import utils.PlatformUtil

public class ElementFactory {





	public static String loadObjectRepositoryFile(String controlName, String pageName) {

		if(!Strings.isNullOrEmpty(pageName)&&!Strings.isNullOrEmpty(controlName)){
			try {
				String folderPath = PlatformUtil.getFolderProjectPath(Path.LOCATOR_PATH);
				File folder = new File(folderPath);
				String filePath = loadFilesInAFolder(folder, String.format("%s.properties",pageName.trim()));

				InputStream input = new FileInputStream(filePath);
				Properties prop = new Properties();

				// load a properties file
				prop.load(input);

				// get the property value and return
				return prop.getProperty(controlName);

			} catch(Throwable e){
				throw new HMException(String.format("Page Name is NOT founded: %s", pageName),e);
				return null;
			}
		}else{
			throw new HMException("PageName is null");
		}
	}

	private static String loadFilesInAFolder(File folder, String pageName) {
		String locatorFiles ="";
		try {
			Iterator it = FileUtils.iterateFilesAndDirs(folder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
			while (it.hasNext()) {
				locatorFiles = ((File) it.next()).getCanonicalPath();
				if(locatorFiles.contains(pageName)){
					return locatorFiles;
				}
			}



			//			File[] files = folder.listFiles();
			//			String locatorFiles ="";
			//
			//			for (File file : files) {
			//				if (file.isDirectory()) {
			//					loadFilesInAFolder(file,pageName);
			//				} else {
			//					if (file.getCanonicalPath().contains(pageName)) {
			//						println(file.getCanonicalPath())
			//					}
			//				}
			//			}
		} catch (Throwable e) {
			throw new HMException("PageName is null",e);
		}
	}
}