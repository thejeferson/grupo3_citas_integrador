package bienestarestudiantil.bffweb.tratamiento;

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
public class TratamientoController {
    @Autowired TratamientoClient client;

    @GetMapping("/")
    public List<TratamientoDTO> findAll() {
        return client.findAll();
    }

    @GetMapping("/{id}/")
    public TratamientoDTO findById(@PathVariable Long id){
        return client.findById(id);
    }

    @PostMapping("/add")
    public TratamientoDTO save(@RequestBody TratamientoDTO entity){
        return client.save(entity);
    }

    @PutMapping("/update/{id}/")
    public TratamientoDTO update(@PathVariable Long id, @RequestBody TratamientoDTO entity){
        return client.update(id, entity);
    }
   

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        client.deleteById(id);
    }

   
    
}
