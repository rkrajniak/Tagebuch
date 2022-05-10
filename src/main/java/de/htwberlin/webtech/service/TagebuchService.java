package de.htwberlin.webtech.service;


import de.htwberlin.webtech.persistence.Rating;
import de.htwberlin.webtech.persistence.TagebuchEntity;
import de.htwberlin.webtech.persistence.TagebuchRepository;

import de.htwberlin.webtech.web.api.Tagebuch;
import de.htwberlin.webtech.web.api.TagebuchManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagebuchService {

    private final TagebuchRepository tagebuchRepository;
    public TagebuchService(TagebuchRepository tagebuchRepository){
        this.tagebuchRepository = tagebuchRepository;}

    public List<Tagebuch> findAll(){
        List<TagebuchEntity> tagebuch = tagebuchRepository.findAll();
        return tagebuch.stream().map(this::transformEntity).collect(Collectors.toList());

    }
    public Tagebuch findByID(Long id){
        var tagebuchEntity = tagebuchRepository.findById(id);
        return tagebuchEntity.map(this::transformEntity).orElse(null);
    }

    public Tagebuch create(TagebuchManipulationRequest request){
        var tagebuchEntity = new TagebuchEntity(request.getAuthor(), request.getDatum(), request.getErlebnis(), Rating.valueOf(request.getRating()));
        tagebuchEntity = tagebuchRepository.save(tagebuchEntity);
        return transformEntity(tagebuchEntity);
    }

    public Tagebuch update (Long id, TagebuchManipulationRequest request){
        var tagebuchEntityOptional = tagebuchRepository.findById(id);
        if(tagebuchEntityOptional.isEmpty()){
            return null;
        }
        var tagebuchEntity = tagebuchEntityOptional.get();
        tagebuchEntity.setAuthor(request.getAuthor());
        tagebuchEntity.setDatum(request.getDatum());
        tagebuchEntity.setErlebnis(request.getErlebnis());
        tagebuchEntity.setRating(Rating.valueOf(request.getRating()));
        tagebuchEntity = tagebuchRepository.save(tagebuchEntity);
        return transformEntity(tagebuchEntity);
    }

    public boolean deleteById(Long id){
        if(!tagebuchRepository.existsById(id)){
            return false;
        }
        tagebuchRepository.deleteById(id);
        return true;
    }

    private Tagebuch transformEntity(TagebuchEntity tagebuchEntity) {
        var rating = tagebuchEntity.getRating() != null ?
                tagebuchEntity.getRating().name() : Rating.UNKNOWN.name();

        return new Tagebuch(
                tagebuchEntity.getId(),
                tagebuchEntity.getAuthor(),
                tagebuchEntity.getDatum(),
                tagebuchEntity.getErlebnis(),
                rating
        );
    }
}
