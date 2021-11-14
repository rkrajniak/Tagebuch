package de.htwberlin.webtech.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagebuchRepository extends JpaRepository<TagebuchEntity, Long> {
    List<TagebuchEntity> findErlebenisByAuthor(String author);
}
