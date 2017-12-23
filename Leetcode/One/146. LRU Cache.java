class LRUCache {

    public Map<Integer, Node> map;
    public List<Node> valueList;
    public int size;
    private Node leastUsedBound;
    private Node mostUsedBound;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        valueList = new LinkedList<>();
        leastUsedBound = new Node(-1, -1);
        mostUsedBound = new Node(-1, -1);
        setUpValueListBound();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            removeNodeFromList(node);
            moveToMostUsed(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node= map.get(key);
            node.val = value;
            removeNodeFromList(node);
            moveToMostUsed(node);
        } else {
            if(map.size() >= size) {
                deleteLeastUsed();
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToMostUsed(node);
        }
    }
    /**
        Botton node as most recent used node
    */
    private void moveToMostUsed(Node node) {
        Node currentMostUsed = mostUsedBound.before;
        currentMostUsed.next = null;
        currentMostUsed.next = node;
        node.before = currentMostUsed;
        node.next = mostUsedBound;
        mostUsedBound.before = node;
    }
    /**
        Remove delete least used
    */
    private void deleteLeastUsed() {
        Node currentLeastUsed = leastUsedBound.next;
        Node nextLeastUsed = currentLeastUsed.next;
        leastUsedBound.next = nextLeastUsed;
        nextLeastUsed.before = leastUsedBound;
        currentLeastUsed.before = null;
        currentLeastUsed.next = null;
        map.remove(currentLeastUsed.key);
    }
    /**
        Set up value list
    */
    private void setUpValueListBound() {
        valueList.add(leastUsedBound);
        valueList.add(mostUsedBound);
        leastUsedBound.next = mostUsedBound;
        mostUsedBound.before = leastUsedBound;
    }

    private void removeNodeFromList(Node node) {
        Node before = node.before;
        Node next = node.next;
        before.next = next;
        next.before = before;
    }
}

class Node {
    int val;
    int key;
    Node before;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.val = value;
        before = null;
        next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
