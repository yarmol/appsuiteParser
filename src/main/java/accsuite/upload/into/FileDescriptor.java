package accsuite.upload.into;

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

public class FileDescriptor implements Comparable<FileDescriptor>{
	private  DumpTypeEnum 		type;
	private  String				name;
	private  Path				path;
	private  long 				size;
	private  long 				datetime;
	private  String 			dateTimeView;
	//private  File 				fileReference;
	
	
	FileDescriptor(Path filePath) throws IOException {
		
		this.name = filePath.toAbsolutePath().getFileName().toString();
	
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
			
		if (this.type != null) {
			this.path = filePath.toAbsolutePath();

			BasicFileAttributes attr = Files.readAttributes(this.path, BasicFileAttributes.class);
			FileTime fileDateTime = attr.creationTime();
			this.datetime		  = fileDateTime.toMillis();
			this.size 			  = attr.size();	
			Date fileDate 		  = new Date(this.datetime);
				
			DateFormat format	  = new SimpleDateFormat("dd.MM.yy HH:mm");
			this.dateTimeView 	  = format.format(fileDate);
		}
		
		
	}
	
	



	public DumpTypeEnum getType() {
		return type;
	}



	public String getName() {
		return name;
	}





	public Path getPath() {
		return path;
	}







	public long getSize() {
		return size;
	}








	public long getDatetime() {
		return datetime;
	}









	public String getDateTimeView() {
		return dateTimeView;
	}





	@Override
	public int compareTo(FileDescriptor o) {
		if (this.datetime > o.datetime) {
			return 1;
		}
		else if (this.datetime < o.datetime) {
			return -1;
		} 
		else {
			return 0;
		}
		
	}





}