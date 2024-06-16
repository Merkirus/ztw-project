package org.ztw.charades.Player;

import jakarta.persistence.*;
import org.ztw.charades.Round.Round;
import org.ztw.charades.User.User;

import java.util.Set;

@Entity(name = "player")
@Table(name = "players")
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    private Long id;
    @Column(nullable = true)
    private Integer place;
    @Column(name = "is_drawing", nullable = false)
    private Boolean isDrawing;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "fk_player_user"))
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_round", nullable = false, foreignKey = @ForeignKey(name = "fk_player_round"))
    private Round round;

    public Player() {}

    public Player(Long id, Integer place, Boolean isDrawing) {
        this.id = id;
        this.place = place;
        this.isDrawing = isDrawing;
    }

    public Player(Integer place, Boolean isDrawing) {
        this.place = place;
        this.isDrawing = isDrawing;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public void setDrawing(Boolean drawing) {
        isDrawing = drawing;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getPlace() {
        return place;
    }

    public Boolean getDrawing() {
        return isDrawing;
    }

    public Round getRound() {
        return round;
    }
}
