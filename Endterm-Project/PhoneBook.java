package sa2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PhoneBook {
	// Data fields
	public Map<Character, BSFamilyTree> directory;

	/**
     	* Creates a new phone book with an empty directory.
     	*/
	public PhoneBook() {
		directory = new HashMap<Character, BSFamilyTree>();
		
		BSFamilyTree a = new BSFamilyTree();
		BSFamilyTree b = new BSFamilyTree();
		BSFamilyTree c = new BSFamilyTree();
		BSFamilyTree d = new BSFamilyTree();
		BSFamilyTree e = new BSFamilyTree();
		BSFamilyTree f = new BSFamilyTree();
		BSFamilyTree g = new BSFamilyTree();
		BSFamilyTree h = new BSFamilyTree();
		BSFamilyTree i = new BSFamilyTree();
		BSFamilyTree j = new BSFamilyTree();
		BSFamilyTree k = new BSFamilyTree();
		BSFamilyTree l = new BSFamilyTree();
		BSFamilyTree m = new BSFamilyTree();
		BSFamilyTree n = new BSFamilyTree();
		BSFamilyTree o = new BSFamilyTree();
		BSFamilyTree p = new BSFamilyTree();
		BSFamilyTree q = new BSFamilyTree();
		BSFamilyTree r = new BSFamilyTree();
		BSFamilyTree s = new BSFamilyTree();
		BSFamilyTree t = new BSFamilyTree();
		BSFamilyTree u = new BSFamilyTree();
		BSFamilyTree v = new BSFamilyTree();
		BSFamilyTree w = new BSFamilyTree();
		BSFamilyTree x = new BSFamilyTree();
		BSFamilyTree y = new BSFamilyTree();
		BSFamilyTree z = new BSFamilyTree();
		
		directory.put('A', a);
		directory.put('B', b);
		directory.put('C', c);
		directory.put('D', d);
		directory.put('E', e);
		directory.put('F', f);
		directory.put('G', g);
		directory.put('H', h);
		directory.put('I', i);
		directory.put('J', j);
		directory.put('K', k);
		directory.put('L', l);
		directory.put('M', m);
		directory.put('N', n);
		directory.put('O', o);
		directory.put('P', p);
		directory.put('Q', q);
		directory.put('R', r);
		directory.put('S', s);
		directory.put('T', t);
		directory.put('U', u);
		directory.put('V', v);
		directory.put('W', w);
		directory.put('X', x);
		directory.put('Y', y);
		directory.put('Z', z);
	}

	/*
	 * Returns the instance of BSFamilyTree at the indicated letter
	 * Must accept lowercase letters as well as uppercase letters
	 */
	public BSFamilyTree getFamilyTree(char letter) {
		if (Character.isLetter(letter) == false) {
			throw new IllegalArgumentException("letter is not a char");
		}
		char tempKey = Character.toUpperCase(letter);
		return directory.get(tempKey);
	}

	/*
	 * Adds a FamilyTreeNode to the PhoneBook
	 */
	public void addFamily(String lastName) {
		char tempKey = lastName.charAt(0);
		directory.get(tempKey).addFamilyTreeNode(lastName);
	}

	/*
	 * Adds a Person to the PhoneBook
	 * If a FamilyTreeNode with the given last name doesn't currently exist, create the FamilyTreeNode
	 */
	public void addPerson(String lastName, String firstName, String phoneNumber) {
		for (Entry<Character, BSFamilyTree> entry : directory.entrySet()) {
			if (entry.getValue().doesNumberExist(phoneNumber) == true) {
				throw new IllegalArgumentException("Phone Number already exists");
			}
		}
		Person person = new Person(lastName, firstName, phoneNumber);
		char tempKey = lastName.charAt(0);
		if (this.getFamilyTree(tempKey).doesFamilyExist(lastName) == true) {
			directory.get(tempKey).getFamilyTreeNode(lastName).addFamilyMember(person);
		}
		else {
			directory.get(tempKey).addFamilyTreeNode(lastName);
			directory.get(tempKey).getFamilyTreeNode(lastName).addFamilyMember(person);
		}
	}

	/*
	 * Finds the phone number of a person
	 * Returns 'Does not exist.' if not found.
	 */
	public String getPhoneNumber(String lastName, String firstName) {
		char tempKey = lastName.charAt(0);
		return directory.get(tempKey).getFamilyTreeNode(lastName).getPhoneNumberOfFamilyMember(lastName, firstName);
	}

    	/**
     	* String representation of PhoneBook
     	*/
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Entry<Character, BSFamilyTree> entry : directory.entrySet()) {
			str.append(entry.getKey());
			str.append(entry.getValue().toString());
		}
		return str.toString();
	}
	
	
	public static void main(String[] args) {
		
	}
}
