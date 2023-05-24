package cache;

import io.restassured.http.Cookies;
import rest.dto.GetTaskResDTO;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class TestCache {

    private static final ThreadLocal<TestSessionMap> CACHE = new InheritableThreadLocal<>();

    static {
        CACHE.set(new TestSessionMap()); // there was a need to set a new TestSessionMap, otherwise - NPE
    }

    private static TestSessionMap getCache() {
        return CACHE.get();
    }

    public static void putDataInCache(final TestCacheKey key, final Object value) {
        getCache().put(key, value);
    }

    public static String getStringFromCache(final TestCacheKey key) {
        return get(key, String.class);
    }
    public static Integer getIntegerFromCache(final TestCacheKey key) {
        return get(key, Integer.class);
    }
    public static GetTaskResDTO getCreatedTaskFromCache(final TestCacheKey key) {
        return get(key, GetTaskResDTO.class);
    }
    public static Cookies getCookiesFromCache(final TestCacheKey key) {
        return get(key, Cookies.class);
    }

    public static <T> T get(final TestCacheKey key, final Class<?> type) {
        Object value = getCache().get(key);
        return Objects.nonNull(value) ? (T) value : null;
    }

    private static class TestSessionMap extends ConcurrentHashMap<Object, Object> {

        @Override
        public Object put(final Object key, final Object value) {
            return Objects.isNull(value) ? super.remove(key) : super.put(key, value);
        }
    }
}
