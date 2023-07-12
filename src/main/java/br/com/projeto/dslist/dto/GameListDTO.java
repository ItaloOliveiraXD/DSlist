package br.com.projeto.dslist.dto;

import br.com.projeto.dslist.entities.GameList;

public record GameListDTO(Long id, String name) {

    public GameListDTO(GameList list) {
        this(list.getId(), list.getName());
    }
}
