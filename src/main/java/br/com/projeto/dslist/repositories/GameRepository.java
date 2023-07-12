package br.com.projeto.dslist.repositories;

import br.com.projeto.dslist.entities.Game;
import br.com.projeto.dslist.projections.GameMiniProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tb_games.id, tb_games.title, tb_games.game_year AS `year`, tb_games.img_url AS imgUrl,
            	tb_games.short_description AS shortDescription, tb_belonging.position
            FROM tb_games
            INNER JOIN tb_belonging ON tb_games.id  = tb_belonging.game_id
            WHERE tb_belonging.list_id = :listID
            ORDER BY tb_belonging.position
            """)
    List<GameMiniProjection> searchByList(Long listID);
}
