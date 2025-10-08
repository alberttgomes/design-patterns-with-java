package com.streaming.dp.observer.service;

import com.streaming.dp.observer.api.StreamingLocalService;
import com.streaming.dp.observer.model.StreamingUser;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
public class StreamingLocalServiceImpl implements StreamingLocalService {

    @Override
    public StreamingUser createStreamingUser(
            String email, String phoneNumber, String username,
            String subscription, String status, String password)
        throws RuntimeException {

        StreamingUser streamingUser = new StreamingUser();

        streamingUser.setEmail(email);
        streamingUser.setPassword(password);
        streamingUser.setPhoneNumber(phoneNumber);
        streamingUser.setSubscription(subscription);
        streamingUser.setStatus(status);
        streamingUser.setUserName(username);

        _streamingUsersMap.put(email, streamingUser);

        return streamingUser;
    }

    @Override
    public StreamingUser getStreamingUser(String email, String password)
        throws RuntimeException {

        StreamingUser streamingUser = _streamingUsersMap.get(email);

        if (streamingUser != null) {
            if (streamingUser.getPassword().equals(password)) {
                return streamingUser;
            }
        }

        return null;
    }

    @Override
    public void launchStreaming(
            String launchCategory, Date launchDate, String launchDescription,
            String launchName)
        throws RuntimeException {

        Map<String, String> map = new HashMap<>();

        map.put("category", launchCategory);
        map.put("date", launchDate.toString());
        map.put("description", launchDescription);
        map.put("name", launchName);

        for (Map.Entry<String, StreamingUser> entry : _streamingUsersMap.entrySet()) {
            StreamingUser value = entry.getValue();

            List<String> preferences = value.getPreferences();

            if (preferences.contains(map.get("category"))) {
                value.notifyObservers(Runnable::run, map);
            }
        }
    }

    private final Map<String, StreamingUser> _streamingUsersMap =
        new HashMap<>();

}
