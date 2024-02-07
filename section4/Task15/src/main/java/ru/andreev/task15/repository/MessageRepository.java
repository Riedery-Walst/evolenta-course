package ru.andreev.task15.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreev.task15.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
