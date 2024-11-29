package upeu.edu.pe.CareerClimb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDocDTO {
    private Long id;       // ID del documento
    private String nombre; // Nombre del archivo
    private String tipo;   // Tipo de archivo (MIME type)
    private String ruta;   // Ruta del archivo
}
