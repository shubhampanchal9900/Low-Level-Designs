package LRU;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

class LRUCache{

    private final int capacity;
    private final Map<Integer, Node> cache;

    private final Node head;
    private final Node tail;

    private final ReentrantLock lock;



    public LRUCache(int capacity, ReentrantLock lock){

        this.capacity=capacity;
        this.lock = new ReentrantLock();
        this.cache =new HashMap<>();

        head =new Node(0,0);
        tail=new Node(0,0);

        head.next=tail;
        tail.prev=head;
    }


    private void addToHead(Node node){

        node.prev=head;
        node.next=head.next;

        head.next.prev=node;
        head.next =node;
    }

    private void removeNode(Node node){
      node.prev.next=node.next;
      node.next.prev=node.prev;
    }


    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail(){
        Node lru=tail.prev;
        removeNode(lru);
        return lru;
    }


    public int get(int key){
        lock.lock();
        try {
            Node node=cache.get(key);
            if(node==null){
                return -1;
            }
            moveToHead(node);
            return node.value;
        }finally {
                lock.unlock();
        }
    }

    public void put(int key,int value){
        lock.lock();
        try {
            Node node=cache.get(key);

            if(node!=null){
                node.value=value;
                moveToHead(node);
            }else{
                Node newNode=new Node(key, value);
                cache.put(key,newNode);
                addToHead(newNode);

                if(cache.size() > capacity){
                    Node lru=removeTail();
                    cache.remove(lru);
                }
            }
        }finally {
            lock.unlock();
        }

    }
}