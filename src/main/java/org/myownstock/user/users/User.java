package org.myownstock.user.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.myownstock.user.roles.Role;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;


@Entity
@Setter @Getter
@Table(name= "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String lastname;

    @Column(length = 75)
    private String firstname;

    @Column(nullable = false)
    private LocalDate birthdate;

    private Integer gender;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    private Role role;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
