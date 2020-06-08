public class Card{
  private String suit;
  private int value; 

  public Card(){

  }
  public Card(String suit,int value){
    this.suit = suit;
    this.value = value;   
  }
  public int getValue(){
    return value;
  }
  public String getSuit(){
    return suit;
  }

  public void printCard(){
    System.out.println(this.value + " of " + this.suit);
  }
}