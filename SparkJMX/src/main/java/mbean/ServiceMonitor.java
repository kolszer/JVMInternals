package mbean;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

import service.SomeService;

public class ServiceMonitor extends NotificationBroadcasterSupport implements
		ServiceMonitorMBean {

	private SomeService ss;
	private int sequenceNumber = 0;

	public ServiceMonitor(SomeService ss) {
		this.ss = ss;
	}

	//@Override
	public void setX(int x) {
		ss.setX(x);

		if (x >= 0 && x <= 5) {
			Notification notification = new AttributeChangeNotification(this,
					sequenceNumber++, System.currentTimeMillis(),
					"Niska wartosc potegi", "x", "int", ss.getX(),
					x);
			notification.setUserData("zmiana x  na " + x);
			sendNotification(notification);
		}else if(x >= 6 && x <= 10) {
			Notification notification = new AttributeChangeNotification(this,
					sequenceNumber++, System.currentTimeMillis(),
					"Srednia wartosc potegi", "x", "int", ss.getX(),
					x);
			notification.setUserData("zmiana x  na " + x);
			sendNotification(notification);
		}else if(x > 10) {
			Notification notification = new AttributeChangeNotification(this,
					sequenceNumber++, System.currentTimeMillis(),
					"Wysoka wartosc potegi", "x", "int", ss.getX(),
					x);
			notification.setUserData("zmiana x  na " + x);
			sendNotification(notification);
		}

	}

	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };

		String name = AttributeChangeNotification.class.getName();
		String description = "Zmiana wartosci atrybutu";
		MBeanNotificationInfo info = new MBeanNotificationInfo(types, name,
				description);
		return new MBeanNotificationInfo[] { info };
	}

	//@Override
	public int getX() {
		return ss.getX();
	}


}
