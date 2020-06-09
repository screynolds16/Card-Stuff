import java.util.*;

public class PlayerDeckFish{
  public int numCards = 0;
  ArrayList<Card> playerDeck = new ArrayList<Card>();

  public PlayerDeckFish(){   
  }
  
  public void addCard(Card toAdd){
    playerDeck.add(toAdd);
    numCards++;
  }

  
  public Card getCardAt(int index){
    
    return playerDeck.get(index);
  }
  

  public int getSize(){
    return numCards;
  }
  public void printDeck(){
    for(Card card : playerDeck)
      System.out.println(card.getValue() + " of " + card.getSuit());
  }

  public ArrayList<Card> stealThese(int val){
    ArrayList<Card> result = new ArrayList<Card>();
    for(int i = 0; i < numCards; i++){
      if(playerDeck.get(i).getValue() == val){
        result.add(playerDeck.remove(i));
        numCards--;
        i--;
      }
    }

    return result;
  }

}