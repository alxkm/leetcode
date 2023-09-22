# Leetcode


Java cheatsheet:

Array {
    
    Arrays.stream(givenArray).sum();
    
    int minimumValue = Arrays.stream(givenArray).min().getAsInt();

    int MaxmumValue =  Arrays.stream(givenArray).max().getAsInt();

    Collections.reverse(Arrays.asList(a));

    Person maxByAge = Arrays.stream(persons).max(Comparator.comparing(Car::getAge)).orElseThrow(NoSuchElementException::new);

    // Arrays.fill(arr, -1)
    int[] arr = new int[5];
    Arrays.fill(arr, -1);

    // Arrays.asList()
    List<String> fruitsList = Arrays.asList("apple", "banana", "orange");

    // asList()
    java.util.List<String> list = Arrays.asList("apple", "banana", "orange");

    // binarySearch(array, fromIndex, toIndex, key, Comparator)
    int[] array = {10, 20, 30, 40, 50};
    int index = Arrays.binarySearch(array, 1, 4, 30, (a, b) -> a - b);

    // binarySearch()
    int[] sortedArray = {1, 2, 3, 4, 5};
    int index2 = Arrays.binarySearch(sortedArray, 3);

    // compare(array1, array2)
    int[] array1 = {1, 2, 3};
    int[] array2 = {1, 2, 3};
    int result = Arrays.compare(array1, array2);

    // copyOf(originalArray, newLength)
    int[] originalArray = {1, 2, 3, 4, 5};
    int[] newArray = Arrays.copyOf(originalArray, 3);

    // copyOfRange(originalArray, fromIndex, endIndex)
    int[] newRangeArray = Arrays.copyOfRange(originalArray, 1, 4);

    // deepEquals(Object[] a1, Object[] a2)
    Integer[] arrayA = {1, 2, 3};
    Integer[] arrayB = {1, 2, 3};
    boolean isEqual = Arrays.deepEquals(arrayA, arrayB);

    // deepToString(Object[] a)
    Integer[][] twoDArray = {{1, 2, 3}, {4, 5, 6}};
    String deepToString = Arrays.deepToString(twoDArray);

    // fill(originalArray, fillValue)
    int[] fillArray = new int[5];
    Arrays.fill(fillArray, 42);

    // sort(originalArray)
    int[] unsortedArray = {5, 2, 8, 1, 3};
    Arrays.sort(unsortedArray);

    // stream(originalArray)
    int[] arrayStream = {1, 2, 3};
    java.util.stream.Stream<int[]> stream = Arrays.stream(arrayStream);

    // toString(originalArray)
    int[] arrayToString = {1, 2, 3};
    String arrayString = Arrays.toString(arrayToString);

}

Collections {
    
    // List
    List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 3));

    // Collections.sort
    // Collections.sort(list) sorts the list in natural order.
    Collections.sort(list);
    
    // Custom comparator
    Collections.sort(personList, Comparator.comparingInt(Person::getAge));
    
    // Sort numbers in reverse order using custom Comparator
    Collections.sort(numbers, (num1, num2) -> num2 - num1);

    // Collections.binarySearch
    // Collections.binarySearch(list, 5) performs a binary search 
    // on the sorted list and returns the index of the element 5 (if found), or a negative value if not found.
    //    
    int index = Collections.binarySearch(list, 5);

    // Collections.indexedBinarySearch
    // Collections.indexedBinarySearch(list, 0, list.size(), 5, (a, b) -> a - b) 
    // performs a binary search on the specified range of the sorted list using a custom comparator
    //  
    int customComparatorIndex = Collections.indexedBinarySearch(list, 0, list.size(), 5, (a, b) -> a - b);

    // Collections.reverse
    // Collections.reverse(list) reverses the order of elements in the list
    Collections.reverse(list);

    // Collections.swap
    // Collections.swap(list, 0, list.size() - 1) swaps the elements at index 0 and the last index in the list
    Collections.swap(list, 0, list.size() - 1);

    // Collections.fill
    // Collections.fill(list, 0) replaces all elements in the list with the value 0.
    Collections.fill(list, 0);

    // Collections.min
    // Collections.min(list) finds the minimum value in the list
    int minValue = Collections.min(list);

    // Collections.max
    // Collections.max(list) finds the maximum value in the list.
    int maxValue = Collections.max(list);

    // Collections.rotate
    // Collections.rotate(list, 2) rotates the elements in the list by 2 positions to the right.
    Collections.rotate(list, 2);


    // List
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    Collections.reverse(list);

    // Set
    Set<String> set = new HashSet<>(Arrays.asList("apple", "banana", "orange"));
    boolean isApplePresent = Collections.disjoint(set, Collections.singleton("apple"));

    // Map
    Map<String, Integer> map = new HashMap<>();
    map.put("apple", 10);
    map.put("banana", 5);
    int maxValue = Collections.max(map.values());

    // Queue
    Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
    queue.offer(5);
    
    Collections.sort(listOfNumbers);
    Collections.reverse(Arrays.asList(a));
    
    Map<String, String> treemap =new TreeMap<String, String>(Collections.reverseOrder());
    treeMap.containsKey(keyElement)
    treeMap.containsValue(valueElement)


    List<Integer> al = new ArrayList<Integer>();
    Integer[] arr = new Integer[al.size()];
    arr = al.toArray(arr);

}


Math {

    static double ceil(double a) 

    static long abs(long a) 

    static double min(double a, double b) 

    static double max(double a, double b) 

    static double sqrt(double a) 

    static double pow(double a, double b)
}

Character {

    static int getNumericValue(char ch)

    static int getNumericValue(int codePoint)

    static boolean isDigit(char ch)

    static boolean isLetter(char ch)

    static boolean isLetterOrDigit(char ch)

    static boolean isLowerCase(char ch)

    static boolean isSpaceChar(char ch)

    static boolean isUpperCase(char ch)

    static boolean isWhitespace(char ch)

	static char toLowerCase(char ch)

    static int toUpperCase(int codePoint)  
}


String {
    String listString = String.join(", ", list);

    charAt(int index)

    String concat(String str)

    boolean contains(CharSequence s)

    boolean endsWith(String suffix)

    void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)

    int indexOf(int ch)

    String intern()

    boolean isEmpty()

    int lastIndexOf(int ch)

    int lastIndexOf(int ch, int fromIndex)

    int lastIndexOf(String str)

    int lastIndexOf(String str, int fromIndex)

    int length()

    String replace(char oldChar, char newChar)

    String replace(CharSequence target, CharSequence replacement)

    String replaceAll(String regex, String replacement)

    String replaceFirst(String regex, String replacement)

    String[] split(String regex)

    boolean startsWith(String prefix)

    boolean startsWith(String prefix, int toffset)

    CharSequence subSequence(int beginIndex, int endIndex)

    String substring(int beginIndex)

    String substring(int beginIndex, int endIndex)

    char[] toCharArray()

    String toLowerCase()

    String toUpperCase()

    String trim()
}

StringBuilder {

    StringBuilder append(char c)

    char charAt(int index)

    StringBuilder delete(int start, int end)

    StringBuilder deleteCharAt(int index)
    
    void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)

    int indexOf(String str)

    int indexOf(String str, int fromIndex)

    StringBuilder insert(int offset, boolean b)

    int length()

    StringBuilder replace(int start, int end, String str)

    StringBuilder reverse()

    void setCharAt(int index, char ch)

    CharSequence subSequence(int start, int end)

    String substring(int start)
}

Queue, Stack, Deque, PriorityQueue {

    // PriorityQueue with custom comparator for priority
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    priorityQueue.add(5);
    priorityQueue.add(2);
    priorityQueue.add(8);

    // Queue examples with some popular methods
    Queue<String> queue = new LinkedList<>();
    queue.offer("John");
    queue.offer("Alice");
    String frontElement = queue.poll();

    // Stack
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    int topElement = stack.pop();

}

Deque {

        // Deque
        Deque<Integer> deque = new ArrayDeque<>();

        // Adding elements to the Deque
        deque.addFirst(1);         // [1]
        deque.addLast(2);          // [1, 2]
        deque.offerFirst(0);       // [0, 1, 2]
        deque.offerLast(3);        // [0, 1, 2, 3]

        // Getting elements from the Deque
        int firstElement = deque.peekFirst();     // Returns 0
        int lastElement = deque.peekLast();       // Returns 3
        int removedFirst = deque.pollFirst();     // Removes and returns 0
        int removedLast = deque.pollLast();       // Removes and returns 3

        // Size and clearing
        int size = deque.size();                  // Returns 2
        boolean isEmpty = deque.isEmpty();        // Returns false
        deque.clear();                           // Clears the deque, now it's empty

        // Iterating through the Deque
        Deque<String> stringDeque = new LinkedList<>();
        stringDeque.addAll(Arrays.asList("apple", "banana", "orange"));

        for (String fruit : stringDeque) {
            System.out.print(fruit + " ");        // Output: apple banana orange
        }

}

PriorityQueue {

    // Create a PriorityQueue with a custom comparator for priority
    PriorityQueue<Person> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Person::getPriority));

    // Add persons to the priority queue
    priorityQueue.add(new Person("Alice", 2));
    priorityQueue.add(new Person("Bob", 3));
    priorityQueue.add(new Person("John", 1));
    priorityQueue.add(new Person("Mary", 2));

    // Priority Queue will be sorted based on the priority value (1, 2, 2, 3)

    // Retrieve the person with the highest priority
    Person highestPriorityPerson = priorityQueue.peek();

    System.out.println("Priority Queue:");
    while (!priorityQueue.isEmpty()) {
        Person person = priorityQueue.poll();
        System.out.println("Name: " + person.getName() + ", Priority: " + person.getPriority());
    }

}

Set {

    Set<String> set1 = new HashSet<>();
    set1.add("apple");
    set1.add("banana");
    set1.add("orange");
    set1.add("grape");

    Set<String> set2 = new HashSet<>();
    set2.add("banana");
    set2.add("mango");

    // Retain only the elements present in set2
    set1.retainAll(set2);

}