package week07.lab;
import java.util.*;

/**
 * An implementation of a set using an ArrayList
 * @author bradfordh
 *
 * @param <E> uses a generic type so any object can be declared of this type
 */
public class ArrayListSet<E> implements Set<E> {
	
	private ArrayList<E> list;
	/**
	 * Default constructor builds an empty set
	 */
	public ArrayListSet() {
		list = new ArrayList<E>();
	}

	/**
	 * Copy constructor, makes a copy of the inputed set.
	 * @param arrayListSet
	 */
	public ArrayListSet(ArrayListSet<E> arrayListSet) {
		list = new ArrayList<E>();
		for (E obj : arrayListSet) {
			list.add(obj);
		}
	}


	@Override
	public void add(E e) {
		if(contains(e)) {
			return;
		} else {
			list.add(e);
		}
	
	}

	@Override
	public void remove(E e) {
		list.remove(e);
	}

	@Override
	public Set<E> union(Set<E> secondSet) {
		Set<E> newSet = new ArrayListSet<E>();
		for (E item : this) {
			newSet.add(item);
		}
		for (E item : secondSet) {
			newSet.add(item);
		}
		return newSet;
	}

		
	@Override
	public Set<E> intersection(Set<E> secondSet) {
		Set<E> newSet = new ArrayListSet<E>();
		for (E item : secondSet) {
			if (this.contains(item)) {
				newSet.add(item);
			}
		}
		return newSet;
	}

	@Override
	public boolean contains(Object e) {
		for(Object obj : list) {
			if(obj.equals(e)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(E e : this) {
			sb.append(e.toString());
			if(this.iterator().hasNext()) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null) return false;
		if (!(o instanceof Set<?>)) return false;
		
		Set<?> other = (Set<?>) o;
		if (this.size() != other.size()) return false;
		
		for (Object obj : other) {
			if(this.contains(obj) == false) return false;
		}
		return true;
	}

	
	@Override
	public boolean subset(Set<E> secondSet) {
		for (E e : this)					// can do this since Set<E> implements Iterable<E>!!
			if (!secondSet.contains(e))
				return false;
		return true;
	}
		
	@Override
	public int size() {
		return list.size();
	}
}
