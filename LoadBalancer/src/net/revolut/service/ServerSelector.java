package net.revolut.service;

import java.util.Map;
import java.util.Map.Entry;

public class ServerSelector {

	public String select(Map<String,Integer> cache)
	{	
		String selectedServer=null;
		int minLoad= Integer.MAX_VALUE;
		for(Entry<String,Integer> entry : cache.entrySet())
		{
			int currentLoad = entry.getValue();
			if(currentLoad<minLoad)
			{
				minLoad= currentLoad;
				selectedServer = entry.getKey();
			}
		}
		return selectedServer;
	}
}
