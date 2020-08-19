package sa2;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeNode {
	// Data fields
	private String lastName;
	private List<Person> members;
	public FamilyTreeNode left;
	public FamilyTreeNode right;

	/**
     	* Constructor: instantializes a new FamilyTreeNode
     	* given a lastName
     	*/
	public FamilyTreeNode(String lastName) {
		this.lastName = lastName;
		this.members = new ArrayList<Person>();
		this.left = null;
		this.right = null;
	}

	/**
     	* Returns the last name of the FamilyTreeNode
     	*/
	public String getLastName() {
		return this.lastName;
	}

	/**
     	* Returns the arraylist of members in the FamilyTreeNode
     	*/
	public List<Person> getMembers() {
		return this.members;
	}

	/*
	 * Returns true if there is an instance of Person in the FamilyTreeNode that has
	 * the same first and last name provided Return false otherwise
	 */
	public boolean doesFamilyMemberExist(String lastName, String firstName) {
		for (Person person : this.members) {
			if (person.getLastName() == lastName && person.getFirstName() == firstName) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if there is an instance of Person in the FamilyTreeNode whose
	 * phone number matches the one provided Returns false otherwise
	 */
	public boolean doesNumberExist(String phoneNumber) {
		for (Person person : this.members) {
			if (person.getPhoneNumber() == phoneNumber) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Adds a Person to this FamilyTreeNode
	 * Throw an exception if the last name provided does not match the last name of the FamilyTreeNode
	 */
	public void addFamilyMember(String lastName, String firstName, String phoneNumber) {
		if (this.doesFamilyMemberExist(lastName, firstName) == true) {
			throw new IllegalArgumentException("Family member already exists");
		}
		else if (this.getLastName() != lastName){
			throw new IllegalArgumentException("Last name does not match family last name");
		}
		else if (this.doesNumberExist(phoneNumber) == true) {
			throw new IllegalArgumentException("Phone number already exists");
		}
		else {
			Person newPerson = new Person(lastName, firstName, phoneNumber);
			this.members.add(newPerson);
		}
	}

	/**
	 * Adds a Person to this FamilyTreeNode
	 * Throw an exception if the last name provided does not match the last name of the FamilyTreeNode
	 */
	public void addFamilyMember(Person person) {
		this.addFamilyMember(person.getLastName(), person.getFirstName(), person.getPhoneNumber());
	}

	/*
	 * Returns the phone number of the person in the family with the given first and
	 * last name 
	 * Returns "Does not exist." if not found
	 */
	public String getPhoneNumberOfFamilyMember(String lastName, String firstName) {
		for (Person person : this.members) {
			if (person.getLastName() == lastName && person.getFirstName() == firstName) {
				return person.getPhoneNumber();
			}
		}
		return ("Does not exist.");
	}

	/*
	 * toString method Ex: [] [John Smith (5551234567), May Smith (5551234568),
	 * April Smith (5551234569), August Smith (5551234570)]
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append('[');
		
		if (this.members.size() == 0) {
			str.append("]");
			return str.toString();
		}
		
		for (Person person : this.members) {
			str.append(person.getFirstName());
			str.append(' ');
			str.append(person.getLastName());
			str.append(' ');
			str.append('(');
			str.append(person.getPhoneNumber());
			str.append(')');
			str.append(", ");
			
		}
			str.deleteCharAt(str.length()-1);
			str.deleteCharAt(str.length()-1);
			str.append(']');
			return (str.toString());
	}
	
	
	public static void main(String[] args) {
		
	}
	
	
}