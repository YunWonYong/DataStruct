package list;

public class List<T> {
	private T[] array;
	private int size;
	private int capacity;
	private final static int DEFAULT_CAPCITY = 10;

	public List() {
		this(DEFAULT_CAPCITY);
	}
	
	public List(int capacity) {
		this.capacity = capacity;
		this.array = getArray(capacity);
	}

	public boolean add(T element) {
		try {
			if (size == capacity) {
				extend();
			}
			array[size++] = element;
		} catch (Exception e) {
			return false;

		}
		return true;
	}
	
	public void add(int index, T element) {
		try {
			array[index] = element;
			size++;
		} catch(IndexOutOfBoundsException e) {
			throw e;
		}
	}
	
	public T get(int index) {
		if(isEmpty()) {
			return null;
		}
		if (size <= index) {
			return null;
		}
		return array[index];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
 
	public void extend() {
		T[] temp = array;
		this.capacity <<= 1;
		array = getArray(this.capacity);
		System.arraycopy(temp, 0, array, 0, temp.length);
	}
	
	@SuppressWarnings("unchecked")
	private T[] getArray(int capacity) { 
		T[] array = (T[]) new Object[capacity];
		return array;
	}
}
