package bienestarestudiantil.bffweb.agendarcita;

import lombok.Data;

@Data
public class AgendarCitaDTO {
    private Long id;
    private Number noCita;
    private String fecha;
    private String hora; 
}
