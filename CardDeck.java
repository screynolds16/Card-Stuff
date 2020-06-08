import java.util.*;

public class CardDeck{
  public int numCards= 0;
  ArrayList<Card> deck = new ArrayList<Card>();
  public CardDeck(){
    this.createDeck();
  }

  public void createDeck(){
    Card cardToAdd = new Card();
    for(int i = 0; i<52; i++){     //for(Does this once(sets i to 0); checks condtional; increments )
      if(i < 13){
        cardToAdd = new Card("Clubs", i + 1);
      }
      else if(i < 26){
        cardToAdd = new Card("Diamonds", i%13 + 1);  
      }
      else if(i < 39){
        cardToAdd = new Card("Hearts", i%13 + 1);
      }
      else{
        cardToAdd = new Card("Spades", i%13 + 1);
      }
      deck.add(cardToAdd);
      numCards++;
    }
  }

  public Card getCard(int index){
    return deck.get(index);
  }
  public void printDeck(){
    for(Card card : deck)
      System.out.println(card.getValue() + " of " + card.getSuit());
  }

  public void shuffleDeck(){
    Collections.shuffle(deck);
  }
}
