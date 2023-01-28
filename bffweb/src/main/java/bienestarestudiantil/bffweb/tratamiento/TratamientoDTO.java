package bienestarestudiantil.bffweb.tratamiento;

import java.sql.Date;

import lombok.Data;
@Data
public class TratamientoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private String fk_paciente;
    private String fk_medico;
    private String fk_sintoma;
   
    
}
