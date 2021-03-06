package kz.aitu.chat.repository;

import kz.aitu.chat.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
  Chat getById(Long id);
}
