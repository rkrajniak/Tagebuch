package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.TagebuchService;
import de.htwberlin.webtech.web.api.Tagebuch;
import de.htwberlin.webtech.web.api.TagebuchManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TagebuchRestController {
    private final TagebuchService tagebuchService;
    public TagebuchRestController(TagebuchService tagebuchService){ this.tagebuchService = tagebuchService;}

    @GetMapping(path = "/api/v1/tagebuch")
    public ResponseEntity<List<Tagebuch>> fetchTagebuch(){
        return ResponseEntity.ok(tagebuchService.findAll());
    }

    @GetMapping(path = "/api/v1/tagebuch/{id}")
    public ResponseEntity<Tagebuch>fetchTagebuchById(@PathVariable Long id){
        var tagebuch = tagebuchService.findByID(id);
        return tagebuch != null? ResponseEntity.ok(tagebuch):ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/tagebuch")
    public ResponseEntity<Void>createTagebuch(@RequestBody TagebuchManipulationRequest request) throws URISyntaxException {
        var tagebuch = tagebuchService.create(request);
        URI uri = new URI("/api/v1/tagebuch/" + tagebuch.getId());
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(path = "/api/v1/tagebuch/{id}")
    public ResponseEntity<Tagebuch> updateTagebuch(@PathVariable Long id, @RequestBody TagebuchManipulationRequest request){
        var tagebuch = tagebuchService.update(id, request);
        return tagebuch != null? ResponseEntity.ok(tagebuch):ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/tagebuch/{id}")
    public ResponseEntity<Void> deleteTagebuch(@PathVariable Long id){
        boolean successful = tagebuchService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
