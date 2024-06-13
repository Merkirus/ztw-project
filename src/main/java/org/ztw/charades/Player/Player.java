package org.ztw.charades.Player;

import jakarta.persistence.*;
import org.ztw.charades.Round.Round;
import org.ztw.charades.User.User;

import java.util.Set;

@Entity(name = "player")
@Table
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
    private Integer place;
    private Boolean is_drawing;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_round")
    private Round round;

    public Player() {}

    public Player(Long id, Integer place, Boolean is_drawing) {
        this.id = id;
        this.place = place;
        this.is_drawing = is_drawing;
    }

    public Player(Integer place, Boolean is_drawing) {
        this.place = place;
        this.is_drawing = is_drawing;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIs_drawing(Boolean is_drawing) {
        this.is_drawing = is_drawing;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Boolean getIs_drawing() {
        return is_drawing;
    }

    public Integer getPlace() {
        return place;
    }

    public Round getRound() {
        return round;
    }
}
