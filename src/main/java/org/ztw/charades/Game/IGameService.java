package org.ztw.charades.Game;

import org.springframework.transaction.annotation.Transactional;
import org.ztw.charades.Exceptions.GameExistsEx;
import org.ztw.charades.Exceptions.GameNotFoundEx;

import java.util.Collection;

public interface IGameService {
    @Transactional
    abstract public Game addGame(Game game) throws GameExistsEx;
    abstract public Collection<Game> getGames();
    abstract public Game getGame(Long id) throws GameNotFoundEx;
    @Transactional
    abstract public Game updateGame(Long id, Game game) throws GameNotFoundEx;
    @Transactional
    abstract public Boolean deleteGame(Long id) throws GameNotFoundEx;
}
