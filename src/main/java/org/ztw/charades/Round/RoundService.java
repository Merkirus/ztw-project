package org.ztw.charades.Round;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ztw.charades.Exceptions.BadRequestEx;
import org.ztw.charades.Exceptions.RoundExistsEx;
import org.ztw.charades.Exceptions.RoundNotFoundEx;

import java.util.Collection;
import java.util.Objects;

@Service
public class RoundService implements IRoundService {
    private final IRoundRepository roundRepo;

    public RoundService(IRoundRepository roundRepo) {
        this.roundRepo = roundRepo;
    }

    @Override
    @Transactional
    public Round addRound(Round round) throws RoundExistsEx {
        Long _id = round.getId();
        if (roundRepo.findById(_id).isPresent()) {
            throw new RoundExistsEx(_id);
        }
        roundRepo.save(round);
        return roundRepo.findById(_id).orElseThrow(
                () -> new RoundNotFoundEx(_id)
        );
    }

    @Override
    public Collection<Round> getRounds() {
        return roundRepo.findAll();
    }

    @Override
    public Round getRound(Long id) throws RoundNotFoundEx {
        return roundRepo.findById(id).orElseThrow(
                () -> new RoundNotFoundEx(id)
        );
    }

    @Override
    @Transactional
    public Round updateRound(Long id, Round round) throws RoundNotFoundEx {
        if (!Objects.equals(id, round.getId())) {
            throw new BadRequestEx("Wrong URL id and json body id - update");
        }
        Round old_round = roundRepo.findById(id).orElseThrow(
                () -> new RoundNotFoundEx(id)
        );
        old_round.setOrder(round.getOrder());
        old_round.setImage(round.getImage());
        old_round.setGame(round.getGame());
        old_round.setPrompt(round.getPrompt());
//        old_round.setPlayers(round.getPlayers());
        roundRepo.save(old_round);
        return old_round;
    }

    @Override
    @Transactional
    public Boolean deleteRound(Long id) throws RoundNotFoundEx {
        if (roundRepo.findById(id).isEmpty()) {
            throw new RoundNotFoundEx(id);
        }
        roundRepo.deleteById(id);
        return roundRepo.findById(id).isEmpty();
    }
}
