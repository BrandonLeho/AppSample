
public final class LinkedBag<T> implements BagInterface<T>
{
	private Node firstNode;       // initializes the node to the first node of the of the array
	private int numberOfEntries;  // initializes the numberOfEntries as an integer

	public LinkedBag() // start LinkedBag method
	{
		firstNode = null;
		numberOfEntries = 0;
	} // end LinkedBag method

	
	/** method adds new entry into a bag
	    @param parameter to newEntry is the new object that goes into newEntry
	    @return  returns entry as true */
	public boolean add(T newEntry) // start add method for newEntry
	{
		Node newNode = new Node(newEntry); // adds newNode to beginning of chain
		newNode.next = firstNode;  // newNode to reference beginning Node
                                 // (firstNode is null if chain is empty)
		firstNode = newNode;       // newNode is the starting Node, 
		numberOfEntries++;
      
		return true;
	} // ends add method
	
	
	/** remove method gets rid of null entries when applicable
	 * @return  returns result of entry */
	public T remove() // start remove method
	{
		T result = null;
		if(firstNode != null)	// if statement that if the firstNode results as NULL, remove firstNode from chain
		{
			result = firstNode.getData();
			firstNode = firstNode.getNextNode(); 
			numberOfEntries--;
		}
		
		return result;
	} // end remove method
	
	
	/** boolean remove gets rid of an event of given entry from bag when applicable
	 * @param parameter anEntry removes entry
	 * @return  return statement true if entry is deleted, or false if entry is not deleted */
	public boolean remove(T anEntry) // start remove method
	{
		boolean result = false; 
		Node nodeN = getReferenceTo(anEntry);
		
		if(nodeN != null)		// if statement that if NULL entries entry is deleted, returns result as true
		{
			nodeN.setData(firstNode.getData());
			firstNode = firstNode.getNextNode();
			numberOfEntries--;
			result = true;
		}
		
		return result;
	} // end remove method
	
	private Node getReferenceTo(T anEntry) // start getReferenceTo method
	{
		boolean found = false;
		Node currentNode = firstNode;
				
		while (!found && (currentNode != null))		// while statement searches for given entry within bag, will return reference of node holding entry
		{
			if(anEntry.equals(currentNode.getData()))	// if else statement that if given entry within bag is found, else get current node 
			{
				found = true;
			}
			else
			{
				currentNode = currentNode.getNextNode();
			}
		}
				
		return currentNode; // returns currentNode from while-if/else statement
	} // end getReferenceTo method
		
   
	/** isEmpty method checks if bag is empty
       @return  returns true if bag is empty, false if not empty */
	public boolean isEmpty() // start isEmpty method
	{
		return numberOfEntries == 0;
	} // end isEmpty method
   
	
	/** getCurrentSize method gets current number of entries in bag
       @return  returns number of entries currently in bag */
	public int getCurrentSize() // start getCurrentSize method
	{
		return numberOfEntries;
	} // end getCurrentSize method
	
	
	/** clear method removes all entries bag */
	public void clear() // start clear method
	{
		while (!isEmpty())
		{
			remove();
		}
	} // end clear method
	
	
	/** getFrequencyOf method counts how many times an entry appears in bag
	 * @param anEntry	The entry to be counted.
	 * @return	The number of times anEntry appears in this bag */
	public int getFrequencyOf(T anEntry) // start getFrequencyOf method
	{
		int frequency = 0;
		int counter = 0;
		Node currentNode = firstNode;
		while((counter < numberOfEntries) && currentNode != null)
		{
			if(anEntry.equals(currentNode.getData()))
			{
				frequency++;
			}
			
			counter++;
			currentNode = currentNode.getNextNode();
		}
		
		return frequency;
	} // end getFrequencyOf method
	
	/** contains method checks whether bag contains given entry
	 * @param anEntry is the entry to be found
	 * @return	returns true if bag contains anEntry, or false if it does not contain entry */
	public boolean contains(T anEntry) // start contains method
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)) {
			if(anEntry.equals(currentNode.getData()))
			{
				found = true;
			}
			else
			{
				currentNode = currentNode.getNextNode();
			}
		} 
		
		return found;
	} // end contains method
	
	
	/** toArray method gathers all entries in bag
    @return returns allocated array of all entries in bag */
	public T[] toArray() // start toArray method
	{
   @SuppressWarnings("unchecked") // suppress warnings as "unchecked"
   T[] result = (T[])new Object[numberOfEntries]; 
   
   int index = 0;
   Node currentNode = firstNode;
   while ((index < numberOfEntries) && (currentNode != null))
   {
      result[index] = currentNode.data;
      index++;
      currentNode = currentNode.next;
   } 
   
   return result;
   } // end toArray method

	public BagInterface<T> union(BagInterface<T> otherBag) //This has its contents combined with two bags via a for loop.
	{
		BagInterface<T> result = new LinkedBag<>();
		T[]others = otherBag.toArray();
		
		for(T elem : others)
		{
			result.add(elem);
		}
		return result;
	}
	
	public BagInterface<T> intersection(BagInterface<T> otherBag) //This checks the intersections between two bags via a for loop and an if statement.
	{
		BagInterface<T> result = new LinkedBag<>();
		BagInterface<T> finalResult = new LinkedBag<>();
		T[]mine = this.toArray();
		for(T elem : mine) 
		{
			result.add(elem);
		}
		T[]others = otherBag.toArray();
		for(T elem : others)
		{
			if(result.contains(elem)) 
			{
				finalResult.add(elem);
			}
		}
		
		return finalResult;
	}
	
	public BagInterface<T> difference(BagInterface<T> otherBag) //This checks the differences between two bags via a for loop and an if statement.
	{
		BagInterface<T> result = new LinkedBag<>();
		T[] mine = this.toArray();
		for(T elem : mine)
		{
			result.add(elem);
		}
		T[] others = otherBag.toArray();
		for(T elem  : others) {
			if(result.contains(elem))
			{
				result.remove(elem); 
			}
		}
		
		return result;
	} //end difference method
	
	// inner class of LinkedBag
	private class Node
	{
	  private T    data; // entry in bag
	  private Node next; // links to proceeding node

		private Node(T dataPortion) // start constructor
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode) // start constructor
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
		
		private T getData() // start getData method
		{
			return data;
		} // end getData method
		
		private void setData(T newData) // start setData method
		{
			data = newData;
		} // end setData method
		
		private Node getNextNode() // start getNextNode method
		{
			return next;
		} // end getNextNode method

		
	} // end Node method
	
} // end main method final class LinkedBag