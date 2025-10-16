package com.streaming.dp.observer.model;

import com.streaming.dp.observer.enums.Category;

import java.util.Date;

/**
 * @author Albert Gomes Cabral
 */
public interface Content {

    Category getCategory();

    String getDescription();

    int getDuration();

    Date getLaunchDate();

    String getName();

    long getPrimKey();

    void setCategory(Category category);

    void setDescription(String description);

    void setDuration(int duration);

    void setLaunchDate(Date launchDate);

    void setName(String name);

    void setPrimKey(long primKey);

}
