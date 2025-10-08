package com.streaming.dp.observer.api;

import com.streaming.dp.observer.model.StreamingUser;

import java.util.Date;

/**
 * @author Albert Gomes Cabral
 */
public interface StreamingLocalService {

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
