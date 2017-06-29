package control;

import model.Stack;

/**
 * Created by tkasi on 29.06.2017.
 */
public class StackController {
    private Stack<Integer> stack = new Stack<>();

    /**
     * Die länge des Stacks wird mithilfe eines Hilfsstacks ermittelt
     * @return size : Die länge der Stack
     */
    public int getSize(){
        int size = 0;
        if(!stack.isEmpty()){
            Stack<Integer> temp = new Stack<>();
            while(!stack.isEmpty()){
                temp.push(stack.top());
                stack.pop();
                size++;
            }
            while(!temp.isEmpty()){
                stack.push(temp.top());
            }
        }
        return size;
    }

    /**
     * @return Der Stack wird zurückgegeben
     */
    public Stack<Integer> getStack(){
        return stack;
    }
}
