package com.keyin.TreeNode;

import com.keyin.UserInput.UserInput;
import jakarta.persistence.*;

@Entity
@Table(name = "binary_node")
public class TreeNode {
    @Id
    @SequenceGenerator(name = "node_sequence", sequenceName = "node_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "node_sequence")
    private Long id;

    private int value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "left_child_id")
    private TreeNode left;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "right_child_id")
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
