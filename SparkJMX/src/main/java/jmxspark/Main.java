package jmxspark;

import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import mbean.ServiceMonitor;
import mbean.ServiceStatsMonitor;
import service.SomeService;

public class Main {


	public static void main(String[] args) throws Exception {
		
		SomeService ss = new SomeService();
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		ObjectName monitorName = new ObjectName("jmxspark:type=Server,name=SomeService");
		ServiceMonitor sm = new ServiceMonitor(ss);
		mbs.registerMBean(sm, monitorName);
		
		ObjectName statsMonitorName = new ObjectName("jmxspark:type=Server,name=ServiceStats");
		ServiceStatsMonitor ssm = new ServiceStatsMonitor(ss);
		mbs.registerMBean(ssm, statsMonitorName);
		
    	get("/pow/:a", (req, res) -> 
		{
			ss.setA(Integer.parseInt(req.params(":a")));
			return ss.result();
		});

	}

}

