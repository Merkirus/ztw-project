package org.ztw.charades.Round;

import org.springframework.transaction.annotation.Transactional;
import org.ztw.charades.Exceptions.RoundExistsEx;
import org.ztw.charades.Exceptions.RoundNotFoundEx;

import java.util.Collection;

public interface IRoundService {
    @Transactional
    abstract public Round addRound(Round round) throws RoundExistsEx;
    abstract public Collection<Round> getRounds();
    abstract public Round getRound(Long id) throws RoundNotFoundEx;
    @Transactional
    abstract public Round updateRound(Long id, Round round) throws RoundNotFoundEx;
    @Transactional
    abstract public Boolean deleteRound(Long id) throws RoundNotFoundEx;
}
