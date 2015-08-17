package accsuite.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import accsuite.main.Global;

public class FileDirectoryInspector {
	private String dumpsPathDescription;
	private static FileDirectoryInspector instance;
	
	private FileDirectoryInspector(String dumpsPath) {
		setDumpsPath(dumpsPath);
	}
	
	
	
	public String getDumpsPath() {
		return dumpsPathDescription;
	}
	public void setDumpsPath(String dumpsPath) {
		this.dumpsPathDescription = dumpsPath;
	}
		
	public static FileDirectoryInspector getInstance(String dumpsPath) {
		if (instance == null) {
			return new FileDirectoryInspector(dumpsPath);
		}
		else {
			return instance;
		}
			
	}
	
	public List<Path> getDumpsList() throws IOException {
		
		//Path dumpPath = Paths.get(dumpsPathDescription);
		
		File dir = new File(dumpsPathDescription);
		
		File[] filesInDirectory = dir.listFiles();
		
		
		System.out.println(filesInDirectory.length);
		
		List<File> resultList = Arrays.asList(filesInDirectory);
		List<Path> resultPathList = new ArrayList<>();	
		
		for (File fl : resultList) {
			resultPathList.add(fl.toPath());
		}
		
		
		//Stream<Path> streamOfFiles = Files.walk(dumpPath, FileVisitOption.FOLLOW_LINKS);
	
		//Path[] pathArray = (Path[]) streamOfFiles.toArray();
		
		//streamOfFiles.close();
		return resultPathList;
		
	}
	
	
	
}
