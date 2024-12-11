package com.keyin.SearchTree;

import com.keyin.TreeNode.TreeNode;
import com.keyin.TreeNode.TreeNodeRepository;
import com.keyin.UserInput.UserInputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;


@Service
public class SearchTreeService {

    @Autowired
    private TreeNodeRepository treeNodeRepository;

    @Autowired
    public SearchTreeRepository searchTreeRepository;

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
        for (int number : numbers) {
            root = insertNode(root, number);
        }
        treeNodeRepository.save(root);
        String[] jsons = convertTree(root, numbers);
        saveTree(jsons[0], jsons[1]);
        return root;
    }

    public String[] convertTree(TreeNode root, List<Integer> numbers) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String treeJSON = gson.toJson(root);
        String numsJSON = gson.toJson(numbers);
        return new String[]{treeJSON, numsJSON};
    }
    public void saveTree(String treeJSON, String numsJSON){
        SearchTree searchTree = new SearchTree(treeJSON, numsJSON);
        searchTreeRepository.save(searchTree);
    }

    public Iterable<SearchTree> getPreviousTrees() {
        return searchTreeRepository.findAll();
    }

}


