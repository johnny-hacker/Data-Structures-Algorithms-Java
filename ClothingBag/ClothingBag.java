/*
Name: Johnny Olmedo

Project Name: CSC400-Module 2 Clothing Boutique

Project Purpose: Understanding working with bags by implementing a class that implements a baginterface class

Algorithm Used: implementing a class called ClothingBag that implements the BagInterface<T>

 */
import java.util.Arrays;

public class ClothingBag<T> implements BagInterface<T> {

	T[] bag; // cretae instance of bag
	int numberOfEntries; // num of entries
	int size; // size
    // create the default size of 2
	static final int DEFAULT_SIZE = 2;
    // set max size of 500
	static final int MAX_SIZE = 500;
	
	//create default bag with default size
	public ClothingBag(){
		this(DEFAULT_SIZE);
	}
	
	//create bag with specific size
	public ClothingBag(int size) {
		checkSize(size);
        // create a copy of the bag called temp bag
		T[] tempBag = (T[])new Object[size];
        // set bag to temp bag
		bag = tempBag;
        // set num of entries to 0
		numberOfEntries = 0;
	}

    // consttuctor takes contents of bag and creates a copy of it
	public ClothingBag(T[] contents) {
		// ensure the size of the bag is the right size
        checkSize(contents.length);
        // copy contnts of bag 
		bag = Arrays.copyOf(contents, contents.length);
		numberOfEntries = contents.length;
	}
	
    // check size method ensures the contents of bag doesn't exceed set limitations
	public void checkSize(int size) {
        // if size is > 500 throw exception
		if(size > MAX_SIZE)
            // exception Statement
			throw new IllegalStateException("Desired bag size exceeds maximum bag size of " + MAX_SIZE);
	}

	//adds a new entry to bag
	@Override
	public boolean add(T newEntry) {
		// if the bag is full double the size of it
		if(isArrayFull()) {
			doubleSize();
		}
        // update num of entries for the bag
		bag[numberOfEntries] = newEntry;
		numberOfEntries++;
        // return true 
		return true;
	}
	
    // method doubles the size bag
	private void doubleSize() {
		int newLength = 2 * bag.length;
		checkSize(newLength);
		bag = Arrays.copyOf(bag, newLength);
	}

	// removes one instance of specified entry
	@Override
	public boolean remove(T newEntry) {
		// remove specific entry from bag
		int index = getIndexOf(newEntry);
		T result = removeEntry(index);
		return newEntry.equals(result);
	}

	// removes random entry
	@Override
	public boolean remove() {
		// remove 1 entry from the statement
		boolean result = (boolean) removeEntry(numberOfEntries - 1);
        // return result as long as true
		return result;
	}
	
	private T removeEntry(int givenIndex) {
		T result = null;
		if(!isEmpty() && givenIndex >= 0) {
			result = bag[givenIndex];
			int lastIndex = numberOfEntries - 1;
			bag[givenIndex] = bag[lastIndex];
			bag[lastIndex] = null;
			numberOfEntries--;
		}
		return result;
	}

	// tests if bag is empty
	@Override
	public boolean isEmpty() {
		// return if nothing is the bag
		return numberOfEntries == 0;
	}

	// removes all entries in bag
	@Override
	public void clear() {
		// while isExmpty is not true clear bag
		while(!isEmpty())
			remove();
	}

	//returns current number of entries in bag
	@Override
	public int getCurrentSize() {
		// retur num of entries
		return numberOfEntries;
	}

	// tests if bag contains a certain entry
	@Override
	public boolean contains(T anEntry) {
		// return getIndexOf regardless if true or false
		return getIndexOf(anEntry) > -1;
	}

    // test is array is full
	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	}
	
	// stores all entries in bag to an array
	@Override
	public T[] toArray() {
		// set array with everything stored in the bag
		T[] result = (T[])new Object[numberOfEntries];
		for(int index = 0; index < numberOfEntries; index++) {
            // update every index in bag
			result[index] = bag[index];
		}
        // return result
		return result;
	}

    // return the specified index of an entry
	private int getIndexOf(T anEntry){
		int where = -1;
		boolean found = false;
		int index = 0;
		// while found is true and index isnot smaller than num of entries
		while(!found && (index < numberOfEntries)) {
            // if you find what your looking for
			if(anEntry.equals(bag[index])) {
                //found = true
				found = true;
                // update where to index
				where = index;
			}
            // add 1 to index
			index++;
		}
        // return where
		return where;
	}

    // method prints contenst of everything in the bag
    public void printBag() {
        System.out.println("Bag Contents:");
        for (int i = 0; i < bag.length; i++) {
            System.out.println("Element #" + (i+1) + ":"+ bag[i]);
        }
    }
	
}