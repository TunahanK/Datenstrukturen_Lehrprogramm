package model;

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018
 * </p>
 * <p>
 * Klasse Vertex
 * </p>
 * <p>
 * Die Klasse Vertex stellt einen einzelnen Knoten eines Graphen dar. Jedes Objekt 
 * dieser Klasse verfuegt ueber einen Inhalt als ContentType und kann diesen
 * Inhalt zurueckliefern. Darueber hinaus kann eine Markierung gesetzt und abgefragt werden.
 * </p>
 * 
 * @author Tunahan Kasimay
 * @version Juni 2017
 */
public class Vertex<ContentType>{
  private ContentType content;
  private boolean mark;
  
  /**
  * Ein neues Objekt vom Typ Vertex wird erstellt. Seine Markierung hat den Wert false.
  */
  public Vertex(ContentType pContent){
    content = pContent;
    mark = false;
  }
  
  /**
  * Die Anfrage liefert den Inhalt des Knotens.
  */
  public ContentType getContent(){
    return content;
  }
  
  /**
  * Der Auftrag setzt die Markierung des Knotens auf den Wert pMark.
  */
  public void setMark(boolean pMark){
    mark = pMark;
  }
  
  /**
  * Die Anfrage liefert true, wenn die Markierung des Knotens den Wert true hat, ansonsten false.
  */
  public boolean isMarked(){
    return mark;
  }

}
