package com.streaming.dp.observer.model;

import java.util.Date;

/**
 * @author Albert Gomes Cabral
 */
public class Series extends BaseContent {

    public Session getSession() {
        return _session;
    }

    public static class Session {

        public Session(int chapters, int sessionNumber) {
            _chapters = chapters;
            _lastUpdate = new Date();
            _sessionNumber = sessionNumber;
        }

        public int getChapters() {
            return _chapters;
        }

        public int getSessionNumber() {
            return _sessionNumber;
        }

        public int _chapters;

        public Date _lastUpdate;

        public int _sessionNumber;
    }

    public void setSession(int chapters, int sessionNumber) {
        _session = new Session(chapters, sessionNumber);
    }

    private Session _session;

}
