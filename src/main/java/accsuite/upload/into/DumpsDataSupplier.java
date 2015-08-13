package accsuite.upload.into;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DumpsDataSupplier {
	private String dumpsPathDescription;
	private static DumpsDataSupplier instance;
	
	private DumpsDataSupplier(String dumpsPath) {
		setDumpsPath(dumpsPath);
	}
	
	
	
	public String getDumpsPath() {
		return dumpsPathDescription;
	}
	public void setDumpsPath(String dumpsPath) {
		this.dumpsPathDescription = dumpsPath;
	}
		
	public static DumpsDataSupplier getInstance(String dumpsPath) {
		if (instance == null) {
			return new DumpsDataSupplier(dumpsPath);
		}
		else {
			return instance;
		}
			
	}
	
	public List<Path> getDumpsList() throws IOException {
		
		Path dumpPath = Paths.get(dumpsPathDescription);
		
		Stream<Path> streamOfFiles = Files.walk(dumpPath, FileVisitOption.FOLLOW_LINKS);
	
		Path[] pathArray = (Path[]) streamOfFiles.toArray();
		
		return Arrays.asList(pathArray);
		
	}
	
	
	
}
