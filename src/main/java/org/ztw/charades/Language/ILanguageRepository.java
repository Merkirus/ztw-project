package org.ztw.charades.Language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILanguageRepository extends JpaRepository<Language, Long> {
}
