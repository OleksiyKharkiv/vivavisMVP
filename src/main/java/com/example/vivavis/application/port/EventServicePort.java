package com.example.vivavis.application.port;

import com.example.vivavis.domain.entity.Event;

import java.util.List;
import java.util.UUID;

public interface EventServicePort {
    List<Event> getAllEvents();

    Event getEventById(UUID id);

    Event createEvent(Event event);

    Event updateEvent(UUID id, Event updatedEvent);

    void deleteEvent(UUID id);
}