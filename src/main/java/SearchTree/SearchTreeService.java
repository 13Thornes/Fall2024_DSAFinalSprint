package SearchTree;

import com.keyin.PreviousTreeResponseDTO;
import com.keyin.TreeNode.TreeNode;
import com.keyin.TreeNode.TreeNodeRepository;
import com.keyin.UserInput.UserInput;
import com.keyin.UserInput.UserInputRepository;
import org.antlr.v4.runtime.tree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SearchTreeService {

    @Autowired
    private UserInputRepository userInputRepository;

    @Autowired
    private TreeNodeRepository treeNodeRepository;

    private TreeNode insertNode(TreeNode root, int value) {
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
        }
        return null;
    }

    public List<TreeNode> getTreeNodes(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if (root != null) {
            nodes.add(root);
            nodes.addAll(getTreeNodes(root.getLeft()));
            nodes.addAll(getTreeNodes(root.getRight()));
        }
        return nodes;
    }

    public void saveData(List<Integer> numbers) {
        TreeNode root = createSearchTree(numbers);
        UserInput userInput = new UserInput();
        userInput.setInputs(numbers);
        userInput = userInputRepository.save(userInput);

        List<TreeNode> binaryTreeNodes = getTreeNodes(root);
        for (TreeNode node : binaryTreeNodes) {
            node.setUserInput(userInput);
        }

        treeNodeRepository.saveAll(binaryTreeNodes);
    }


    private TreeNode createSearchTreeFromNodes(List<TreeNode> nodes) {
        TreeNode root = null;
        for (TreeNode node : nodes) {
            root = insertNode(root, node.getValue());
        }
        return root;

    }



    public List<PreviousTreeResponseDTO> getAllPreviousTrees() {
        return null;
    }

}
