package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.dto.ConsultantDto;
import net.javaguides.springboot.entity.Consultant;
import net.javaguides.springboot.repository.ConsultantRepository;
import net.javaguides.springboot.service.ConsultantService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultantServiceImpl implements ConsultantService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConsultantRepository consultantRepository;

    @Override
    public String saveConsultant(ConsultantDto consultantDto) {
        Consultant consultant = modelMapper.map(consultantDto, Consultant.class);
        consultantRepository.save(consultant);
        return "Saved";
    }

    @Override
    public void updateConsultant(ConsultantDto consultantDto) {
        if (consultantRepository.existsById(consultantDto.getId())){
            Consultant consultant = modelMapper.map(consultantDto,Consultant.class);
            consultantRepository.save(consultant);
        }
        else {
            throw new RuntimeException("No Consultant Found");
        }
    }

    @Override
    public void deleteConsultant(int id) {
        if (consultantRepository.existsById(id)){
            consultantRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Consultant Not Found");
        }
    }

    @Override
    public List<ConsultantDto> getConsultant() {
        List<Consultant> consultants = consultantRepository.findAll();
        if (consultants.size()>0){
            List<ConsultantDto> consultantDtoList = modelMapper.map(consultants,new TypeToken<List<ConsultantDto>>(){}.getType());
            return consultantDtoList;
        }
        else{
            throw new RuntimeException("No Consultants Found");
        }
    }

    @Override
    public List<String> getAllConsultantNames() {
        List<Consultant> consultants = consultantRepository.findAll();
        return consultants.stream()
                .map(Consultant::getConsultantName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllConsultantEmails() {
        List<Consultant> consultants = consultantRepository.findAll();
        return consultants.stream()
                .map(Consultant::getEmail)
                .collect(Collectors.toList());
    }
}
