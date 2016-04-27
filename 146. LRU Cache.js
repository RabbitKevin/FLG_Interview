/**
 * @constructor
 */
var LRUCache = function(capacity) {
    this.size = capacity;
    this.dic = {};//map
    this.head = new DBListNode(-1);
    this.trail = new DBListNode(-1);
    //-------------------//
    this.head.next = this.trail;
    this.trail.prev = this.head;
};

/**
 * @param {number} key
 * @returns {number}
 */
LRUCache.prototype.get = function(key) {
    if(!(key in this.dic)) return -1;
    var node = this.dic[key];
    var value = node.val;
    //-------------------//
    var prev = node.prev;
    var next = node.next;
    prev.next = next;
    next.prev = prev;
    //------------------//
    prev = this.head;
    next = head.next;
    prev.next = node;
    node.next = next;
    next.prev = node;
    node.prev = head;
    return value;
};

/**
 * @param {number} key
 * @param {number} value
 * @returns {void}
 */
LRUCache.prototype.set = function(key, value) {
    if(key in this.dic) {
        this.dic[key] = value;
        this.update(key);
    }
    else {
        if(Object.keys(this.dic).length == this.size) {
            var node = this.dic[this.trail.prev];
            this.dic.delete(node.key);
            node.key = key;
            node.val = value;
            this.dic[key] = node;
            update(key);
        }
        else {
            var tmp = new DBListNode(key, value);
            this.dic[key] = tmp;
            var first = this.head.next;
            this.head.next = tmp;
            tmp.next = first;
            first.prev = tmp;
            tmp.prev = this.head;
        }
    }
}

var DBListNode = function(val, key) {
    this.val = val;
    this.key = key;
    this.prev = null;
    this.next = null;
}
