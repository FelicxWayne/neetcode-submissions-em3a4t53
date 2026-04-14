class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key,int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public void insertAtFront(Node node){
        Node nxt = head.next;
        head.next = node;
        node.prev = head;
        node.next = nxt;
        nxt.prev = node;
    }

    public void remove(Node node){
        Node bef = node.prev;
        Node aft = node.next;
        bef.next = aft;
        aft.prev = bef;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertAtFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertAtFront(node);
        }
        else{
            if(map.size() == capacity){
                Node temp = tail.prev;
                int tempKey = temp.key;
                remove(temp);
                map.remove(tempKey);
            }
            Node newNode = new Node(key,value);
            newNode.key = key;
            newNode.val = value;
            map.put(key,newNode);
            insertAtFront(newNode);
        }
    }
}
