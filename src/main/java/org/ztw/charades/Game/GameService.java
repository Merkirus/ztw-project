package org.ztw.charades.Game;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ztw.charades.Exceptions.BadRequestEx;
import org.ztw.charades.Exceptions.GameExistsEx;
import org.ztw.charades.Exceptions.GameNotFoundEx;

import java.util.Collection;
import java.util.Objects;

@Service
public class GameService implements IGameService {
    private final IGameRepository gameRepo;

    public GameService(IGameRepository gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Override
    @Transactional
    public Game addGame(Game game) throws GameExistsEx {
        Long _id = game.getId();
        if (gameRepo.findById(_id).isPresent()) {
            throw new GameExistsEx(_id);
        }
        gameRepo.save(game);
        return gameRepo.findById(_id).orElseThrow(
                () -> new GameNotFoundEx(_id)
        );
    }

    @Override
    public Collection<Game> getGames() {
        return gameRepo.findAll();
    }

    @Override
    public Game getGame(Long id) throws GameNotFoundEx {
        return gameRepo.findById(id).orElseThrow(
                () -> new GameNotFoundEx(id)
        );
    }

    @Override
    @Transactional
    public Game updateGame(Long id, Game game) throws GameNotFoundEx {
        if (!Objects.equals(id, game.getId())) {
            throw new BadRequestEx("Wrong URL id and json body id - update");
        }
        Game old_game = gameRepo.findById(id).orElseThrow(
                () -> new GameNotFoundEx(id)
        );
        old_game.setDate(game.getDate());
        gameRepo.save(old_game);
        return old_game;
    }

    @Override
    @Transactional
    public Boolean deleteGame(Long id) throws GameNotFoundEx {
        if (gameRepo.findById(id).isEmpty()) {
            throw new GameNotFoundEx(id);
        }
        gameRepo.deleteById(id);
        return gameRepo.findById(id).isEmpty();
    }
}
