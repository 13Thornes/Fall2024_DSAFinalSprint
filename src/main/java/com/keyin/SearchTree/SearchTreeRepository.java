package com.keyin.SearchTree;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchTreeRepository extends CrudRepository<SearchTree, Long> {
}
