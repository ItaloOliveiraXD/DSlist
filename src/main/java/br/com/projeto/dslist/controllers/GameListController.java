package br.com.projeto.dslist.controllers;

import br.com.projeto.dslist.dto.GameListDTO;
import br.com.projeto.dslist.dto.GameMiniDTO;
import br.com.projeto.dslist.servicies.GameListService;
import br.com.projeto.dslist.servicies.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> lista() {

        var games = gameListService.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{listID}/games")
    public ResponseEntity<List<GameMiniDTO>> findByList(@PathVariable Long listID) {

        var games = gameService.findByList(listID);
        return ResponseEntity.ok(games);
    }
}
