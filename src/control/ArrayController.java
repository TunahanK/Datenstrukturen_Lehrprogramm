package control;

/**
 * Created by tkasi on 29.06.2017.
 */
public class ArrayController {
    private int[] intArray;

    public ArrayController(){
    }

    /**
     * intArray wird mit dem Parameter "size" initialisiert
     * @param size eine Größe, was festgelegt wird, um die Länge des Arrays zu bestimmen
     */
    public void setArrayLength(int size){
        intArray = new int[size];
    }

    /**
     * Der oben initialisierte Array, wird mit zufälligen Zahlen zwischen 0 und 19 gefüllt
     */
    public void fillRandom(){
        for(int i = 0; i < intArray.length; i++){
            intArray[i] = (int)(Math.random()*20);
        }
    }

    /**
     * @return intArray wird zurückgeliefert
     */
    public int[] getArray(){
        return intArray;
    }
}
