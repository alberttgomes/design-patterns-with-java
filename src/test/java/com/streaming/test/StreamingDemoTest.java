package com.streaming.test;

import com.streaming.dp.observer.api.StreamingLocalService;
import com.streaming.dp.observer.enums.SeriesCategory;
import com.streaming.dp.observer.enums.Status;
import com.streaming.dp.observer.model.StreamingUser;
import com.streaming.dp.observer.service.StreamingLocalServiceImpl;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Albert Gomes Cabral
 */
public class StreamingDemoTest {

    /**
     * The "Title Test" represents the initial use case, designed to validate the notification
     * observer pattern. All streaming users who have already expressed interest in a category
     * should be notified when new content of that category is launched.
     */
    @Test
    public void shouldCreateUsersAndSendNotifications() {
        StreamingLocalService service = new StreamingLocalServiceImpl();

        StreamingUser user1 = service.createStreamingUser(
            "camile.souza@email.com", "11111111",
            "camile-x", "plus",
            String.valueOf(Status.ACTIVE), "Camile123@");

        user1.setPreferences(
            List.of(
                SeriesCategory.ROMANCE.name(),
                SeriesCategory.DRAMA.name()));

        StreamingUser user2 =
            service.createStreamingUser(
                "albert.gomes@email.com", "2222",
                "Bob", "default",
                String.valueOf(Status.ACTIVE), "1234");

        user2.setPreferences(
            List.of(
                SeriesCategory.ANIMATION.name(),
                SeriesCategory.COMEDY.name(),
                SeriesCategory.HORROR.name()));

        service.launchStreaming(
            String.valueOf(SeriesCategory.DRAMA),
            new Date(), "New series sci-fi dramatic",
            "Dark 2");

        // Testing user's notification

        Assertions.assertEquals(1, user1.getNotifications().size());

        Assertions.assertEquals(0, user2.getNotifications().size());

        // Testing notification content

        String content = user1.getNotifications().getFirst().value();

        Assertions.assertEquals(SeriesCategory.DRAMA.toString(), content);
    }

}
