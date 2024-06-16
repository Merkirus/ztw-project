package org.ztw.charades.Language;

import jakarta.persistence.*;
import org.ztw.charades.Prompt.Prompt;

import java.util.Set;

@Entity(name = "language")
@Table(name = "languages")
public class Language {
    @Id
    @SequenceGenerator(
            name = "language_sequence",
            sequenceName = "language_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "language_sequence"
    )
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
//    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
//    private Set<Prompt> prompts;

    public Language() {}

    public Language(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Language(String name) {
        this.name = name;
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

//    public Set<Prompt> getPrompts() {
//        return prompts;
//    }
//
//    public void setPrompts(Set<Prompt> prompts) {
//        this.prompts = prompts;
//    }
}
