package kz.aitu.chat.service;

import kz.aitu.chat.model.Chat;
import kz.aitu.chat.model.Participant;
import kz.aitu.chat.model.Users;
import kz.aitu.chat.repository.ChatRepository;
import kz.aitu.chat.repository.ParticipantRepository;
import kz.aitu.chat.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    private final ParticipantRepository participantRepository;

    private final UsersRepository usersRepository;


    public List<Users> getAllUsersByChatId(Long id) {
        if (chatRepository.existsById(id)) {
            List<Users> users = new ArrayList<>();
            List<Participant> participants = participantRepository.getAllByChat_id(id);
            participants.forEach(e -> users.add(usersRepository.getById(e.getUser_id())));
            return users;
        }
        throw new NullPointerException("Chat does not exist");
    }

    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    public Chat save(Chat message) {
        return chatRepository.save(message);
    }

    public void deleteById(Long id) {
        chatRepository.deleteById(id);
    }
}
