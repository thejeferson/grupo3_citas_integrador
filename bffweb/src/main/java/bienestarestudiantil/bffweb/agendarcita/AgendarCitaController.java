package bienestarestudiantil.bffweb.agendarcita;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//VA A ESCUCHAR LAS PETICIONES DEL FRONT O DEL POSTMAN
@RestController
@RequestMapping("api/agendarCita/")
@CrossOrigin({"*"})
public class AgendarCitaController{
    @Autowired AgendarCitaClient client;

    @GetMapping("/")
    public List<AgendarCitaDTO> findAll() {
        return client.findAll();
    }

    @GetMapping("/{id}/")
    public AgendarCitaDTO findById(@PathVariable Long id){
        return client.findById(id);
    }

    @PostMapping("/")
    public AgendarCitaDTO save(@RequestBody AgendarCitaDTO entity){
        return client.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        client.deleteById(id);
    }

    @PutMapping("/{id}/")
    public AgendarCitaDTO update(@PathVariable Long id, @RequestBody AgendarCitaDTO entity){
        return client.update(id, entity);
    }
    @PatchMapping("/{id}/")
    public AgendarCitaDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        AgendarCitaDTO AgendarCitaDTO = client.findById(id);

        // itera sobre los campos que se desean actualizar
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            
            // utiliza reflection para establecer el valor del campo en la entidad
            try {
                Field campoEntidad = AgendarCitaDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(AgendarCitaDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, AgendarCitaDTO);
    }

}
