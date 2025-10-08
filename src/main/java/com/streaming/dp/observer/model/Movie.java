package com.streaming.dp.observer.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
public class Movie extends BaseContent {

    @Override
    protected Map<String, Object> attributes() throws RuntimeException {
        return _attributes;
    }

    private final Map<String, Object> _attributes = new HashMap<>();

}
