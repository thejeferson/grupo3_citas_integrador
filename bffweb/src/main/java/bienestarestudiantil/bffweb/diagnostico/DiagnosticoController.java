package bienestarestudiantil.bffweb.diagnostico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/tratamiento/")
@CrossOrigin({"*"})
public class DiagnosticoController {
    @Autowired DiagnosticoClient client;

    @GetMapping("/")
    public List<DiagnosticoDTO> findAll() {
        return client.findAll();
    }

    @GetMapping("/{id}/")
    public DiagnosticoDTO findById(@PathVariable Long id){
        return client.findById(id);
    }

    @PostMapping("/add")
    public DiagnosticoDTO save(@RequestBody DiagnosticoDTO entity){
        return client.save(entity);
    }

    @PutMapping("/update/{id}/")
    public DiagnosticoDTO update(@PathVariable Long id, @RequestBody DiagnosticoDTO entity){
        return client.update(id, entity);
    }
   

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        client.deleteById(id);
    }

   
    
}
