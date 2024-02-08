package ru.andreev.task16.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreev.task16.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
