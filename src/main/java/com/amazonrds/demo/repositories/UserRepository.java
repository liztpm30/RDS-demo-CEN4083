package com.amazonrds.demo.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amazonrds.demo.models.User;
import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByOrderByNameAsc();
}
