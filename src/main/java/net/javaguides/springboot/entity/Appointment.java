package net.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "Id",length = 100,nullable = false)
    private int id;

    @Column(name = "first_name",length = 100,nullable = false)
    private String firstName;

    @Column(name = "last_name",length = 100,nullable = false)
    private String lastName;

    @Column(name = "contact_number",length = 10,nullable = false)
    private String contactNumber;

    @Column(name = "consultant_name",length = 100,nullable = false)
    private String consultantName;

    @Column(name = "date",length = 100,nullable = false)
    private String date;

}
