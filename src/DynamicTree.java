import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class DynamicTree extends JPanel {
    protected DefaultMutableTreeNode rootNode;
    protected DefaultTreeModel treeModel;
    protected JTree tree;

    public DynamicTree() {
        super(new GridLayout(1,0));

        rootNode = new DefaultMutableTreeNode("Root");
        treeModel = new DefaultTreeModel(rootNode);
        tree = new JTree(treeModel);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);

        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane);
    }

    /** Access the currently selected node. */
    public Users accessCurrentNode() {
        TreePath currentSelection = tree.getSelectionPath();
        if (currentSelection != null) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection.getLastPathComponent());
            if(currentNode.getUserObject() instanceof UserGroup){
                return null;
            }
            MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
            if (parent != null) {
                return (User) currentNode.getUserObject();
            }
        }

        return null;
    }

    /** Add a user to a UserGroup or Root. */
   public DefaultMutableTreeNode addUsers(Users child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = tree.getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        }
        else {
            parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
        }

        return addUsers(parentNode, child, true);
    }

    public DefaultMutableTreeNode addUsers(DefaultMutableTreeNode parent, Users child, boolean shouldBeVisible) {

        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
        if (parent == null) {
            parent = rootNode;
        }
        if(parent.getUserObject() instanceof User) {
            /** Disallows add if we are adding a leaf to a User object*/
            return null;
        }

        treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

        if (shouldBeVisible) {
            tree.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }
}