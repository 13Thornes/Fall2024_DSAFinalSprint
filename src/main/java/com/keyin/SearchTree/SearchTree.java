package com.keyin.SearchTree;

import com.keyin.UserInput.UserInput;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class SearchTree {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 5000)
    private String treeJson;

    private String userInputs;

    public SearchTree(String treeJson, String userInputs) {

        this.treeJson = treeJson;
        this.userInputs = userInputs;
    }

    public SearchTree() {

    }
    public String getUserInputs() {
        return userInputs;
    }

    public void setUserInputs(String userInputs) {
        this.userInputs = userInputs;
    }

    public String getTreeJson() {
        return treeJson;
    }

    public void setTreeJson(String treeJson) {
        this.treeJson = treeJson;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
