package org.ztw.charades.Round;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoundRepository extends JpaRepository<Round, Long> {
}
