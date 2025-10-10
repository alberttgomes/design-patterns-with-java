package com.streaming.dp.observer.api;

import com.streaming.dp.observer.enums.Category;
import com.streaming.dp.observer.model.Content;
import com.streaming.dp.observer.model.StreamingUser;

import java.util.Date;
import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
public interface StreamingLocalService {

    Content createMovieContent(
            String authored,  Map<Integer, String> awards,
            Map<String, Object> attributes, Category category, String description,
            int duration, Date launchDate, String name, long primKey)
        throws RuntimeException;

    Content createSeriesContent(
            int chapters, Map<String, Object> attributes, Category category,
            String description, int duration, Date launchDate, String name,
            long primKey, int sessionNumber)
        throws RuntimeException;

    StreamingUser createStreamingUser(
            String email, String phoneNumber, String username, String subscription,
            String status, String password)
        throws RuntimeException;

    StreamingUser getStreamingUser(String email, String password)
        throws RuntimeException;

    void launchStreaming(
            String lunchCategory, Date lunchDate, String lunchDescription,
            String lunchName)
        throws RuntimeException;

}
