package com.keyin;

import com.keyin.TreeNode.TreeNode;

import java.util.List;

public class PreviousTreeResponseDTO {

    private Long id;
    private List<Integer> inputs;
    private TreeNode tree;

    public TreeNode getTree() {
        return tree;
    }

    public void setTree(TreeNode tree) {
        this.tree = tree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getInputs() {
        return inputs;
    }

    public void setInputs(List<Integer> inputs) {
        this.inputs = inputs;
    }

    @Override
    public String toString() {
        return "PreviousTreeResponseDTO{" +
                "id=" + id +
                ", inputs=" + inputs +
                ", tree=" + tree +
                '}';
    }
}
