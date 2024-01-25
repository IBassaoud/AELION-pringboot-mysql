package org.myownstock.user.communities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.myownstock.user.cities.City;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter @Setter
@Table(name = "community")
public class Community implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label", length = 150, nullable = false)
    private String label;

    @Column(length = 10)
    private String streetNumber;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "address_detail", length = 50)
    private String addressDetail;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    private City city;
}
