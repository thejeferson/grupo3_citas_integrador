package bienestarestudiantil.bffweb.tratamiento;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.tratamiento", url = "http://127.0.0.1:5003/api/tratamiento/")
public interface TratamientoClient {


    @GetMapping("/")
    List<TratamientoDTO> findAll();

    @GetMapping("/{id}/")
    TratamientoDTO findById(@PathVariable("id") Long id);

    @PostMapping("/add")
    TratamientoDTO save(TratamientoDTO entity);

    @PutMapping("/update/{id}/")
    TratamientoDTO update(@PathVariable("id") Long id, TratamientoDTO entity);

    @DeleteMapping("/delete/{id}/")
    void deleteById(@PathVariable("id") Long id);

}