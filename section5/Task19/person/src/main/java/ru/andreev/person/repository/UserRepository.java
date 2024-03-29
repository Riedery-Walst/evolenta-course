package ru.andreev.person.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreev.person.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}