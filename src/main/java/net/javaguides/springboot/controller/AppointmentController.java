package net.javaguides.springboot.controller;


import net.javaguides.springboot.dto.AppointmentDto;
import net.javaguides.springboot.entity.Appointment;
import net.javaguides.springboot.repository.AppointmentRepository;
import net.javaguides.springboot.service.AppointmentService;
import net.javaguides.springboot.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveAppointment(@RequestBody AppointmentDto appointmentDto){
        appointmentService.saveAppointment(appointmentDto);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Saved", appointmentDto), HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping(path = "/view-all")
    public ResponseEntity<StandardResponse> viewAppointments(){
        List<AppointmentDto> allAppointments = appointmentService.getAppointments();
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Appointments Successfully Viewed ",allAppointments),HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping(path = "/update")
    public  ResponseEntity<StandardResponse> updateAppointments(@RequestBody AppointmentDto appointmentDto){
        appointmentService.updateAppointments(appointmentDto);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Updated",appointmentDto),HttpStatus.OK);
        return responseEntity;

    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<StandardResponse> deleteAppointment(@PathVariable int id){
        appointmentService.deleteAppointment(id);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted",id),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path = "/view-appointments")
    public ResponseEntity<List<Appointment>> viewAppointmentsForConsultant(HttpServletRequest request) {
        // Obtain the consultant's name from the session, token, or any other source
        String email = (String) request.getAttribute("email"); // Replace with your actual logic

        List<Appointment> consultantAppointments = appointmentRepository.findByEmail(email);

        return ResponseEntity.ok(consultantAppointments);
    }


    @PostMapping("/consultant-email/{email}")
    public List<Appointment> filterByCounsultEmail(@PathVariable String email) {

        return appointmentRepository.findAppointmentByEmail(email);
    }

    @PostMapping("/user-email/{lastName}")
    public List<Appointment> findAppointmentByLastName(@PathVariable String lastName) {

        return appointmentRepository.findAppointmentByLastName(lastName);
    }

}
