package accsuite.upload.into;

public class Chunk {
	   FileDescriptor file;
	   String 		  command;
	   int			  order;
	   
	   Chunk() {
		   
	   }

	public Chunk(FileDescriptor fileDescriptor) {
		// TODO Auto-generated constructor stub
	}

	public void add(FileDescriptor fileDescriptor, String commandValue) {
		this.file 		= fileDescriptor;
		this.command 	= commandValue;
		
		
	}
}
