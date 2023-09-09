package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDto {

    private int id;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String consultantName;
    private String email;
    private String date;

}
