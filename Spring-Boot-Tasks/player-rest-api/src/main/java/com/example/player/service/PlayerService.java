package com.example.player.service;

import com.example.player.model.Player;

import java.util.Optional;

public interface PlayerService {
    Player save(Player player);
    Player update(Long id, Player player);
    Optional<Player> getById(Long id);
    void delete(Long id);
}
