package com.keyin.TreeNode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TreeNodeRepository extends CrudRepository<TreeNode, Long> {
}
