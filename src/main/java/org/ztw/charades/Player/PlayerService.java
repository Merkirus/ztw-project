package org.ztw.charades.Player;

import org.springframework.stereotype.Service;
import org.ztw.charades.Exceptions.PlayerExistsEx;
import org.ztw.charades.Exceptions.PlayerNotFoundEx;

import java.util.Collection;

@Service
public class PlayerService implements IPlayerService {
    private final IPlayerRepository playerRepo;

    public PlayerService(IPlayerRepository playerRepo) {
        this.playerRepo = playerRepo;
    }

    @Override
    public Player addPlayer(Player player) throws PlayerExistsEx {
        Long _id = player.getId();
        if (playerRepo.findById(_id).isPresent()) {
            throw new PlayerExistsEx(_id);
        }
        playerRepo.save(player);
        return playerRepo.findById(_id).orElseThrow(
                () -> new PlayerNotFoundEx(_id)
        );
    }

    @Override
    public Collection<Player> getPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public Player getPlayer(Long id) throws PlayerNotFoundEx {
        return playerRepo.findById(id).orElseThrow(
                () -> new PlayerNotFoundEx(id)
        );
    }

    @Override
    public Player updatePlayer(Long id, Player player) throws PlayerNotFoundEx {
        Player old_player = playerRepo.findById(id).orElseThrow(
                () -> new PlayerNotFoundEx(id)
        );
        old_player.setPlace(player.getPlace());
        old_player.setIs_drawing(player.getIs_drawing());
        old_player.setUser(player.getUser());
        old_player.setRound(player.getRound());
        return old_player;
    }

    @Override
    public Boolean deletePlayer(Long id) throws PlayerNotFoundEx {
        if (playerRepo.findById(id).isEmpty()) {
            throw new PlayerNotFoundEx(id);
        }
        playerRepo.deleteById(id);
        return playerRepo.findById(id).isEmpty();
    }
}
