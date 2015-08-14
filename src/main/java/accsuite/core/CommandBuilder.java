package accsuite.core;

import accsuite.main.Constants;
import accsuite.main.DumpTypeEnum;

public class CommandBuilder {

	public static CommandRun createCommand(FileDirectoryDescriptor keyFile) {
		String result = "";
		if (keyFile.getType() == DumpTypeEnum.CF ) {
			result = Constants.CF_UPLOAD.replace("%File%", keyFile.getPath().toString());
		}
		
		else if (keyFile.getType() == DumpTypeEnum.DT ) {
			result = Constants.DT_UPLOAD.replace("%File%", keyFile.getPath().toString());
		}
			
		
		
		return result;
	}

}
