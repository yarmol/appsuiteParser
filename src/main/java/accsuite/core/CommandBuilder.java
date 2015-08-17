package accsuite.core;

import accsuite.main.Constants;
import accsuite.main.DumpTypeEnum;
import accsuite.main.Global;

public class CommandBuilder {
	
	public static String getStarterCommand(String baseName,String basePath, CommandRun command) {
		String binPath 		 	 = Global.getAccSuiteBinPath();
		String createParam  	 = Constants.CREATE_BASE.replace("%BaseName%", baseName);
		String connectionParam   = Constants.DB_CONNECTION.replace("%BasePath%", basePath);
		String processParam		 = command.getCommand();
		String toRun 			 = binPath + " " + createParam + " " + connectionParam + " " + processParam;
		
		return toRun;
	}

	public static CommandRun createCommand(FileDirectoryDescriptor keyFile) {
		CommandRun result = null;
		if (keyFile.isFile) {
			FileDescriptor keyFileDescriptor = (FileDescriptor)keyFile;
				Global.println("Setting new file " + keyFile.toString());
				result = new CommandRun(keyFileDescriptor.getType(),keyFileDescriptor); 
			}
		else {
			//create command for directory 
			
		}
			
		
		
		return result;
	}

}
