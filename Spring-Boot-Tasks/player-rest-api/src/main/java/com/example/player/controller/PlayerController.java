package com.example.player.controller;

import com.example.player.model.Player;
import com.example.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // 1. Save Player
    @PostMapping
    public ResponseEntity<Player> save(@Valid @RequestBody Player player) {
        Player saved = playerService.save(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // 2. Update Player
    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@PathVariable Long id, @Valid @RequestBody Player player) {
        return ResponseEntity.ok(playerService.update(id, player));
    }

    // 3. Get Player By ID
    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id) {
        return playerService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. Delete Player
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
