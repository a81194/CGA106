package webapp.booking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webapp.booking.dto.OpenHourDTO;
import webapp.booking.service.ReservationService;

@RestController
@RequestMapping("/rev")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/ls")
    public List<OpenHourDTO> getAllOpenHour(){
        return reservationService.getAllDTO();
    }
}
