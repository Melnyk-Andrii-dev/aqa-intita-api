package rest.util;

import java.util.concurrent.ThreadLocalRandom;

public class Attribute {
    public static long getTaskTempUid() {
        return ThreadLocalRandom.current().nextLong(0, 9999999999999L);
    }
}
