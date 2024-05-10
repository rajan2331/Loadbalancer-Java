package net.revolut;


import net.revolut.config.ServerCache;
import net.revolut.handler.LBRequestHandler;

public class LoadBalancer {

	public static void main(String[] args) {
		
		ServerCache servers = new ServerCache();
		servers.add("Server 1",20);
		servers.add("Server 2",30);
		servers.add("Server 3",50);
		
		LBRequestHandler handler = new LBRequestHandler(servers);
		
		handler.handle("Request 1");
		handler.handle("Request 2");
		handler.handle("Request 3");
		
	}
}
