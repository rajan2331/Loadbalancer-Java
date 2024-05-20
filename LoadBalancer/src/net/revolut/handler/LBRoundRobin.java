package net.revolut.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.revolut.config.ServerCache;

public class LBRoundRobin implements LBFactory {

	private ServerCache serverCache;
	public LBRoundRobin(ServerCache servers) {
		this.serverCache=servers;
	}

	 private static Integer position = 0;
	@Override
	public void handle(String server) {
		   Set<String> servers = serverCache.getCache().keySet();
	        List<String> serverList = new ArrayList<>();
	        serverList.addAll(servers);
	        String target = null;

	        synchronized (position) {
	            if (position > serverList.size() - 1) {
	                position = 0;
	            }
	            target = serverList.get(position);
	            position++;
	        }
	       System.out.println("RoundRobin Algo selected "+target);
	    
		
	}

}
