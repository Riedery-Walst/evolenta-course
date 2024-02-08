package ru.andreev.task15.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.andreev.task15.model.Message;
import ru.andreev.task15.repository.MessageRepository;

import java.util.Optional;

@RestController
public class MessageController {
    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/messages")
    public Iterable<Message> getPersons() {
        return messageRepository.findAll();
    }

    @GetMapping("/messages/{id}")
    public Optional<Message> findMessageById(@PathVariable long id) {
        return messageRepository.findById(id);
    }

    @PostMapping("/messages")
    public Message addMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return message;
    }

    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable long id, @RequestBody Message message) {
        message.setId(id);
        messageRepository.save(message);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/messages/{id}")
    public void deleteMessage(@PathVariable long id) {
        messageRepository.deleteById(id);
    }
}
