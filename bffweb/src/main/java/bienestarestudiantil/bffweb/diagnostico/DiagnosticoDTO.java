package bienestarestudiantil.bffweb.diagnostico;

import java.sql.Date;

import lombok.Data;
@Data
public class DiagnosticoDTO {
    private Long id;
    private String sintoma;
    private String diagnostico;
    private Date fechas;
    private String fk_paciente;
    private String fk_medico;
    
   
    
}
