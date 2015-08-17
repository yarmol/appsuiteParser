package accsuite.main;

import java.util.HashMap;
import java.util.Map;

public enum DumpTypeEnum {
   
   DT, CF;
   
   private static final Map<DumpTypeEnum, String> enumMap = new HashMap<>();
   
   static {
	   
	   getEnummap().put(CF, Constants.CF_UPLOAD);
	   getEnummap().put(DT, Constants.DT_UPLOAD);
	   
   }

public static Map<DumpTypeEnum, String> getEnummap() {
	return enumMap;
}
   
}
