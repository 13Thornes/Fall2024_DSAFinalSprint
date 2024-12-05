package com.keyin.UserInput;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInputRepository extends CrudRepository<UserInput, Long> {

}
