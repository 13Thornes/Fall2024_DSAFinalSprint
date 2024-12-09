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

    @OneToMany
    private List<UserInput> inputs;

    public SearchTree(String treeJson) {
        this.treeJson = treeJson;
    }

    public SearchTree() {

    }

    public List<UserInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<UserInput> inputs) {
        this.inputs = inputs;
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
