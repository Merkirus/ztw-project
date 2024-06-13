package org.ztw.charades.Game;

import jakarta.persistence.*;
import org.ztw.charades.Player.Player;
import org.ztw.charades.Round.Round;
import org.ztw.charades.User.User;

import java.time.LocalDate;
import java.util.Set;

@Entity(name = "game")
@Table
public class Game {
    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName = "game_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "game_sequence"
    )
    private Long id;
    private LocalDate date;
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<Round> rounds;

    public Game() {}

    public Set<Round> getRounds() {
        return rounds;
    }

    public void setRounds(Set<Round> rounds) {
        this.rounds = rounds;
    }

    public Game(Long id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public Game(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
