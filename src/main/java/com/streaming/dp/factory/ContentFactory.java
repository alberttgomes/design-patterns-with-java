package com.streaming.dp.factory;

import com.streaming.dp.observer.model.Content;
import com.streaming.dp.observer.model.Miniseries;
import com.streaming.dp.observer.model.Movie;
import com.streaming.dp.observer.model.Series;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author Albert Gomes Cabral
 */
public class ContentFactory {

    public static void register(String type, Supplier<Content> supplier) {
        _CONTENT_KIND_REGISTRY.put(type.toLowerCase(), supplier);
    }

    public static Content create(String type) {
        return _CONTENT_KIND_REGISTRY.getOrDefault(
            type.toLowerCase(), Movie::new).get();
    }

    private static final Map<String, Supplier<Content>> _CONTENT_KIND_REGISTRY =
        new HashMap<>();

    static {
        _CONTENT_KIND_REGISTRY.put("series", Series::new);
        _CONTENT_KIND_REGISTRY.put("miniseries", Miniseries::new);
        _CONTENT_KIND_REGISTRY.put("movie", Movie::new);
    }

}
