package bienestarestudiantil.bffweb.diagnostico;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.diagnostico", url = "http://127.0.0.1:5003/api/diagnostico/")
public interface DiagnosticoClient {


    @GetMapping("/")
    List<DiagnosticoDTO> findAll();

    @GetMapping("/{id}/")
    DiagnosticoDTO findById(@PathVariable("id") Long id);

    @PostMapping("/add")
    DiagnosticoDTO save(DiagnosticoDTO entity);

    @PutMapping("/update/{id}/")
    DiagnosticoDTO update(@PathVariable("id") Long id, DiagnosticoDTO entity);

    @DeleteMapping("/delete/{id}/")
    void deleteById(@PathVariable("id") Long id);

}
