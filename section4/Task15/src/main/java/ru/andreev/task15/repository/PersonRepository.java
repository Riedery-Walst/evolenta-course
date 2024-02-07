package ru.andreev.task15.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreev.task15.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
