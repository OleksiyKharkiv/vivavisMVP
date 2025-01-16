package com.example.vivavis.application.service;

import com.example.vivavis.adapter.out.EventRepository;
import com.example.vivavis.application.port.EventServicePort;
import com.example.vivavis.domain.entity.Event;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventServicePort {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(UUID id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(UUID id, Event updatedEvent) {
        Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        existingEvent.setEventType(updatedEvent.getEventType());
        existingEvent.setCreatedAt(updatedEvent.getCreatedAt());
        existingEvent.setSensor(updatedEvent.getSensor());
        return eventRepository.save(existingEvent);
    }

    @Override
    public void deleteEvent(UUID id) {
        eventRepository.deleteById(id);
    }
}