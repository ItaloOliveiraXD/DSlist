package br.com.projeto.dslist.controllers;

import br.com.projeto.dslist.dto.GameListDTO;
import br.com.projeto.dslist.servicies.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> lista() {

        var games = gameListService.findAll();
        return ResponseEntity.ok(games);
    }
}
