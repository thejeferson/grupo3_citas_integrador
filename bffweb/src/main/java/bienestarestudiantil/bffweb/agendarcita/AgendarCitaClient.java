package bienestarestudiantil.bffweb.agendarcita;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

//URL DEL MICROSERVICIO AL QUE ME QUIERO COMUNICAR
@FeignClient(name = "bff.agendarCita", url = "http://localhost:8080/api/agendarCita/")
public interface AgendarCitaClient {
    @GetMapping("/{id}/")
    AgendarCitaDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<AgendarCitaDTO> findAll();

    @PostMapping("/") 
    AgendarCitaDTO save(AgendarCitaDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id")  Long id);

    @PutMapping("/{id}/")
    AgendarCitaDTO update(@PathVariable("id")  Long id, AgendarCitaDTO entity);

    @PutMapping("/{id}/completardatos/")
    AgendarCitaDTO completardatos(@PathVariable("id")  Long id);

    
}
