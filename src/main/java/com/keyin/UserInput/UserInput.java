package com.keyin.UserInput;

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

    @ElementCollection
    @CollectionTable(name = "user_input_numbers", joinColumns = @JoinColumn(name = "user_input_id"))
    private List<Integer> inputs;

    @OneToOne(cascade = CascadeType.ALL)
    private TreeNode rootNode;

    public UserInput() {
    }

    public TreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
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
}
