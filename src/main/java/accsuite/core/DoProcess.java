package accsuite.core;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import accsuite.main.Global;
import accsuite.threadsStarter.AccSuiterStarter;

public class DoProcess {
	
	public static void start() throws IOException {
		FileDirectoryInspector dumper = FileDirectoryInspector.getInstance(Global.getAnalizingDir());
		List<Path> listOfFiles = dumper.getDumpsList();
		
		//building map of files-commands to upload
		CommandDescriptionSupplier commandDescriptor = new CommandDescriptionSupplier(listOfFiles);
		commandDescriptor.analize();
		commandDescriptor.buildCommands();
		Map<FileDirectoryDescriptor, CommandRun> fileAndCommandMap = commandDescriptor.getMap();
		
		//get array of chunks (every chunk consist of &Global.getNumberOfThreads() elements)
		Divider<FileDirectoryDescriptor, CommandRun> div = new Divider<>(fileAndCommandMap);
		List<Package<FileDirectoryDescriptor, CommandRun>> packages = div.getPackages();
		
		//send chunks to process
		AccSuiterStarter<FileDirectoryDescriptor, CommandRun> accThreadStarter = new AccSuiterStarter<>(packages);
		
	}
}
