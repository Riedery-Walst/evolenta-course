package ru.andreev.task16.service;

import org.springframework.stereotype.Service;
import ru.andreev.task16.exception.MessageNotFoundException;
import ru.andreev.task16.exception.PersonNotFoundException;
import ru.andreev.task16.model.Message;
import ru.andreev.task16.model.Person;
import ru.andreev.task16.repository.MessageRepository;
import ru.andreev.task16.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final MessageRepository messageRepository;

    public PersonService(PersonRepository personRepository, MessageRepository messageRepository) {
        this.personRepository = personRepository;
        this.messageRepository = messageRepository;
    }

    public Person updatePerson(Long id, Person person) {
        Person existingPerson = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found"));

        person.setId(id);
        person.setMessages(existingPerson.getMessages());

        personRepository.save(person);

        return person;
    }

    public Person addPerson(Person person) {
        List<Message> messages = new ArrayList<>();
        person.setMessages(messages);
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found"));

        personRepository.delete(person);
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found"));
    }

    public Iterable<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person addMessageToPerson(Long personId, Message message) {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            message.setPerson(person);
            message.setTime(LocalDateTime.now());
            person.addMessage(message);
            return personRepository.save(person);
        } else throw new PersonNotFoundException("Person with not found");
    }

    public void deleteMessageFromPerson(Long personId, Long messageId) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException("Person not found"));

        boolean messageExists = person.getMessages().stream().anyMatch(message -> message.getId().equals(messageId));

        if (messageExists) {
            person.getMessages().removeIf(message -> message.getId().equals(messageId));
        } else {
            throw new MessageNotFoundException("Message not found with id: " + messageId);
        }

        personRepository.save(person);
    }

    public List<Message> getMessagesFromPerson(Long personId) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException("Person not found"));

        if (!person.getMessages().isEmpty()) {
            return person.getMessages();
        } else throw new MessageNotFoundException("Messages not found");
    }


}

