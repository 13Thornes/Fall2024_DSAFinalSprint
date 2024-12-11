

import com.keyin.SearchTree.SearchTreeService;
import com.keyin.TreeNode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class SearchTreeServiceTest {

    SearchTreeService searchTreeService = new SearchTreeService();

    @Test
    void testInsertNodeWhenNull() {

        TreeNode root = null;
        TreeNode newNode = searchTreeService.insertNode(root, 10);

        assertNotNull(newNode);
        assertEquals(10, newNode.getValue());
        assertNull(newNode.getLeft());
        assertNull(newNode.getRight());
    }

    @Test
    void testInsertNodeWhenNotNull() {

        TreeNode root = new TreeNode(10);
        TreeNode newRoot = searchTreeService.insertNode(root, 5);

        assertNotNull(newRoot);
        assertEquals(10, newRoot.getValue());
        assertNotNull(newRoot.getLeft());
        assertEquals(5, newRoot.getLeft().getValue());
        assertNull(newRoot.getLeft().getLeft());
        assertNull(newRoot.getLeft().getRight());
    }

    @Test
    void testConvertTree() {

        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(5));
        root.setRight(new TreeNode(15));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().setRight(new TreeNode(7));

        List<Integer> numbers = Arrays.asList(3, 5, 7, 10, 15);


        SearchTreeService searchTreeService = new SearchTreeService();

        String[] treeJsonArray = searchTreeService.convertTree(root, numbers);

        String treeJSON = treeJsonArray[0];
        String numsJSON = treeJsonArray[1];


        assertTrue(treeJSON.contains("15"));
        assertTrue(treeJSON.contains("5"));
        assertTrue(treeJSON.contains("7"));

        assertTrue(numsJSON.contains("3"));
        assertTrue(numsJSON.contains("10"));
        assertTrue(numsJSON.contains("15"));


    }




}
