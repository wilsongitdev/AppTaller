package uni.taller.util;

import java.util.HashMap;
import java.util.Map;


public final class Session {

  private Session() {
  }

  private static Map<String, Object> datos;

  static {
    datos = new HashMap<>();
  }

  public static void put(String key, Object value) {
    datos.put(key, value);
  }

  public static Object get(String key) {
    return datos.get(key);
  }

}
