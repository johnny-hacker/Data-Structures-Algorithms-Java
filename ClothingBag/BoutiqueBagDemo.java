/*
Name: Johnny Olmedo

Project Name: CSC400-Module 2 Clothing Boutique

Project Purpose: Understanding working with bags by implementing a class that implements a baginterface class

Algorithm Used: implementing a class called ClothingBag that implements the BagInterface<MyType>

 */

public class BoutiqueBagDemo {

	public static void main(String[] args){
	    // create instance of the bag
		BagInterface<Integer> bag = new ClothingBag<Integer>(5);
        // call method to add objects to the bag
        testAdd(bag);
        // display contents of the bag
        displayBag(bag);
	}
	
    // this method adds integers to the bag
    public static void testAdd(BagInterface<Integer> getBag) { // pass the bag to the method
        // set iterator to zero 
        int iterator = 0;
        // loop through and add the terator to each open element in the bag
        for (int i = 0; i < 5; i++) {
            // add int to the bad
            getBag.add(iterator);
            // update the bad through toArray
            getBag.toArray();
            // add 1 to the iterator
            iterator++;
        }
    }

    // this method calls the print bad method in ClothingBag class
    public static void displayBag(BagInterface<Integer> getBag) {
        getBag.printBag();
    }
} 
