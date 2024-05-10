package net.revolut.handler;

import java.util.Map;

import net.revolut.config.ServerCache;
import net.revolut.service.ServerSelector;

public class LBRequestHandler {
	
	private ServerCache serverCache;
	public LBRequestHandler(ServerCache serverCache) {
		this.serverCache=serverCache;
	}

	public void handle(String request) {
		Map<String,Integer> cache = serverCache.getCache();
		if(cache.isEmpty())
		{
			System.out.println("No server availble.");
			return;
		}
			
		ServerSelector selector = new ServerSelector();
		String serverName = selector.select(cache);
		System.out.println("Request processed to this server "+serverName);
	}

}
