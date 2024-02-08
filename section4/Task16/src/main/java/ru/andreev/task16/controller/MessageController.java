package ru.andreev.task16.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.andreev.task16.exception.MessageNotFoundException;
import ru.andreev.task16.model.Message;
import ru.andreev.task16.service.MessageService;

@RestController
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public Iterable<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id) {
        try {
            Message message = messageService.getMessageById(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (MessageNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message message) {
        try {
            Message updateMessage = messageService.updateMessage(id, message);
            return new ResponseEntity<>(updateMessage, HttpStatus.OK);
        } catch (MessageNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
