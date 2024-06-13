package org.ztw.charades.Round;

import jakarta.persistence.*;
import org.ztw.charades.Game.Game;
import org.ztw.charades.Player.Player;
import org.ztw.charades.Prompt.Prompt;
import org.ztw.charades.User.User;

import java.util.Set;

@Entity(name = "round")
@Table
public class Round {
    @Id
    @SequenceGenerator(
            name = "round_sequence",
            sequenceName = "round_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "round_sequence"
    )
    private Long id;
    private Integer order;
    Byte[] image;
    @ManyToOne
    @JoinColumn(name = "id_game")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "id_prompt")
    private Prompt prompt;
    @OneToMany(mappedBy = "round", cascade = CascadeType.ALL)
    private Set<Player> players;

    public Round() {}

    public Round(Long id, Integer order, Byte[] image, Game game, Prompt prompt) {
        this.id = id;
        this.order = order;
        this.image = image;
        this.game = game;
        this.prompt = prompt;
    }

    public Round(Integer order, Byte[] image, Game game, Prompt prompt) {
        this.order = order;
        this.image = image;
        this.game = game;
        this.prompt = prompt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Prompt getPrompt() {
        return prompt;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
