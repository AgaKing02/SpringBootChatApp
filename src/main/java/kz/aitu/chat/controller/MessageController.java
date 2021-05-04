package kz.aitu.chat.controller;

import kz.aitu.chat.model.Message;
import kz.aitu.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    @Autowired
    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(messageRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> saveMessage(@RequestBody Message message) {
        return ResponseEntity.ok(messageRepository.save(message));
    }

    @PutMapping
    public ResponseEntity<?> updateMessage(@RequestBody Message message) {
        return ResponseEntity.ok(messageRepository.save(message));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMessage(@RequestParam(name = "id") Long id) {
        try {
            messageRepository.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.ok("Message not found or deleted " + id);
        }
        return ResponseEntity.ok("Message successfully Deleted:");
    }


}
