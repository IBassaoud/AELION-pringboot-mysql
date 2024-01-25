package org.myownstock.user.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User, Long> {
}
