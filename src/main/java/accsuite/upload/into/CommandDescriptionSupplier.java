
package accsuite.upload.into;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class CommandDescriptionSupplier {
	private List<Path> dt_cf_list;
	private Map<FileDescriptor,String> fileCommandMapping = new TreeMap<>();

	public CommandDescriptionSupplier(List<Path> listOfFiles) {
		setDt_cf_list(listOfFiles);
	}

	public void analize() throws IOException {
		for (Path filePath : dt_cf_list) {
			FileDescriptor file = new FileDescriptor(filePath.toAbsolutePath()); 
			if (file.getType() != null) {
				fileCommandMapping.put(file, "");
			}
			
		}
		
	}

	public void buildCommands() {
		
		for (FileDescriptor keyFile : fileCommandMapping.keySet()) {
			String commandToRun = CommandBuilder.createCommand(keyFile);
		
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
