package webapp.event.service;

import webapp.event.dto.EventDTO;

import java.util.List;

public interface EventService {
    Boolean insert(EventDTO eventDTO);
    List<EventDTO> getAllEvent();

    Boolean updateWinner (EventDTO eventDTO);

    Boolean updateSignupNum(EventDTO eventDTO);
    Boolean cancelSignupNum(EventDTO eventDTO);

}