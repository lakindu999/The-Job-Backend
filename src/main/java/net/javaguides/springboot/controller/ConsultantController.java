package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.ConsultantDto;
import net.javaguides.springboot.service.ConsultantService;
import net.javaguides.springboot.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultant")
@CrossOrigin
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveConsultant(@RequestBody ConsultantDto consultantDto){
        consultantService.saveConsultant(consultantDto);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Saved", consultantDto), HttpStatus.CREATED);
        return responseEntity;
    }
    @PutMapping(path = "/update")
    public  ResponseEntity<StandardResponse> updateConsultant(@RequestBody ConsultantDto consultantDto){
        consultantService.updateConsultant(consultantDto);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Updated",consultantDto),HttpStatus.OK);
        return responseEntity;

    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<StandardResponse> deleteConsultant(@PathVariable int id){
        consultantService.deleteConsultant(id);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted",id),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path = "/view-all")
    public ResponseEntity<StandardResponse> viewConsultant(){
        List<ConsultantDto> allConsultant = consultantService.getConsultant();
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Consultants Successfully Viewed ",allConsultant),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path = "/view-names")
    public ResponseEntity<List<String>> getAllConsultantNames() {
        List<String> consultantNames = consultantService.getAllConsultantNames();
        return ResponseEntity.ok(consultantNames);
    }

    @GetMapping(path = "/view-emails")
    public ResponseEntity<List<String>> getAllConsultantEmails() {
        List<String> consultantEmails = consultantService.getAllConsultantEmails();
        return ResponseEntity.ok(consultantEmails);
    }

}
