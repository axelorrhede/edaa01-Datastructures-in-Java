package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element to this queue, else false
	 */
	public boolean offer(E e) {
		if (last == null) {
			last = new QueueNode<>(e);
			last.next = last;
			size++;
			return true;
		}
		QueueNode<E> temp = new QueueNode<>(e);
		temp.next = last.next;
		last.next = temp;
		last = temp;
		size++;
		return true;

	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (last == null) {
			return null;
		}
		return last.next.element;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (last == null) {
			return null;
		}
		if (last.next == last) {
			E temp = last.element;
			last = null;
			size--;
			return temp;
		}
		E temp = last.next.element;
		last.next = last.next.next;
		size--;
		return temp;
	}

	/**
	 * Appends the specified queue to this queue post: all elements from the
	 * specified queue are appended to this queue. The specified queue (q) is empty
	 * after the call.
	 * 
	 * @param q the queue to append
	 * @throws IllegalArgumentException if this queue and q are identical
	 */
	public void append(FifoQueue<E> q) {
		if (this == q) {
			throw new IllegalArgumentException();
		}
		if (q.size != 0) {
			if (size == 0) {
				last = q.last;
				q.last = null;
				size = q.size;
				q.size = 0;
			}  else {
				QueueNode<E> temp = last.next;
				last.next = q.last.next;
				q.last.next = temp;
				last = q.last;
				q.last = null;
				size += q.size;
				q.size = 0;
			}
		}

	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private boolean started = false;

		/** Konstruktor */
		private QueueIterator() {
			pos = last;
		}

		public boolean hasNext() {
			return ((pos != last || !started) && size != 0);
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			pos = pos.next;
			started = true;
			return pos.element;
		}
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}

/*
 * F2 last har värdet null
 * 
 * last.next
 * 
 * last.next.element
 * 
 * F3 a) man använder assertFalse b) AssertArrayEquals
 * 
 * D7. a) Det skulle gå, men en arraylist har lite andra kvaliteer än en linked
 * list som vi skriver här, så lika gärna är nog fel, det hade antingen varit
 * bättre eller sämre beroende på vad listan används till
 * 
 * b) det går mycket snabbare att delegera, men då har man
 * inte samma kontroll över koden, om du vill lägga till någon extra metod går
 * det nästan inte alls, exempelvis om append inte finns i linked list. (den heter addAll) 
 * 
 * c) Det är olämpligt om man vill ha full kontroll över sin kod, hur lång tid vissa
 * saker tar och göra det så effektivt som möjligt, samt om man vill lägga till
 * metoder som inte finns i klassen man delegerar 
 * 
 * d) jag är säker om jag skrivit jättebra tester i JUnit, vilket jag inte har
 * 
 *
 */
