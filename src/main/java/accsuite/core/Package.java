package accsuite.core;

public class Package {
	   FileDescriptor file;
	   String 		  command;
	   int			  order;
	   
	   Package() {
		   
	   }

	public Package(FileDescriptor fileDescriptor) {
		// TODO Auto-generated constructor stub
	}

	public void add(FileDescriptor fileDescriptor, String commandValue) {
		this.file 		= fileDescriptor;
		this.command 	= commandValue;
		
		
	}
}
