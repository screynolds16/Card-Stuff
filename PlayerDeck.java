import java.util.*;

public class PlayerDeck{
  public int numCards = 0;
  Queue<Card> playerDeck = new LinkedList<Card>();

  public PlayerDeck(){   
  }
  
  public void addCard(Card toAdd){
    playerDeck.add(toAdd);
    numCards++;
  }

  public Card playCard(){
    numCards--;
    return playerDeck.poll();
  }

  public void printDeck(){
    for(Card card : playerDeck)
      System.out.println(card.getValue() + " of " + card.getSuit());
  }


}