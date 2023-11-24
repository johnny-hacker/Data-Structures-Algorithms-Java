/*
Name: Johnny Olmedo

Project Name: CSC400-Module 2 Clothing Boutique

Project Purpose: Understanding working with bags by implementing a class that implements a baginterface class

Algorithm Used: implementing a class called ClothingBag that implements the BagInterface<MyType>

 */

public interface BagInterface<T> {

	//adds a new entry and returns true or false depending if the addition completed or not
	public boolean add(T newEntry);
	
	//removes a specific entry and returns true or false depending if the removal completed or not
	public boolean remove(T newEntry);
	
	//removes an arbitrary entry and returns true or false depending if the removal completed or not
	public boolean remove();
	
	//checks if bag is empty
	public boolean isEmpty();
	
	//removes all entries from bag
	public void clear();
	
	//returns current number of entries in bag
	public int getCurrentSize();
	
	//tests if the bag contains a specific entry
	public boolean contains(T anEntry);
	
	//stores all entries in an array
	public T[] toArray();

    // returns bag
    public void printBag();
}
