package com.streaming.dp.observer.model;

import com.streaming.dp.observer.util.UserObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author Albert Gomes Cabral
 */
public class StreamingUser implements UserObserver {

    public String getEmail() {
        return _email;
    }

    public List<Notification> getNotifications() {
        return _notifications;
    }

    public String getPassword() {
        return _password;
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public List<String> getPreferences() {
        return _preferences;
    }

    public String getSubscription() {
        return _subscription;
    }

    public String getStatus() {
        return _status;
    }

    public String getUserName() {
        return _userName;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public void setPassword(String password) {
        _password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        _phoneNumber = phoneNumber;
    }

    public void setPreferences(List<String> preferences) {
        _preferences = preferences;
    }

    public void setSubscription(String subscription) {
        _subscription = subscription;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    @Override
    public void notifyObservers(
            Consumer<Runnable> consumer, Map<String, String> subject)
        throws RuntimeException {

        consumer.accept(() -> {
            String key = subject.get("category");
            String value = subject.get("description");

            _notifications.add(new Notification(key, value));

            System.out.println(
               "Notification sent successfully to user: " + _userName);

        });
    }

    private String _email;

    private String _password;

    private String _phoneNumber;

    private String _subscription;

    private String _status;

    private String _userName;

    private List<String> _preferences = new ArrayList<>();

    private final List<Notification> _notifications = new ArrayList<>();

}
