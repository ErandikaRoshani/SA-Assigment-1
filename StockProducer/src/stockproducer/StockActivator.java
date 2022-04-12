package stockproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class StockActivator implements BundleActivator {
	
	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Stock Producer Service Started!");
		StockService stockService = new StockServiceImpl();
		publishServiceRegistration = context.registerService(StockService.class.getName(),stockService,null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stock Producer Service Stopped!");
		publishServiceRegistration.unregister();
	}

}
