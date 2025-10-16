package com.streaming.dp.service;

import com.streaming.dp.builder.ContentBuilder;
import com.streaming.dp.api.StreamingLocalService;
import com.streaming.dp.enums.Category;
import com.streaming.dp.model.Content;
import com.streaming.dp.model.StreamingUser;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Albert Gomes Cabral
 */
public class StreamingLocalServiceImpl implements StreamingLocalService {

    @Override
    public Content createMovieContent(
            String authored, Map<Integer, String> awards,
            Map<String, Object> attributes, Category category, String description,
            int duration, Date launchDate, String name, long primKey)
        throws RuntimeException {

        _validateContent(
            category, _DEFAULT_CHAPTER_NUMBER, description,
            duration, name, _DEFAULT_SESSION_NUMBER);

        return new ContentBuilder(
            ).setAuthored(
                authored
            ).setAttributes(
                attributes
            ).setAwards(
                awards
            ).setCategory(
                category
            ).setDescription(
                description
            ).setDuration(
                duration
            ).setLaunchDate(
                launchDate
            ).setName(
                name
            ).setPrimKey(
                primKey
            ).setType(
                "movie"
            ).build();
    }

    @Override
    public Content createSeriesContent(
            int chapters, Map<String, Object> attributes, Category category,
            String description, int duration, Date launchDate, String name,
            long primKey, int sessionNumber)
        throws RuntimeException {

        try {
            _validateContent(
                category, chapters, description, duration, name,
                sessionNumber);

            return new ContentBuilder(
                ).setAttributes(
                    attributes
                ).setCategory(
                    category
                ).setChapters(
                    chapters
                ).setDescription(
                    description
                ).setDuration(
                    duration
                ).setLaunchDate(
                    launchDate
                ).setName(
                    name
                ).setPrimKey(
                    primKey
                ).setSessionNumber(
                    sessionNumber
                ).setType(
                    "series"
                ).build();
        }
        catch (InvalidParameterException invalidParameterException) {
            throw new RuntimeException(invalidParameterException);
        }

    }

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

    private void _validateContent(
            Category category, int chapter, String description, int duration,
            String name, int sessionNumber)
        throws InvalidParameterException {

        if (chapter <= 0 || sessionNumber <= 0 || duration <= 0) {
            throw new InvalidParameterException(
                ("Invalid parameters for chapter or session number" +
                        " %s %s ").formatted(chapter, sessionNumber));
        }

        if (category == null) {
            throw new InvalidParameterException(
                "Invalid category parameter");
        }

        if (Objects.isNull(description) || Objects.isNull(name)) {
            throw new InvalidParameterException(
                "Invalid description or name parameters");
        }

    }

    private final Map<String, StreamingUser> _streamingUsersMap =
        new HashMap<>();

    private static final int _DEFAULT_CHAPTER_NUMBER = 1;

    private static final int _DEFAULT_SESSION_NUMBER =
        _DEFAULT_CHAPTER_NUMBER;

}
