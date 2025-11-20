package main;

import java.util.HashMap;
import java.util.Map;

public class TTL {
	private record Value(String value, long timestamp) {}
	private Map<String, Value> data = new HashMap<>();
	private long ttlMillis;

	public TTL(long ttlMillis) {
		this.ttlMillis = ttlMillis;
	}

	public void put(String key, String val) {
		data.put(key, new Value(val, System.currentTimeMillis()));
	}

	public String get(String key) {
		Value val = data.get(key);
		if (val == null || (System.currentTimeMillis() - val.timestamp > ttlMillis)) {
			data.remove(key);
			return null;
		}
		return val.value;
	}
}
