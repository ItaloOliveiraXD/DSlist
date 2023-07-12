package br.com.projeto.dslist.servicies;

import br.com.projeto.dslist.dto.GameDTO;
import br.com.projeto.dslist.dto.GameMiniDTO;
import br.com.projeto.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO getById(Long gameId) {
        var game = gameRepository.findById(gameId).orElseThrow();
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMiniDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMiniDTO::new).toList();
    }
}
