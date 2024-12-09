package com.keyin.SearchTree;

import com.keyin.TreeNode.TreeNode;
import com.keyin.TreeNode.TreeNodeRepository;
import com.keyin.UserInput.UserInput;
import com.keyin.UserInput.UserInputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;


@Service
public class SearchTreeService {

    @Autowired
    private UserInputRepository userInputRepository;

    @Autowired
    private TreeNodeRepository treeNodeRepository;

    @Autowired
    private SearchTreeRepository searchTreeRepository;

    public TreeNode insertNode(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.getValue()) {
            root.setLeft(insertNode(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(insertNode(root.getRight(), value));
        }

        return root;
    }

    public TreeNode createSearchTree(List<Integer> numbers) {
        TreeNode root = null;
        for (int num : numbers) {
            root = insertNode(root, num);
            UserInput newInput = new UserInput(num);


        }
        treeNodeRepository.save(root);
        String treeJson = convertTree(root);
        saveTree(treeJson);
        return root;
    }

    public String convertTree(TreeNode root) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return  gson.toJson(root);
    }
    public void saveTree(String treejson){
        SearchTree searchTree = new SearchTree(treejson);
        searchTreeRepository.save(searchTree);
    }

    public Iterable<SearchTree> getPreviousTrees() {
        return searchTreeRepository.findAll();
    }

}
