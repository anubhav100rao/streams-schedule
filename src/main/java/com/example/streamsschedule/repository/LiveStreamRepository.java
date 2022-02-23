package com.example.streamsschedule.repository;

import com.example.streamsschedule.model.LiveStream;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class LiveStreamRepository {
    List<LiveStream> streams = new ArrayList<>();
    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Building Rest Api with Spring Boot",
                """
                        In this session, we will learn how to build a REST API with Spring Boot. 
                           We will learn how to create a REST API with Spring Boot, and how to use Spring Boot to build a REST API.
                         We will also learn how to use Spring Boot to build a REST API with Swagger.
                         """,
                "https://www.twitch.tv/videos/284801071",
                LocalDateTime.of(2022, 2, 16, 11, 0),
                LocalDateTime.of(2022, 2, 16, 12, 0)
        ));
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findById(String id) {
        return streams.stream().filter(stream -> stream.id().equals(id)).findFirst().orElse(null);
    }

    public LiveStream save(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public boolean update(String id, LiveStream stream) {
        var s = streams.stream().filter(s1 -> s1.id().equals(id)).findFirst().orElse(null);
        if(s == null) {
            return false;
        }
        streams.replaceAll(s1 -> s1.id().equals(id) ? stream : s1);
        return true;
    }

    public void delete(String id) {
        streams.removeIf(stream -> stream.id().equals(id));
    }
}
