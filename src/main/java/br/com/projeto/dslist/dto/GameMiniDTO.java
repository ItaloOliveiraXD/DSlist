package br.com.projeto.dslist.dto;

import br.com.projeto.dslist.entities.Game;

public record GameMiniDTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {

    public GameMiniDTO(Game game) {
        this(game.getId(), game.getTitle(), game.getYear(), game.getImgUrl(), game.getShortDescription());
    }
}
