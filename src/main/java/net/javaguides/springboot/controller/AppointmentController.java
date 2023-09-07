package net.javaguides.springboot.controller;


import net.javaguides.springboot.dto.AppointmentDto;
import net.javaguides.springboot.service.AppointmentService;
import net.javaguides.springboot.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointment")
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

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

}

