package kz.aitu.chat.controller;

import kz.aitu.chat.model.Chat;
import kz.aitu.chat.model.Users;
import kz.aitu.chat.repository.ChatRepository;
import kz.aitu.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/chats")
public class ChatController {
    @Autowired
    private final ChatRepository chatRepository;
    @Autowired
    private final ChatService chatService;

    public ChatController(ChatRepository chatRepository, ChatService chatService) {
        this.chatRepository = chatRepository;
        this.chatService = chatService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(chatRepository.findAll());
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<?> getAllUsersByChatID(@PathVariable(name = "id") Long id) {
        try{
            List<Users> usersList=chatService.getAllUsersByChatId(id);
            return ResponseEntity.ok(usersList);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Chat does not exist "+id);
        }
    }


    @PostMapping
    public ResponseEntity<?> saveChat(@RequestBody Chat message) {
        return ResponseEntity.ok(chatRepository.save(message));
    }


    @PutMapping
    public ResponseEntity<?> updateChat(@RequestBody Chat message) {
        return ResponseEntity.ok(chatRepository.save(message));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteChat(@RequestParam(name = "id") Long id) {
        try {
            chatRepository.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.ok("Chat not found or deleted " + id);
        }
        return ResponseEntity.ok("Chat successfully Deleted:");
    }


}
