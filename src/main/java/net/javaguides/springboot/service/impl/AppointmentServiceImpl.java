package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.dto.AppointmentDto;
import net.javaguides.springboot.entity.Appointment;
import net.javaguides.springboot.repository.AppointmentRepository;
import net.javaguides.springboot.service.AppointmentService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppointmentRepository appointmentRepository;


    @Override
    public String saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
        appointmentRepository.save(appointment);
        return "Saved";
    }

    @Override
    public List<AppointmentDto> getAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        if (appointments.size()>0){
            List<AppointmentDto> appointmentDtoList = modelMapper.map(appointments,new TypeToken<List<AppointmentDto>>(){}.getType());
            return appointmentDtoList;
        }
        else{
            throw new RuntimeException("No Appointments Found");
        }
    }

    @Override
    public void updateAppointments(AppointmentDto appointmentDto) {
        if (appointmentRepository.existsById(appointmentDto.getId())){
            Appointment appointment = modelMapper.map(appointmentDto,Appointment.class);
            appointmentRepository.save(appointment);
        }
        else {
            throw new RuntimeException("No Appointment Found");
        }
    }

    @Override
    public void deleteAppointment(int id) {
        if (appointmentRepository.existsById(id)){
            appointmentRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Appointment Not Found");
        }
    }

    @Override
    public List<Appointment> getAppointmentsByEmail(String email) {
        return appointmentRepository.findByEmail(email);
    }
}

