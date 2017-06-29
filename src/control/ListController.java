package control;

import model.List;

/**
 * Created by tkasi on 29.06.2017.
 */
public class ListController {
    private List<Integer> list = new List<>();

    /**
     * Die Länge der Liste wird mithilfe des internen Zeigers der Liste ermittelt
     * @return size : Die Länge der Liste
     */
    public int getSize(){
        int size = 0;
        if(!list.isEmpty()){
            list.toFirst();
            while(list.hasAccess()){
                list.next();
                size++;
            }
        }
        return size;
    }

    public List<Integer> getList(){
        return list;
    }
}
