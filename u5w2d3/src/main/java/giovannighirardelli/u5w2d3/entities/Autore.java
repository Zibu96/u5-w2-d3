package giovannighirardelli.u5w2d3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "autore")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Autore {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private int id;
    private String nome;
    private String cognome;
    private String email;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    private String avatar;
}
