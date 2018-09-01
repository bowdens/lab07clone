package week07.lab;
import java.util.*;

/**
 * An implementation of a set using an ArrayList
 * @author bradfordh
 *
 * @param <E> uses a generic type so any object can be declared of this type
 */
public class ArrayListSet<E> implements Set<E> {
	
	
	/**
	 * Default constructor builds an empty set
	 */
	public ArrayListSet() {
		// To be completed
	}

	/**
	 * Copy constructor, makes a copy of the inputed set.
	 * @param arrayListSet
	 */
	public ArrayListSet(ArrayListSet<E> arrayListSet) {
		// To be completed
	}


	@Override
	public void add(E e) {
		// To be completed	
	}

	@Override
	public void remove(E e) {
		// To be completed
	}

	@Override
	public Set<E> union(Set<E> secondSet) {
		// To be completed
		return null;
	}

		
	@Override
	public Set<E> intersection(Set<E> secondSet) {
		// To be completed
		return null;
	}

	@Override
	public boolean contains(Object e) {
		// To be completed
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}
	
	@Override
	public String toString() {
		// To be completed
		return null;
	}
	
	@Override
	public boolean equals(Object o) {
		return false;
	}

	
	@Override
	public boolean subset(Set<E> secondSet)
	{
		for (E e : this)					// can do this since Set<E> implements Iterable<E>!!
			if (!secondSet.contains(e))
				return false;
		return true;
	}
		
	@Override
	public int size() {
		return 0;
	}
}
