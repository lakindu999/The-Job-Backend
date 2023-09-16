package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.ConsultantDto;

import java.util.List;

public interface ConsultantService {
    String saveConsultant(ConsultantDto consultantDto);

    void updateConsultant(ConsultantDto consultantDto);

    void deleteConsultant(int id);

    List<ConsultantDto> getConsultant();

    List<String> getAllConsultantNames();

    List<String> getAllConsultantEmails();
}
