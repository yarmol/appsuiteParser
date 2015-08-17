package accsuite.core;

import java.util.Map;
import java.util.TreeMap;

public class Package<T,V> {
	   //FileDescriptor file;
	   //String 		  command;
	   private int			  order;
	   private Map<T,V>		  contentMap;
	   
	  

	public Package(int order) {
		this.order = order;
		setContentMap(new TreeMap<T,V>());
	}

	private void setContentMap(TreeMap<T, V> treeMap) {
		this.contentMap = treeMap;
		
		
	}

	public void add(T key, V value) {
		
		getContentMap().put(key, value);
		
		
	}

	public Map<T,V> getContentMap() {
		return contentMap;
	}

	public int getOrder() {
		return order;
	}

	

	
	
	
}
