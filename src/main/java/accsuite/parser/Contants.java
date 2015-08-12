package accsuite.parser;

public class Contants {
	//"C:\Program Files\1cv82\common\1cestart.exe" ENTERPRISE  /F"%KAT%" /N"%USER%"  /P"%PASW%"  DisableStartupMessages /C ÇàâåðøèòüÐàáîòóÏîëüçîâàòåëåé
	//ping 127.0.0.1 -n 300 > null
	final static String DB_CONNECTION = "DESIGNER  /F\"%Base%\" /N\"%User%\"  /P\"%Password% /DisableStartupMessages ";
	final static String CF_UPLOAD = "/LoadCfg %File% /UpdateDBCfg";
	final static String DT_UPLOAD = "/RestoreIB %File% /UpdateDBCfg";
	final static String CONF_FILE_UNLOAD = "/DumpConfigFiles %Catalog%  [-Module] [-Template] [-Help] [-AllWritable] [–Picture] [–Right]";
	final static String CREATE_BASE = "CREATEINFOBASE /AddInList %BaseName%"; 
	
	final static String GIT_COMMIT_STRING = "GIT_AUTHOR_DATE='&date&' GIT_COMMITTER_DATE='&date&' git commit -m '&message&'";
	
			
}
