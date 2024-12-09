

import com.keyin.SearchTree.SearchTreeService;
import com.keyin.TreeNode.TreeNode;
import org.junit.jupiter.api.Test;

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

        SearchTreeService searchTreeService = new SearchTreeService();

        String treeJson = searchTreeService.convertTree(root);

        assertTrue(treeJson.contains("15"));
        assertTrue(treeJson.contains("5"));
        assertTrue(treeJson.contains("7"));
    }



}
