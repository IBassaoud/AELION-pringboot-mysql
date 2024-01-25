package org.myownstock.user.communities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Entity
@Getter @Setter
@Table(name = "user_to_community")

public class UserToCommunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "community_id", nullable = false)
    private Integer communityId;
}
