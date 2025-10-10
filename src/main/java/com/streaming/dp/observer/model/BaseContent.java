package com.streaming.dp.observer.model;

import com.streaming.dp.observer.enums.Category;

import java.util.Date;

/**
 * @author Albert Gomes Cabral
 */
public abstract class BaseContent implements Content {

    public Category getCategory() {
        return _category;
    }

    public String getDescription() {
        return _description;
    }

    public int getDuration() {
        return _duration;
    }

    public Date getLaunchDate() {
        return _launchDate;
    }

    public String getName() {
        return _name;
    }

    public long getPrimKey() {
        return _primKey;
    }

    public void setCategory(Category category) {
        _category = category;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    public void setDuration(int duration) {
        this._duration = duration;
    }

    public void setLaunchDate(Date launchDate) {
        this._launchDate = launchDate;
    }

    public void setName(String name) {
        this._name = name;
    }

    public void setPrimKey(long primKey) {
        this._primKey = primKey;
    }

    private Category _category;

    private String _description;

    private int _duration;

    private Date _launchDate;

    private String _name;

    private long _primKey;

}
