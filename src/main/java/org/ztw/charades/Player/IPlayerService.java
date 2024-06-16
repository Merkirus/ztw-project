package org.ztw.charades.Player;

import org.springframework.transaction.annotation.Transactional;
import org.ztw.charades.Exceptions.PlayerExistsEx;
import org.ztw.charades.Exceptions.PlayerNotFoundEx;

import java.util.Collection;

public interface IPlayerService {
    @Transactional
    abstract public Player addPlayer(Player player) throws PlayerExistsEx;
    abstract public Collection<Player> getPlayers();
    abstract public Player getPlayer(Long id) throws PlayerNotFoundEx;
    @Transactional
    abstract public Player updatePlayer(Long id, Player player) throws PlayerNotFoundEx;
    @Transactional
    abstract public Boolean deletePlayer(Long id) throws PlayerNotFoundEx;
}
