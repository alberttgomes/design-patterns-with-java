package com.streaming.dp.observer.model;

import java.util.Date;
import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
public abstract class BaseContent {

    protected abstract Map<String, Object> attributes() throws RuntimeException;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Date getLunchDate() {
        return lunchDate;
    }

    public void setLunchDate(Date lunchDate) {
        this.lunchDate = lunchDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrimKey() {
        return primKey;
    }

    public void setPrimKey(long primKey) {
        this.primKey = primKey;
    }

    private String description;

    private long duration;

    private Date lunchDate;

    private String name;

    private long primKey;

}
