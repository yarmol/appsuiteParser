package accsuite.main;

public class Constants {
	//"C:\Program Files\1cv82\common\1cestart.exe" ENTERPRISE  /F"%KAT%" /N"%USER%"  /P"%PASW%"  DisableStartupMessages /C ÇàâåðøèòüÐàáîòóÏîëüçîâàòåëåé
	//ping 127.0.0.1 -n 300 > null
	final static public String DB_CONNECTION = "DESIGNER  /F\"%Base%\" /N\"%User%\"  /P\"%Password% /DisableStartupMessages ";
	final static public String CF_UPLOAD = "/LoadCfg \"%File%\" /UpdateDBCfg";
	final static public String DT_UPLOAD = "/RestoreIB \"%File%\" /UpdateDBCfg";
	final static public String CONF_FILE_UNLOAD = "/DumpConfigFiles %Catalog%  [-Module] [-Template] [-Help] [-AllWritable] [–Picture] [–Right]";
	final static public String CREATE_BASE = "CREATEINFOBASE /AddInList %BaseName%"; 

	
	//errors 
	final static public String NOT_ALLOWED_TO_SET_PROPERTY = "It is not allowd to set %PROPERTY% of object %OBJECT% "; 
	
	final static public String GIT_COMMIT_STRING = "GIT_AUTHOR_DATE='&date&' GIT_COMMITTER_DATE='&date&' git commit -m '&message&'";
	
	
			
}
