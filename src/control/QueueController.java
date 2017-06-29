package control;

import model.Queue;

/**
 * Created by tkasi on 29.06.2017.
 */
public class QueueController {
    private Queue<Integer> queue = new Queue<>();

    /**
     * Die länge der Queue wird mithilfe eienr Hilfsqueue ermittelt
     * @return size : Die länge der Queue
     */
    public int getSize(){
        Queue<Integer> temp = new Queue<>();
        int size = 0;
        while(!queue.isEmpty()){
            temp.enqueue(queue.front());
            queue.dequeue();
            size++;
        }
        queue = temp;
        return size;
    }

    /**
     * @return Die Queue wird zurückgegeben
     */
    public Queue<Integer> getQueue(){
        return queue;
    }
}
