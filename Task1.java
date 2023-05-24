import java.util.*;

public class Task1 {
	public static void main(String[] args) {
	mySet mySet = new mySet();
	myTreeSet myTreeSet = new myTreeSet();

//	mySet.add(8);
	for (int i = 0; i < 5; i++) {
		mySet.add(new Random().nextInt(10));
		myTreeSet.add(new Random().nextInt(10));
	}
	System.out.println(mySet.contains(8));
	System.out.println(Arrays.toString(mySet.toArray()));
	System.out.println(Arrays.toString(myTreeSet.toArray()));
    Iterator<Integer> iterator = myTreeSet.iterator();

    while (iterator.hasNext()) {
        System.out.print(iterator.next() + ", ");
    }
	System.out.println();
	System.out.println(mySet.getItem(1));
	}
}

class mySet {
	//	private HashMap<Integer, Object> hashMap  = new HashMap<>();
		private LinkedHashMap<Integer, Object> hashMap  = new LinkedHashMap<>();
		static final Object OBJECT = new Object();
		
		public boolean add(int num) {
			return hashMap.put(num, OBJECT) == null;
		}
	
		public boolean contains(int num) {
			return hashMap.containsKey(num);
		}
	
		public Object[] toArray() {
			return hashMap.keySet().toArray();
		}
	
		public Iterator<Integer> iterator() {
			return hashMap.keySet().iterator();
		}
	
		public Integer getItem(int index) {
			return (Integer) toArray()[index];
		}
	//первый пример
	/* 	private ArrayList<Integer> list = new ArrayList<>();
		
		public boolean add(int num){
			if (!list.contains(num)) {
				list.add(num);
				return true;
			}
		} */
	}

class myTreeSet {
	//	private HashMap<Integer, Object> hashMap  = new HashMap<>();
	//	private TreeMap<Integer, Object> treeMap  = new TreeMap<>();
	private Comparator<Integer> comparator;
	public myTreeSet() {
		comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
	}		
	static final Object OBJECT = new Object();

	private TreeMap<Integer, Object> treeMap  = new TreeMap<>(comparator);
		
	public boolean add(int num) {
		return treeMap.put(num, OBJECT) == null;
	}
	
	public boolean contains(int num) {
		return treeMap.containsKey(num);
	}
	
	public Object[] toArray() {
		return treeMap.keySet().toArray();
	}
	
	public Iterator<Integer> iterator() {
		return treeMap.keySet().iterator();
	}
	
	public Integer getItem(int index) {
		return (Integer) toArray()[index];
	}

}

