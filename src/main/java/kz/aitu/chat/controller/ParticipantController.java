package kz.aitu.chat.controller;

import kz.aitu.chat.model.Participant;
import kz.aitu.chat.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/participants")
public class ParticipantController {

    @Autowired
    private final ParticipantRepository participantRepository;

    public ParticipantController(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(participantRepository.findAll());
    }


    @PostMapping
    public ResponseEntity<?> saveParticipant(@RequestBody Participant user) {
        return ResponseEntity.ok(participantRepository.save(user));
    }

    @PutMapping
    public ResponseEntity<?> updateParticipant(@RequestBody Participant user) {
        return ResponseEntity.ok(participantRepository.save(user));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteParticipant(@RequestParam(name = "id") Long id) {
        try {
            participantRepository.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.ok("Participant not found or deleted " + id);
        }
        return ResponseEntity.ok("Participant successfully Deleted:");
    }

}
