import java.util.Arrays;

public class ResizeableArrayBag<T> implements BagInterface<T>
{	
	private T[] bag;
	private static final int DEFAULT_CAPACITY = 50; // initialize default capacity to 50 as integer
	private int numberOfEntries; // initialize numberOfEntries as integer
	
	private boolean integrityOK = false;
	private static final int MAX_CAPACITY = 100; // initialize max capacity of 100 as integer
	
	
	/** ResizeableArrayBag method creates empty bag set to default capacity */
	public ResizeableArrayBag() // start default constructor
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	
	/** ResizeableArrayBag method creates empty bag with starting capacity.
	   @param capacity is integer size in bag */
	public ResizeableArrayBag(int capacity) // start constructor
	{
		if(capacity <= MAX_CAPACITY)
		{
			@SuppressWarnings("unchecked")	// suppress warnings as "unchecked" cast
			T[] tempBag = (T[])new Object[capacity]; 
			bag = tempBag;
			numberOfEntries = 0;
			integrityOK = true;
		}
		else
		{
			throw new IllegalStateException("Dude, you can't make a bag with more than 100 items smh.");
		}
		
		
	} // end constructor
	
	
	/** add method adds new entry to bag
	 * @param newEntry object goes into newEntry
	 * @return  returns true if add to newEntry is successful, or false if not successful */
	public boolean add(T newEntry) // start add method
	{
		checkIntegrity();
		boolean result = true;
		
		if(isFull())
		{
			doubleCapacity();
		}
		else
		{
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		
		return result;
	} // end add method
	
	public T[] toArray() // start toArray method
	{
	
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; // suppress warnings as "unchecked" cast
		
		for(int index = 0; index < numberOfEntries; index++)
		{
			result[index] = bag[index];
		}
		
		return result;
	} // end toArray method
	
	public boolean isFull() // start isFull method
	{
		return numberOfEntries == bag.length;
	} // end isFull method
	
	
	/** isEmpty method checks if bag is empty
	 * @return  returns true if bag is empty, or false if not empty */
	public boolean isEmpty() // start isEmpty method
	{		
		return numberOfEntries == 0;
	} // end isEmpty method
	
	
	/** getCurrentSize method gets current number of entries in bag
	 * @return  returns number of entries currently in bag */
	public int getCurrentSize() // start getCurrentSize method
	{
		return numberOfEntries;
	} // end getCurrentSize method
	
	
	/** getFrequency method counts number of times an entry appears in bag
	 * @param anEntry  The entry to be counted.
	 * @return  returns number of times anEntry appears in bag */
	public int getFrequencyOf(T anEntry) // start getFrequencyOf method
	{
		checkIntegrity();
		int counter = 0;
		
		for(int index = 0; index < numberOfEntries; index++)
		{
			if(anEntry.equals(bag[index]))
			{
				counter++;
			}
		}
		return counter;
	} //end getFrequencyOf method
	
	
	/** remove method removes one event of entry from bag
	 * @param anEntry is the entry being removed
	 * @return  returns true if removal is successful, false if not successful */
	public boolean remove(T anEntry) // start remove method
	{
		checkIntegrity();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	} //end remove method
	
	
	/** remove method removes unspecified entry from bag, if applicable
	 * @return  returns removed entry, returns removal was successful, or returns null */
	public T remove() // start remove method
	{
		checkIntegrity();
		T result = removeEntry(numberOfEntries - 1);
		return result;
	} // end remove method
	
	public void clear() // start clear method
	{
		while(!isEmpty())
		{
			remove();
		}
	} // end clear method
	
	
	/** contains method checks if bag contains given entry
	 * @param anEntry  is the entry that is located
	 * @return  returns true if bag contains anEntry, or false if it does not */
	public boolean contains(T anEntry) // start contains method
	{
		checkIntegrity();
		return getIndexOf(anEntry) >= 0;
	} // end contains method
	
	// exception if capacity is too big for user
	private void checkCapacity(int capacity) // start checkCapacity method
	{
		if(capacity > MAX_CAPACITY)
		{
			throw new IllegalStateException("Ayo! U tryna make a bag capacity bigger than the maximum of " + MAX_CAPACITY);
		}
	} // ends checkCapacity method
	
	private void doubleCapacity() // start doubleCapacity method
	{
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	} // end doubleCapacity method
	 
	private int getIndexOf(T anEntry) // start getIndexOf method
	{
		int where = -1;	// initialize where = -1 as integer
		boolean found = false;	// boolean found is false
		int index = 0;	// initialize index as integer of 0
		
		while(!found && (index < numberOfEntries)) // while statement that searches for given entry within array bag, returns index of said entry
		{
			if(anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			}
			index++;
		}
		
		return where;
	} // end getIndexOf method
	
	// Removes and returns the entry at a given index within the array bag.
	// If no such entry exists, returns null.
	// Preconditions: 0 <= givenIndex < numberOfEntries;
	//                checkIntegrity has been called.
	private T removeEntry(int givenIndex) // start removeEntry method
	{
		T result = null;
		
		if(!isEmpty() && (givenIndex >= 0)) {	// if statement that removes and returns entry within a given index in array bag
			result = bag[givenIndex];				// if the entry does not exist, return result as NULL
			bag[givenIndex] = bag[numberOfEntries - 1];
			bag[numberOfEntries] = null;
			numberOfEntries--;
		}
		return result;
	} // end removeEntry method
	
	// exception if object is not initialized
	private void checkIntegrity() // start checkIntegrity method
	{
		if(integrityOK == false)
		{
			throw new SecurityException("Bro, your item is invalid >:(");
		}
	} // end checkIntegrity method
	
}