package accsuite.upload.into;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import accsuite.main.Global;
import accsuite.threadsStarter.AccSuiterStarter;

public class BaseUpload {
	
	public static void start() throws IOException {
		DumpsDataSupplier dumper = DumpsDataSupplier.getInstance(Global.getAnalizingDir());
		List<Path> listOfFiles = dumper.getDumpsList();
		
		//building map of files-commands to upload
		CommandDescriptionSupplier commandDescriptor = new CommandDescriptionSupplier(listOfFiles);
		commandDescriptor.analize();
		commandDescriptor.buildCommands();
		Map<FileDescriptor,String> fileAndCommandMap = commandDescriptor.getMap();
		
		//get array of chunks (every chunk consist of &Global.getNumberOfThreads() elements)
		Divider div 	= new Divider(fileAndCommandMap);
		List<Chunk> chunks = div.getChunks();
		
		//send chunks to process
		AccSuiterStarter accLoadInto = new AccSuiterStarter(chunks);
		
	}
}
