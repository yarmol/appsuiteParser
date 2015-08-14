package accsuite.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import accsuite.main.*;

public class FileDescriptor extends FileDirectoryDescriptor{
	private  DumpTypeEnum 		type;
	private  long 				size;
	
	
	FileDescriptor(Path filePath) throws IOException {
		super(filePath);
		
	
	
		String fileExtension = filePath.toAbsolutePath().getFileName().toString().split("\\.")[0];
		
		if (fileExtension.equals("cf")) {
			this.type = DumpTypeEnum.CF;
		}
		else if (fileExtension.equals("dt")) {
			this.type = DumpTypeEnum.DT;
		}
		else {
			this.type = null;
		}
			
		this.size 			  = this.attributes.size();	
		
	}
	
	



	public DumpTypeEnum getType() {
		return type;
	}


	public long getSize() {
		return size;
	}


















	





}