package kz.aitu.chat.repository;

import kz.aitu.chat.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
Users getById(Long id);
}
