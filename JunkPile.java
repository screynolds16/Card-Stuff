import java.util.*;

public class JunkPile{
  public int numCards = 0;
  ArrayList<Card> wonPile = new ArrayList<Card>();
  public JunkPile(){
  }

  public void addCard(Card toAdd){
    wonPile.add(toAdd);
    numCards++;
  }

  public Queue<Card> getPile(){
    Collections.shuffle(wonPile);
    Queue<Card> returnThis = new LinkedList<Card>();
    for(int i = 0; i < numCards; i++){
      returnThis.add(wonPile.remove(0));
    }  
    numCards = 0;
    return returnThis;
  }

  public void printDeck(){
    for(Card card : wonPile)
      System.out.println(card.getValue() + " of " + card.getSuit());
  }
}