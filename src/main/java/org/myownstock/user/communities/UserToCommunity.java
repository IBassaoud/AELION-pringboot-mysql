package org.myownstock.user.communities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.myownstock.user.users.User;

@Entity
@Getter @Setter
@Table(name = "user_to_community")

public class UserToCommunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;
}
