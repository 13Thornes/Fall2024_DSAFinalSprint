package com.keyin.UserInput;

import com.keyin.SearchTree.SearchTree;
import com.keyin.TreeNode.TreeNode;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_input")
public class UserInput {
    @Id
    @SequenceGenerator(name = "input_sequence", sequenceName = "input_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "input_sequence")
    private Long id;

    private Integer input;

    @OneToOne(cascade = CascadeType.ALL)
    private SearchTree searchTree;

    public UserInput() {
    }

    public UserInput(Integer input) {
        this.input = input;
    }


    public SearchTree getSearchTree() {
        return searchTree;
    }

    public void setSearchTree(SearchTree searchTree) {
        this.searchTree = searchTree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInput() {
        return input;
    }

    public void setInput(Integer input) {
        this.input = input;
    }
}
