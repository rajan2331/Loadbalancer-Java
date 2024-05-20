package net.revolut.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.revolut.config.ServerCache;

public class WightedRoundRobinLB implements LBFactory {

	
	private  ServerCache serverCache;
	
		
	public WightedRoundRobinLB(ServerCache servers) {
		super();
		this.serverCache = servers;
	}


		private static Integer position = 0;

		@Override
		public void handle(String server) {
		    Set<String> servers = serverCache.getCache().keySet();
	        List<String> serverList = new ArrayList<>();

	        Iterator<String> iterator = servers.iterator();
	        while (iterator.hasNext()) {
	            String serverItem = iterator.next();
	            Integer weight = serverCache.getCache().get(serverItem);
	            if (weight > 0) {
	                for (int i = 0; i < weight; i++) {
	                    serverList.add(serverItem);
	                }
	            }

	        }

	        synchronized (position) {
	            if (position > serverList.size()) {
	                position = 0;
	            }

	            String target = serverList.get(position);
	            position++;
	           System.out.println("WightedRoundRobinLB selected "+target);
	        }
	    }

}
