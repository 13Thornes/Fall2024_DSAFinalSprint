package com.keyin;

import com.keyin.TreeNode.TreeNode;

import java.util.List;

public class TreeResponseDTO {
    private List<Integer> inputs;
    private TreeNode tree;

    public List<Integer> getInputs() {
        return inputs;
    }

    public void setInputs(List<Integer> inputs) {
        this.inputs = inputs;
    }

    public TreeNode getTree() {
        return tree;
    }

    public void setTree(TreeNode tree) {
        this.tree = tree;
    }
}
