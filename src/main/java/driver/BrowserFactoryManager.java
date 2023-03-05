package driver;

import java.util.HashMap;
import java.util.Map;

import utils.MyLogger;


public class BrowserFactoryManager {
	private BrowserFactory Chrome = new ChromeManager();
	private BrowserFactory Edge =  new EdgeManager();
	private BrowserFactory Firefox =  new FireFoxManager();
	private Map<String, BrowserFactory> map = new HashMap<>();
	
	{
		map.put("chrome",Chrome);
		map.put("edge",Edge);
		map.put("firefox",Firefox);	
	}
	
	public BrowserFactory get(String param)
	{
		MyLogger.info("get the browser Manager from the parameter passed -> " + param.toLowerCase());
		return map.get(param.toLowerCase());

	}
}
