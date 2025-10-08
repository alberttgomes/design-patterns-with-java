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

    public void setEmail(String email) {
        _email = email;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        _password = password;
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        _phoneNumber = phoneNumber;
    }

    public List<String> getPreferences() {
        return _preferences;
    }

    public void setPreferences(List<String> preferences) {
        _preferences = preferences;
    }

    public List<Notification> getNotifications() {
        return _notifications;
    }

    public String getSubscription() {
        return _subscription;
    }

    public void setSubscription(String subscription) {
        _subscription = subscription;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    @Override
    public void notifyObservers(
            Consumer<Runnable> consumer, Map<String, String> subject)
        throws RuntimeException {

        consumer.accept(() -> {
            for (Map.Entry<String, String> entry : subject.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                _notifications.add(new Notification(key, value));

               System.out.println(
                   "Notification sent successfully to user: " + _userName);
            }
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
