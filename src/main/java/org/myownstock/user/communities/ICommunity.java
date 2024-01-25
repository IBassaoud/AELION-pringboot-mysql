package org.myownstock.user.communities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommunity extends JpaRepository<Community, Long> {
}
