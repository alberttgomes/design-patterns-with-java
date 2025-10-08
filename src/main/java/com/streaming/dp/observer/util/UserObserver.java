package com.streaming.dp.observer.util;

import java.util.Map;
import java.util.function.Consumer;

/**
 * @author Albert Gomes Cabral
 */
public interface UserObserver {

    void notifyObservers(
            Consumer<Runnable> consumer, Map<String, String> subject)
        throws RuntimeException;

}
