package com.keyin.SearchTree;

import com.keyin.TreeNode.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
public class SearchTreeController {

    @Autowired
    private SearchTreeService searchTreeService;

    @PostMapping("/process-numbers")
    public TreeNode processNumbers(@RequestBody List<Integer> numbers) {
        return searchTreeService.createSearchTree(numbers);
    };


    @GetMapping("/previous")
    public Iterable<SearchTree> getPreviousTrees() {
        return searchTreeService.getPreviousTrees();
    }

}
