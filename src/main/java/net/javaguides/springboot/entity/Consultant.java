package net.javaguides.springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "consultant")
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", length = 100, nullable = false)
    private int id;

    @Column(name = "consultant_name", length = 100, nullable = false)
    private String consultantName;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "consultant_number", length = 15, nullable = false)
    private int consultantNumber;

    @Column(name = "specialized_country", length = 100, nullable = false)
    private String specializedCountry;

    @Column(name = "available_day", length = 100, nullable = false)
    private String availableDay;

    @Column(name = "time_slot", length = 100, nullable = false)
    private String timeSlot;

}
