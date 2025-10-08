package com.streaming.dp.observer.model;

import java.util.Date;
import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
public class Series extends BaseContent {

    @Override
    protected Map<String, Object> attributes() throws RuntimeException {
        return Map.of();
    }

    public String getSessionNumber() {
        return _session.sessionNumber;
    }

    public long getChapters() {
        return _session.chapters;
    }

    public void setSession(long chapters, String sessionNumber) {
        _session = new Session(chapters, sessionNumber);
    }

    private Session _session;

    private static class Session {

        public Session(long chapters, String sessionNumber) {
            this.chapters = chapters;
            this.lastUpdate = new Date();
            this.sessionNumber = sessionNumber;
        }

        public long chapters;

        public Date lastUpdate;

        public String sessionNumber;
    }

}
