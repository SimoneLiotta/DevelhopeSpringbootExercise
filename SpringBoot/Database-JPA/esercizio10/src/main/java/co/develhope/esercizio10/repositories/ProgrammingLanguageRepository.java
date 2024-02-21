package co.develhope.esercizio10.repositories;

import co.develhope.esercizio10.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "repo-prog-languages")
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {
}
