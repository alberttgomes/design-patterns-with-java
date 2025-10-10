package com.streaming.dp.observer.model;

import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
public class Movie extends BaseContent {

    public Map<String, Object> getAttributes() {
        return _attributes;
    }

    public Production getProduction() {
        return _production;
    }

    public static class Production {

        public Production(
            String authored, Map<Integer, String> awards) {

            _authored = authored;

            _awards = awards;
        }

        public String getAuthored() {
            return _authored;
        }

        public Map<Integer, String> getAwards() {
            return _awards;
        }

        private final String _authored;

        private final Map<Integer, String>  _awards;

    }

    public void setAttributes(Map<String, Object> attributes) {
        _attributes =  attributes;
    }

    public void setProduction(
        String authored, Map<Integer, String> awards) {

        _production = new Production(authored, awards);
    }

    private Map<String, Object> _attributes;

    private Production _production;

}
