package com.streaming.test;

import com.streaming.dp.builder.ContentBuilder;
import com.streaming.dp.observer.api.StreamingLocalService;
import com.streaming.dp.observer.enums.Category;
import com.streaming.dp.observer.enums.Status;
import com.streaming.dp.observer.model.Content;
import com.streaming.dp.observer.model.Series;
import com.streaming.dp.observer.model.StreamingUser;
import com.streaming.dp.observer.service.StreamingLocalServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Albert Gomes Cabral
 */
public class StreamingDemoTest {

    /**
     * Represents the initial test case designed to validate the notification
     * observer pattern within the streaming service domain.
     *
     * <p>This test ensures that all streaming users who have already expressed
     * interest in a specific {@code Category} are properly notified whenever
     * new content of that category is launched.</p>
     *
     * <p>The validation covers both:
     * <ul>
     *     <li>Correct user notification dispatch when preferences match.</li>
     *     <li>Absence of notification for users without matching preferences.</li>
     * </ul>
     * </p>
     */
    @Test
    public void shouldCreateUsersAndSendNotifications() {
        StreamingUser user1 = _streamingLocalService.createStreamingUser(
            "camile.souza@email.com", "11111111",
            "camile-x", "plus",
            String.valueOf(Status.ACTIVE), "Camile123@");

        user1.setPreferences(
            List.of(
                Category.ROMANCE.name(),
                Category.DRAMA.name()));

        StreamingUser user2 =
            _streamingLocalService.createStreamingUser(
                "albert.gomes@email.com", "2222",
                "Bob", "default",
                String.valueOf(Status.ACTIVE), "1234");

        user2.setPreferences(
            List.of(
                Category.ANIMATION.name(),
                Category.COMEDY.name(),
                Category.HORROR.name()));

        _streamingLocalService.launchStreaming(
            String.valueOf(Category.DRAMA),
            new Date(), "New series sci-fi dramatic",
            "Dark 2");

        // Testing user's notification

        Assertions.assertEquals(1, user1.getNotifications().size());

        Assertions.assertEquals(0, user2.getNotifications().size());

        // Testing notification content

        String content = user1.getNotifications().getFirst().key();

        Assertions.assertEquals(Category.DRAMA.toString(), content);
    }

    /**
     * Tests for {@link ContentBuilder}, responsible for building different types of {@link Content}
     * (e.g., movies, series, and miniseries) based on dynamic configuration parameters.
     *
     * <p>This class verifies that the builder correctly instantiates and populates
     * different {@code Content} implementations according to the provided type and
     * attribute values.</p>
     *
     * <p><strong>Examples of covered scenarios:</strong></p>
     * <ul>
     *     <li>Building a {@code Movie} as the default content type.</li>
     *     <li>Building a {@code Series} with custom duration and name.</li>
     *     <li>Building a {@code Miniseries} with description and favorite flag.</li>
     * </ul>
     */
    @Test
    public void shouldCreateContentBasedOnType() {
        Content content = _streamingLocalService.createSeriesContent(
            10, new HashMap<>(), Category.COMEDY,
            "Some adolescent starts the new college life and are discovering dangs sides",
            18, new Date(), "How to sell drugs online (Faster)",
            1901, 5);

        Assertions.assertInstanceOf(Series.class, content, "test passed");
    }

    private StreamingUser _createStreamingUser(
        String email, String number, String password, String subscription,
        String userName, String status) {

        return _streamingLocalService.createStreamingUser(
            email, number, userName, subscription, status, password);
    }

    private final StreamingLocalService _streamingLocalService =
        new StreamingLocalServiceImpl();

}
