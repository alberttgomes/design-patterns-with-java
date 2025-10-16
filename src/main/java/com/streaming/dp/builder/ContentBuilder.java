package com.streaming.dp.builder;

import com.streaming.dp.factory.ContentFactory;
import com.streaming.dp.enums.Category;
import com.streaming.dp.model.BaseContent;
import com.streaming.dp.model.Content;
import com.streaming.dp.model.Movie;
import com.streaming.dp.model.Series;

import java.util.Date;
import java.util.Map;

/**
 * @author Albert Gomes Cabral
 */
public class ContentBuilder {

    public Content build() {
        Content content = ContentFactory.create(_type);

        if (content instanceof BaseContent base) {
            base.setCategory(_category);
            base.setDescription(_description);
            base.setDuration(_duration);
            base.setLaunchDate(_launchDate);
            base.setName(_name);
            base.setPrimKey(_primKey);

            if (content instanceof Series series) {
                series.setSession(_chapters, _sessionNumber);
            }
            else if (content instanceof Movie movie) {
                movie.setAttributes(_attributes);

                if (_authored != null && _awards != null) {
                    movie.setProduction(_authored, _awards);
                }
            }

            return content;
        }

        return new Movie();
    }

    public ContentBuilder setAuthored(String authored) {
        _authored = authored;

        return this;
    }

    public ContentBuilder setAttributes(Map<String, Object> attributes) {
        _attributes = attributes;

        return this;
    }

    public ContentBuilder setAwards(Map<Integer, String> awards) {
        _awards = awards;

        return this;
    }

    public ContentBuilder setCategory(Category category) {
        _category = category;

        return this;
    }

    public ContentBuilder setChapters(int chapters) {
        _chapters = chapters;

        return this;
    }

    public ContentBuilder setDescription(String description) {
        _description = description;

        return this;
    }

    public ContentBuilder setDuration(int duration) {
        _duration = duration;

        return this;
    }

    public ContentBuilder setLaunchDate(Date launchDate) {
        _launchDate = launchDate;

        return this;
    }

    public ContentBuilder setName(String name) {
        _name = name;

        return this;
    }

    public ContentBuilder setPrimKey(long primKey) {
        _primKey = primKey;

        return this;
    }

    public ContentBuilder setSessionNumber(int sessionNumber) {
        _sessionNumber = sessionNumber;

        return this;
    }

    public ContentBuilder setType(String type) {
        _type = type;

        return this;
    }

    private String _authored;

    private Map<String, Object> _attributes;

    private Map<Integer, String> _awards;

    private Category _category;

    private int _chapters;

    private String _description;

    private int _duration;

    private Date _launchDate;

    private String _name;

    private long _primKey;

    private int _sessionNumber;

    private String _type;

}
