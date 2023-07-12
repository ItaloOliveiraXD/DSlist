package br.com.projeto.dslist.controllers;

import br.com.projeto.dslist.dto.GameDTO;
import br.com.projeto.dslist.dto.GameMiniDTO;
import br.com.projeto.dslist.servicies.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMiniDTO>> lista() {

        var games = gameService.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> verGame(@PathVariable Long id) {
        var game = gameService.getById(id);
        return ResponseEntity.ok(game);
    }
}
