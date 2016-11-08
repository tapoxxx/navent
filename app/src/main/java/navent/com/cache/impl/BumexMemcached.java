package navent.com.cache.impl;

import navent.com.cache.Cacheable;

public class BumexMemcached implements Cacheable {
	
	private static BumexMemcached cacheManager;
	
	// metodo para singleton
	public static BumexMemcached getInstance(){
		if(cacheManager==null){
			cacheManager = new BumexMemcached();
		}
		
		return cacheManager;
	}

	@Override
	public void set(String key, Object value) {
		// implementacion
	}

	@Override
	public Object get(String key) {
		// implementacion		
		return null;
	}

	@Override
	public void delete(String key) {
		// implementacion
	}
	
}
