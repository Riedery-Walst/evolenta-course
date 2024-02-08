package ru.andreev.task16.service;

import org.springframework.stereotype.Service;
import ru.andreev.task16.exception.MessageNotFoundException;
import ru.andreev.task16.model.Message;
import ru.andreev.task16.repository.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Iterable<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("Message not found."));
    }

    public Message updateMessage(Long id, Message message) {
        Message messageExists = messageRepository.findById(id).orElseThrow(() -> new MessageNotFoundException("Message not found"));

        message.setId(messageExists.getId());
        message.setPerson(messageExists.getPerson());
        message.setTime(messageExists.getTime());

        return messageRepository.save(message);
    }

}
