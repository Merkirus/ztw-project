package org.ztw.charades.Prompt;

import jakarta.persistence.*;
import org.ztw.charades.Language.Language;

@Entity(name = "prompt")
@Table(name = "prompts",
        uniqueConstraints = { @UniqueConstraint(name = "uk_prompt_name_language" ,columnNames = {"name","id_language"}) }
)
public class Prompt {
    @Id
    @SequenceGenerator(
            name = "prompt_sequence",
            sequenceName = "prompt_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "prompt_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_language", nullable = false, foreignKey = @ForeignKey(name = "fk_prompt_language"))
    private Language language;

    public Prompt() {}

    public Prompt(Long id, String name, Language language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }

    public Prompt(String name, Language language) {
        this.name = name;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
