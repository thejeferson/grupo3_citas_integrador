package Administrador.Administrador.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="administradores")
@Getter @Setter
@ToString
@EqualsAndHashCode
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String zone;
    private String email;
    private String phone;
    private String address;


}
