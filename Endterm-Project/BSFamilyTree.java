package sa2;

import java.util.ArrayList;

/**
 * BSFamilyTree creates a tree for specific families. 
 */
public class BSFamilyTree {
    //Data Fields
	private FamilyTreeNode root;

    /**
     * Constructor: constructs an empty BSFamilyTree
     */
    public BSFamilyTree() {
    	this.root = null;
    }

    /**
     * takes in the last name and returns true if there
     * is a FamilyTreeNode with the given last name.
     */
    public boolean doesFamilyExist(String lastName) {
    	return doesFEhelper(root, lastName);
    }
    
    private boolean doesFEhelper(FamilyTreeNode subRoot, String lastName) {
    	if (subRoot == null) {
    		return false;
    	}
    	else if (subRoot.getLastName().compareTo(lastName) == 0) {
    		return true;
    	}
    	else {
    		if (subRoot.getLastName().compareTo(lastName) > 0) {
        		return doesFEhelper(subRoot.left, lastName); //go left
        	}
    		else {
        		return doesFEhelper(subRoot.right, lastName); //go right
        	}
    	}
    }

    /**
     * Takes in a last name and creates a new instance of
     * FamilyTreeNode and adds it to the BSFamilyTree.
     */
    public void addFamilyTreeNode(String lastName) {
    	if (this.doesFamilyExist(lastName) == true) {
    		throw new IllegalArgumentException("Family already exists in tree");
    	}
    	addFTNhelper(root, lastName);
    }
    private boolean addFTNhelper(FamilyTreeNode subRoot, String lastName) {
    	FamilyTreeNode newNode = new FamilyTreeNode(lastName);
    	if (subRoot == null) {
    		root = newNode;
    		return true;
    	}
    	else if (subRoot.left == null  && subRoot.getLastName().compareTo(lastName) > 0) {
    		subRoot.left = newNode;
    		return true;
    	}
    	else if (subRoot.right == null && subRoot.getLastName().compareTo(lastName) < 0){
    		subRoot.right = newNode;
    		return true;
    	}
    	else {
    		if (subRoot.getLastName().compareTo(lastName) > 0) {
        		return addFTNhelper(subRoot.left, lastName); //go left
        	}
    		else {
        		return addFTNhelper(subRoot.right, lastName); //go right
        	}
    	}
    }

    /**
     * Takes a last name and then finds that specific
     * family tree and then returns that FamilyTreeNode
     * If last name is not in tree, throws an exception.
     */
    public FamilyTreeNode getFamilyTreeNode(String lastName) {
    	if (this.doesFamilyExist(lastName) == false) {
    		throw new IllegalArgumentException("Family does not exist");
    	}
    	return getFTNhelper(root, lastName);
    }
    
    private FamilyTreeNode getFTNhelper(FamilyTreeNode subRoot, String lastName) {
    	if (subRoot.getLastName().compareTo(lastName) == 0) {
    		return subRoot;
    	}
    	else {
    		if (subRoot.getLastName().compareTo(lastName) > 0) {
        		return getFTNhelper(subRoot.left, lastName); //go left
        	}
    		else {
        		return getFTNhelper(subRoot.right, lastName); //go right
        	}
    	}
    }

    /**
     * Returns true if the input phone number exists in the BSFamilyTree
     * false otherwise.
     */
    public boolean doesNumberExist(String phoneNumber) {
    	return doesNEhelper(root, phoneNumber);
    }
    
    private boolean doesNEhelper(FamilyTreeNode subRoot, String phoneNumber) {
    	if (subRoot == null) {
    		return false;
    	}
    	else if (subRoot.doesNumberExist(phoneNumber) == true) {
    		return true;
    	}
    	else {
    		return doesNEhelper(subRoot.left, phoneNumber) || doesNEhelper(subRoot.right, phoneNumber);
    	}
    }

    /**
     * Returns the string representation of the BSFamilyTree
     */
    public String toString() {
    	return toString_helper(root,0).toString();
    }
	private StringBuilder toString_helper(FamilyTreeNode current, int level) {
		StringBuilder str = new StringBuilder();
		for (int i=0; i<level; i++) {
			str.append("  ");
		}
		if (current==null) {
			str.append("null\n");
		} else {
			str.append(current.toString()+ "\n");
			str.append(toString_helper(current.left,level+1));
			str.append(toString_helper(current.right,level+1));
		}
		return str;
	}
	
	public static void main(String[] args) {

		}
}
