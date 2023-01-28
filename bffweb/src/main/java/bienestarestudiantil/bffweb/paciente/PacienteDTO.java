package bienestarestudiantil.bffweb.paciente;

import lombok.Data;
@Data
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String curso;
    private String carrera;
    
}
