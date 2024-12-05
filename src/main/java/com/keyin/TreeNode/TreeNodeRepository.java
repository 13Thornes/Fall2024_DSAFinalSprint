package com.keyin.TreeNode;

import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface TreeNodeRepository extends CrudRepository<TreeNode, Long> {
    List<TreeNode> findByUserInputId(Long userInputId);
}
