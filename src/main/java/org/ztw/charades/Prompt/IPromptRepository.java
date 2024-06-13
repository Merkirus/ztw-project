package org.ztw.charades.Prompt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPromptRepository extends JpaRepository<Prompt, Long> {
}
