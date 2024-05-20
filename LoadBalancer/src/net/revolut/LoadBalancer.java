package net.revolut;


import net.revolut.config.ServerCache;
import net.revolut.handler.LBFactory;

import net.revolut.handler.WightedRoundRobinLB;

public class LoadBalancer {

	public static void main(String[] args) {
		
		ServerCache servers = new ServerCache();
		servers.add("Server 1",5);
		servers.add("Server 2",5);
		servers.add("Server 3",5);
		
		LBFactory handler = new WightedRoundRobinLB(servers);
		
		for(int i=0;i<15;i++)
		{
		handler.handle("Request 1");
		}
		//handler.handle("Request 2");
		//handler.handle("Request 3");
		
		
	}
}
