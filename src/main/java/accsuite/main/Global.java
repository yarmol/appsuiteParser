package accsuite.main;

import java.lang.reflect.Method;

public class Global {
	
	private static String accSuiteBinPath;
	private static int numberOfThreads = 0;
	private static String gitBinPath;
	private static String workingDir;
	private static String analizingDir;
	
	
	public static void println(String msg) {
		System.out.println(msg);
	}
	
	public static String getGitBinPath() {
		return gitBinPath;
	}
	
	private static void debugSetMessage(String param, String value) {
		println("Setting global '"+param+"' = "+value);
	}
	
	public static void setGitBinPath(String value) {
		Method methodDescr = Global.class.getEnclosingMethod();
		debugSetMessage(methodDescr.getName().replace("set", ""), value);
		
		if (gitBinPath == null)  {
			Global.gitBinPath = value;
		}
		else 
		{
			new ParserException(ParserException.getErrorMessageDescription(methodDescr));
		}
		
	}
	
	public static String getWorkingDir() {
		return workingDir;
	}
	
	public static void setWorkingDir(String value) {
		Method methodDescr = Global.class.getEnclosingMethod();
		debugSetMessage(methodDescr.getName().replace("set", ""), value);
		
		if (workingDir == null)  {
			Global.workingDir = value;
		}
		else 
		{
			new ParserException(ParserException.getErrorMessageDescription(methodDescr));
		}
		
	}
	
	
	public static String getAnalizingDir() {
		return analizingDir;
	}
	
	public static void setAnalizingDir(String value) {
		Method methodDescr = Global.class.getEnclosingMethod();
		debugSetMessage(methodDescr.getName().replace("set", ""), value);

		
		if (accSuiteBinPath == null)  {
			Global.analizingDir = value;
		}
		else 
		{
			new ParserException(ParserException.getErrorMessageDescription(methodDescr));
		}
		
	}
	
	
	public static String getAccSuiteBinPath() {
		return accSuiteBinPath;
	}
	
	public static void setAccSuiteBinPath(String value) {
		Method methodDescr = Global.class.getEnclosingMethod();
		debugSetMessage(methodDescr.getName().replace("set", ""), value);

		if (accSuiteBinPath == null)  {
			Global.accSuiteBinPath = value;
		}
		else 
		{
			new ParserException(ParserException.getErrorMessageDescription(methodDescr));
		}
		
	}
	
	public static void setNumberOfThreads(int value) {
		Method methodDescr = Global.class.getEnclosingMethod();
		debugSetMessage(methodDescr.getName().replace("set", ""), Integer.valueOf(value).toString());
		
		if (numberOfThreads == 0)  {
			Global.numberOfThreads = value;
		}
		else 
		{
			new ParserException(ParserException.getErrorMessageDescription(methodDescr));
		}
		
	}
	
	public static int getNumberOfThreads() {
		return numberOfThreads;
	}
	
	

	
}
