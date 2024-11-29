package upeu.edu.pe.CareerClimb.dto;
	
import lombok.Builder;
import lombok.Data;
	
@Data
@Builder
public class ReponseFileDTO {
	   private Long id;
	   private String name;
	   private String url;
	   private String type;
	   private long size;
	   private Long idPPP;
	   private String fechaSubida;
}
