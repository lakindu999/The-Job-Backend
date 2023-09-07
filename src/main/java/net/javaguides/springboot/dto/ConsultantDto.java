package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultantDto {

    private int id;
    private String consultantName;
    private String email;
    private String password;
    private int consultantNumber;
    private String specializedCountry;
    private String availableDay;
    private String timeSlot;
}
