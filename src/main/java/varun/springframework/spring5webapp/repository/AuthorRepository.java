package varun.springframework.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import varun.springframework.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
