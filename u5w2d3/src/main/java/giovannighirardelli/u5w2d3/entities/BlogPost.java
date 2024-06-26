package giovannighirardelli.u5w2d3.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "blogpost")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogPost {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private int id;
    private String categoria;
    private String cover;
    private String contenuto;
    @Column(name = "tempo_lettura")
    private int tempoLettura;
    @ManyToOne
    @JoinColumn(name = "autore")
    private Autore autore;

}
