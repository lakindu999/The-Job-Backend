package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {

    String saveAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> getAppointments();

    void updateAppointments(AppointmentDto appointmentDto);

    void deleteAppointment(int id);
}
