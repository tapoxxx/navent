package navent.com.cache;

public interface Cacheable {
	
	void set(String key, Object value);

	Object get(String key);

	void delete(String key);
}
