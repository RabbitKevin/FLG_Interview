public class LRUCache {
    int size;
    Map<Integer, ValueNode> map;
    ValueNode start;
    ValueNode end;
    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<Integer, ValueNode>();
        start = new ValueNode(-1,-1);
        end = new ValueNode(-1,-1);
        start.next = end;
        end.prev = start;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ValueNode value = map.get(key);
        ValueNode prev = value.prev;
        ValueNode next = value.next;
        prev.next = next;
        next.prev = prev;
        setFirst(value);
        return value.val;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
        }
        else {
            if(map.size() == size) removeLast();
            ValueNode node = new ValueNode(value, key);
            setFirst(node);
            map.put(key, node);
        }
    }

    private void setFirst(ValueNode node) {
        ValueNode first = start.next;
        start.next = node;
        node.prev = start;
        node.next = first;
        first.prev = node;
    }

    private void removeLast() {
        ValueNode last = end.prev;
        int key = last.key;
        end = last;
        end.next = null;
        map.remove(key);
    }
    class ValueNode {
        int key;
        int val;
        ValueNode prev;
        ValueNode next;
        public ValueNode(int val, int key) {
            this.val = val;
            this.key = key;
            prev = null;
            next = null;
        }
    }
}
