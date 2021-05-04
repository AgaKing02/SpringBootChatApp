package kz.aitu.chat.repository;

import kz.aitu.chat.model.Chat;
import kz.aitu.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}