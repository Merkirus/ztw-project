package org.ztw.charades.Player;

import org.ztw.charades.Exceptions.PlayerExistsEx;
import org.ztw.charades.Exceptions.PlayerNotFoundEx;

import java.util.Collection;

public interface IPlayerService {
    abstract public Player addPlayer(Player player) throws PlayerExistsEx;
    abstract public Collection<Player> getPlayers();
    abstract public Player getPlayer(Long id) throws PlayerNotFoundEx;
    abstract public Player updatePlayer(Long id, Player player) throws PlayerNotFoundEx;
    abstract public Boolean deletePlayer(Long id) throws PlayerNotFoundEx;
}
