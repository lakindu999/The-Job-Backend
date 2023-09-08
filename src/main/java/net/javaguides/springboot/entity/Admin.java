package net.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name =  "Admin")
public class Admin {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String password;

}
