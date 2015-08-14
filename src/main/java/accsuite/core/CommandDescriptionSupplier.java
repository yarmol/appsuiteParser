
package accsuite.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class CommandDescriptionSupplier {
	private List<Path> dt_cf_list;
	
	private Map<FileDirectoryDescriptor,CommandRun> fileCommandMapping = new TreeMap<>();

	public CommandDescriptionSupplier(List<Path> listOfFiles) {
		setDt_cf_list(listOfFiles);
	}

	public void analize() throws IOException {
		FileDirectoryDescriptor file = null;
		for (Path filePath : dt_cf_list) {
			//File currentFile = new File(filePath.toAbsolutePath().toString());
			//if (currentFile.exists()) {
				if (currentFile.isFile()) { 
					file = new FileDescriptor(filePath.toAbsolutePath());
				}
				else {
					file = new DirectoryDescriptor(filePath.toAbsolutePath());
				}
			
				
				fileCommandMapping.put(file, "");
			//}
			
		}
		
	}

	public void buildCommands() {
		
		for (FileDirectoryDescriptor keyFile : fileCommandMapping.keySet()) {
			
			CommandRun commandToRun = CommandBuilder.createCommand(keyFile);
		
			fileCommandMapping.put(keyFile, commandToRun);
		
		}
		
		
	}

	public Map<FileDescriptor, String> getMap() {
		
		return fileCommandMapping;
	}

	public List<Path> getDt_cf_list() {
		return dt_cf_list;
	}

	public void setDt_cf_list(List<Path> dt_cf_list) {
		this.dt_cf_list = dt_cf_list;
	}
	
	

}
