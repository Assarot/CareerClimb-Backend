package upeu.edu.pe.CareerClimb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "REFRESH_TOKEN")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_REFRESH_TOKEN")
    @SequenceGenerator(name = "SQ_REFRESH_TOKEN", sequenceName = "SQ_REFRESH_TOKEN", allocationSize = 1)
    @Column(name = "id_token", columnDefinition = "NUMBER")
    private Long id;

    @Column(name = "token", columnDefinition = "varchar2(500)", nullable = false)
    private String token;

    @Column(name = "expiry_date", columnDefinition = "DATE", nullable = false)
    private Date expiryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;
}
