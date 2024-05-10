package net.revolut.config;

import java.util.HashMap;
import java.util.Map;

public class ServerCache {
	Map<String,Integer> cache = null;
	
	
	public ServerCache() {
		cache = new HashMap();
	}


	public Map<String, Integer> getCache() {
		return cache;
	}
	

	public void add(String server, int load) {
		cache.putIfAbsent(server, load);
	}

	public void updateLoad(String server, int load)
	{
		cache.put(server, load);
	}
}
