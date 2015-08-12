package accsuite.main;

import java.lang.reflect.Method;

import accsuite.*;
import accsuite.parser.Constants;
/**
 * 
 * Class ParserException.
 * Representing small basic project errors
 *  
 *  
 * @author vitaly
 * @date 12 рту. 2015 у.
 */

public class ParserException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2476377239328668326L;

	ParserException(String description) {
		
		super(description);
	}
	
	
	public static String getErrorMessageDescription(Method methodDescr) {
		String methodName = methodDescr.getName();
		String className  = methodDescr.getClass().getName();
		String errorMsg = new String(Constants.NOT_ALLOWED_TO_SET_PROPERTY);
		String renderedErrorMsg = errorMsg.replace("%PROPERTY%", methodName).replace("%OBJECT%", className);
		return renderedErrorMsg;
	}
	
}
