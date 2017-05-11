package mbean;

import mbean.IServiceStatsMonitor;
import mbean.ServiceStats;
import service.SomeService;

public class ServiceStatsMonitor implements IServiceStatsMonitor {
	
	private SomeService ss;
	
	public ServiceStatsMonitor(SomeService ss) {
		this.ss = ss;
	}

	//@Override
	public ServiceStats getServiceStats() {
		return new ServiceStats(ss.getA(), ss.getX());
	}


}
