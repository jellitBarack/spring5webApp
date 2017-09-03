package varun.springframework.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import varun.springframework.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
