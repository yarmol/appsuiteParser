package accsuite.upload.into;

import accsuite.main.DumpTypeEnum;
import accsuite.parser.Constants;

public class CommandBuilder {

	public static String createCommand(FileDescriptor keyFile) {
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
