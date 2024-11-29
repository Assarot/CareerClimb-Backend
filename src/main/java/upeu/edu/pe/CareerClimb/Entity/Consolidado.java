package upeu.edu.pe.CareerClimb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "CONSOLIDADO")
public class Consolidado {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONSOLIDADO")
    @SequenceGenerator(name = "SQ_CONSOLIDADO", sequenceName = "SQ_CONSOLIDADO", allocationSize = 1)
	@Column(name = "idconsolidado",columnDefinition = "NUMBER")
    private Long id;
    private String nombre;
    private String tipo;

    @Lob
    private byte[] data;


    @Column(name = "fecha_subida", nullable = false, updatable = false)
    private LocalDate fechaSubida;

    @PrePersist
    protected void onCreate() {
        this.fechaSubida = LocalDate.now();
    }
    
    @ManyToOne
    @JoinColumn(name = "idppp")
    private PPP ppp;
}
