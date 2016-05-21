public class MinStack {
    Node node;
    /** initialize your data structure here. */
    public MinStack() {
        node = null;
    }

    public void push(int x) {
        if(node == null) {
            node = new Node(x, x, null);
        }
        else {
            node = new Node(x, Math.min(x, node.min), node);
        }
    }

    public void pop() {
        node = node.bfe;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }
    class Node{
        int val;
        int min;
        Node bfe;
        public Node(int x, int min, Node n) {
            val = x;
            this.min = min;
            bfe = n;
        }
    }
}
