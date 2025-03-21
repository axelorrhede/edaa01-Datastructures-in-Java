package testqueue;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

class TestAppendFifoQueue {
	private FifoQueue<Integer> myIntQueue;
	private FifoQueue<String> myStringQueue;
	private FifoQueue<Integer> myIntQueue2;
	private FifoQueue<String> myStringQueue2;

	@BeforeEach
	void setUp() throws Exception {
		myIntQueue = new FifoQueue<Integer>();
		myStringQueue = new FifoQueue<String>();
		myIntQueue2 = new FifoQueue<Integer>();
		myStringQueue2 = new FifoQueue<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
		myIntQueue = null;
		myStringQueue = null;
		myIntQueue2 = null;
		myStringQueue2 = null;
	}

	@Test
	void emptyQ() {
		myStringQueue.append(myStringQueue2);
		assertEquals(0, myIntQueue.size(), "Wrong size after offer");
		assertEquals(0, myIntQueue2.size(), "Wrong size after offer");

	}

	@Test
	void sameQ() {
		myStringQueue.offer("test");
		assertThrows(IllegalArgumentException.class, () -> myStringQueue.append(myStringQueue));
	}

	@Test
	void oneEmptyQ() {
		myIntQueue2.offer(1);
		myIntQueue2.offer(2);
		myIntQueue2.offer(3);
		myIntQueue.append(myIntQueue2);
		assertEquals(3, myIntQueue.size(), "Wrong size after offer");
		assertEquals(0, myIntQueue2.size(), "Wrong size after offer");
		for (int i = 1; i < 4; i++) {
			int k = myIntQueue.poll();
			assertEquals(i, k, "poll returns incorrect element");
		}
	}

	@Test
	void anotherEmptyQ() {
		myIntQueue.offer(1);
		myIntQueue.offer(2);
		myIntQueue.offer(3);
		myIntQueue.append(myIntQueue2);
		assertEquals(3, myIntQueue.size(), "Wrong size after offer");
		assertEquals(0, myIntQueue2.size(), "Wrong size after offer");
		for (int i = 1; i < 4; i++) {
			int k = myIntQueue.poll();
			assertEquals(i, k, "poll returns incorrect element");
		}
	}

	@Test
	void twoFullQ() {
		myIntQueue.offer(4);
		myIntQueue.offer(5);
		myIntQueue.offer(6);
		myIntQueue.offer(7);
		myIntQueue.offer(8);
		myIntQueue.offer(9);
		myIntQueue.offer(10);
		myIntQueue2.offer(1);
		myIntQueue2.offer(2);
		myIntQueue2.offer(3);
		myIntQueue2.append(myIntQueue);
		assertEquals(0, myIntQueue.size(), "Wrong size after append");
		assertEquals(10, myIntQueue2.size(), "Wrong size after append");
		for (int i = 1; i < 11; i++) {
			int k = myIntQueue2.poll();
			assertEquals(i, k, "poll returns incorrect element");
		}

	}
	@Test
	void oneInQ() {
		myIntQueue.offer(4);
		myIntQueue2.offer(1);
		myIntQueue2.offer(2);
		myIntQueue2.offer(3);
		myIntQueue2.append(myIntQueue);
		assertEquals(0, myIntQueue.size(), "Wrong size after offer");
		assertEquals(4, myIntQueue2.size(), "Wrong size after offer");
		for (int i = 1; i < 5; i++) {
			int k = myIntQueue2.poll();
			assertEquals(i, k, "poll returns incorrect element");
		}

	}
	@Test
	void anotherOneInQ() {
		myIntQueue.offer(2);
		myIntQueue.offer(3);
		myIntQueue.offer(4);
		myIntQueue2.offer(1);
		myIntQueue2.append(myIntQueue);
		assertEquals(0, myIntQueue.size(), "Wrong size after offer");
		assertEquals(4, myIntQueue2.size(), "Wrong size after offer");
		for (int i = 1; i < 5; i++) {
			int k = myIntQueue2.poll();
			assertEquals(i, k, "poll returns incorrect element");
		}

	}


}
