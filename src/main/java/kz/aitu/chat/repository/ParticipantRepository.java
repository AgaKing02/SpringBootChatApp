package kz.aitu.chat.repository;

import kz.aitu.chat.model.Chat;
import kz.aitu.chat.model.Participant;
import kz.aitu.chat.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
@Query("select o from Participant o where o.chat_id=?1")
List<Participant> getAllByChat_id(Long id);

}