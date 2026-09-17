package com.example.player.service;

import com.example.player.model.Player;
import com.example.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player update(Long id, Player player) {
        Player existing = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id: " + id));
        existing.setName(player.getName());
        existing.setAge(player.getAge());
        existing.setStatus(player.isStatus());
        return playerRepository.save(existing);
    }

    @Override
    public Optional<Player> getById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        if (!playerRepository.existsById(id)) {
            throw new EntityNotFoundException("Player not found with id: " + id);
        }
        playerRepository.deleteById(id);
    }
}
