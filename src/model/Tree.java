package model;


public class Tree<ContentType> {


	/* --------- Anfang der privaten inneren Klasse -------------- */

    /**
     * Durch diese innere Klasse kann man dafuer sorgen, dass ein leerer Baum
     * null ist, ein nicht-leerer Baum jedoch immer eine nicht-null-Wurzel sowie
     * nicht-null-Teilbaeume, ggf. leere Teilbaeume hat.
     */
    private class TNode<CT> {

        private CT content;
        private List<Tree> nextTrees;

        public TNode(CT pContent) {
            // Der Knoten hat einen linken und einen rechten Teilbaum, die
            // beide von null verschieden sind. Also hat ein Blatt immer zwei
            // leere Teilbaeume unter sich.
            this.content = pContent;
            this.nextTrees = new List<>();
        }
    }

	/* ----------- Ende der privaten inneren Klasse -------------- */

    private TNode<ContentType> node;

    /**
     * Nach dem Aufruf des Konstruktors existiert ein leerer Binaerbaum.
     * Ein Baum ist leer, wenn seine node-Referenz leer ist.
     */
    public Tree() {
        this.node = null;
    }

    /**
     * Wenn der Parameter pContent ungleich null ist, existiert nach dem Aufruf
     * des Konstruktors der Binaerbaum und hat pContent als Inhaltsobjekt und
     * zwei leere Teilbaeume. Falls der Parameter null ist, wird ein leerer
     * Binaerbaum erzeugt.
     *
     * @param pContent
     *            das Inhaltsobjekt des Wurzelknotens vom Typ CT
     */
    public Tree(ContentType pContent) {
        if(pContent != null){
            this.node = new TNode<>(pContent);
        }else{
            this.node = null;
        }
    }

    /**
     * Diese Anfrage liefert den Wahrheitswert true, wenn der Binaerbaum leer
     * ist, sonst liefert sie den Wert false.
     *
     * @return true, wenn der Binaerbaum leer ist, sonst false
     */
    public boolean isEmpty() {
        return this.node == null;
    }

    /**
     * Wenn pContent null ist, geschieht nichts. <br />
     * Ansonsten: Wenn der Binaerbaum leer ist, wird der Parameter pContent als
     * Inhaltsobjekt sowie ein leerer linker und rechter Teilbaum eingefuegt.
     * Ist der Binaerbaum nicht leer, wird das Inhaltsobjekt durch pContent
     * ersetzt. Die Teilbaeume werden nicht geaendert.
     *
     * @param pContent
     *            neues Inhaltsobjekt vom Typ CT
     */
    public void setContent(ContentType pContent) {
        if(pContent != null){
            if(isEmpty()){
                this.node = new TNode<>(pContent);
            }else {
                this.node.content = pContent;
            }
        }
    }

    /**
     * Diese Anfrage liefert das Inhaltsobjekt des Binaerbaums. Wenn der
     * Binaerbaum leer ist, wird null zurueckgegeben.
     *
     * @return das Inhaltsobjekt der Wurzel vom Typ CT bzw. null, wenn
     *         der Binaerbaum leer ist
     */
    public ContentType getContent() {
        if(isEmpty()){
            return null;
        }
        return this.node.content;
    }

    public void setNextTree(Tree<ContentType> pTree){
        if(pTree != null && isEmpty()){
            node.nextTrees.append(pTree);
        }
    }

    public List<Tree> getNextTree(){
        return node.nextTrees;
    }

    public Tree getNextTreeAt(int index){
        if(index >= 0){
            node.nextTrees.toFirst();
            for(int i = 0; i < index; i++){
                node.nextTrees.next();
            }
            return node.nextTrees.getContent();
        }
        return null;
    }
}
