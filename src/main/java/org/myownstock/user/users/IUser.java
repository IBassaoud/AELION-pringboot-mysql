package org.myownstock.user.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUser extends JpaRepository<User, Long> {
    public List<User> findByLastname(String lastname);

    public List<User> findByLastnameAndFirstname(String lastname, String firstname);

    @Query("SELECT u FROM User u WHERE u.lastname = :lastname AND u.firstname = :firstname")
    public List<User> getByLastnameAndFirstname(@Param("lastname") String lastname, @Param("firstname") String firstname);
}
