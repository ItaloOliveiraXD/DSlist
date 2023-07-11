package br.com.projeto.dslist.servicies;

import br.com.projeto.dslist.dto.GameMiniDTO;
import br.com.projeto.dslist.entities.Game;
import br.com.projeto.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMiniDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMiniDTO::new).toList();
    }
}
