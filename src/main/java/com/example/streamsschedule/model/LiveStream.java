package com.example.streamsschedule.model;

import java.time.LocalDateTime;

public record LiveStream(String id, String title, String description, String url, LocalDateTime startDate, LocalDateTime endDate) {
    @Override
    public String id() {
        return id;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public LocalDateTime startDate() {
        return startDate;
    }

    @Override
    public LocalDateTime endDate() {
        return endDate;
    }
}
