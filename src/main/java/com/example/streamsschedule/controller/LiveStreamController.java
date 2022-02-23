package com.example.streamsschedule.controller;

import com.example.streamsschedule.model.LiveStream;
import com.example.streamsschedule.repository.LiveStreamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }


    // http://localhost:8080/streams/
    @GetMapping
    public List<LiveStream> findAll() {
        return repository.findAll();
    }

    // http://localhost:8080/streams/
    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id) {
        return repository.findById(id);
    }

    // POST http://localhost:8080/streams/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@RequestBody LiveStream stream) {
        return repository.save(stream);
    }



    // PUT http://localhost:8080/streams/
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody LiveStream stream, @PathVariable String id) {
        if(!repository.update(id, stream)) {
            repository.save(stream);
        }
    }

    // DELETE http://localhost:8080/streams/
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}