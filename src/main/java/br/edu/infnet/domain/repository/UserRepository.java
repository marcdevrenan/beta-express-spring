package br.edu.infnet.domain.repository;

import br.edu.infnet.domain.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("from User u where u.email = :email and u.password = :password")
    public User authentication(String email, String password);
}
