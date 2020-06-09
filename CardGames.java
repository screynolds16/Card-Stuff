import java.util.*;

public class CardGames{
  public static void main(String[] args) {
    //playWar();
    playGoFish();
  }

  //simulated game of war between two players
  //counts turns for each game and average turns over 10 games
  public static void playWar(){
    ArrayList<Integer> turnCounts = new ArrayList<Integer>();
    boolean funOver = false;
    int gameCounter = 0;
    while(!funOver){
      gameCounter++; 
      int turnCounter = 0;
      CardDeck deck = new CardDeck();
      deck.shuffleDeck();
      //deck.printDeck();
      PlayerDeck playerOne = new PlayerDeck();
      PlayerDeck playerTwo = new PlayerDeck();
      for(int i = 0; i < deck.numCards; i++){
        
        if(i%2 == 0){
          playerOne.addCard(deck.getCard(i));
        }
        else{
          playerTwo.addCard(deck.getCard(i));
        }
      }

      /*System.out.println("THIS IS PLAYER ONE'S HAND");
      playerOne.printDeck();
      System.out.println("THIS IS PLAYER TWO'S HAND");
      playerTwo.printDeck();*/
      boolean gameOver = false;
      Card pOneCard = new Card();
      Card pTwoCard = new Card();
      JunkPile pOneJunk = new JunkPile();
      JunkPile pTwoJunk = new JunkPile();
      List<Card> thisHand = new ArrayList<Card>();
      Queue<Card> addPile = new LinkedList<Card>();
      int addPileLength = 0;
      while(!gameOver){
        
        while(playerOne.numCards > 0 && playerTwo.numCards > 0){
          /*System.out.println("Type yes to continue. Type no to rage quit");
          Scanner scan = new Scanner(System.in);
          String s = scan.next();*/
          boolean turn = true;
          //if(s.equals("no")){
          //  break;
          //}
          while(turn){
            turnCounter++;
            pOneCard=playerOne.playCard();
            pTwoCard=playerTwo.playCard();
            thisHand.add(pOneCard);
            thisHand.add(pTwoCard);
            System.out.print("Player one played: ");
            pOneCard.printCard();
            System.out.print("Player two played: ");
            pTwoCard.printCard();
            if(pOneCard.getValue() > pTwoCard.getValue()){
              System.out.println("Player One wins this hand");
              for(int i = 0; i < thisHand.size(); i++){
                pOneJunk.addCard(thisHand.get(i));
              }
              
              thisHand.clear();
              turn = false;
            }
            else if(pOneCard.getValue() < pTwoCard.getValue()){
              System.out.println("Player Two wins this hand");
              for(int i = 0; i < thisHand.size(); i++){
                pTwoJunk.addCard(thisHand.get(i));
              }
              
              thisHand.clear();
              turn = false;
            }
            else{
              System.out.println("PLAYERS TIED!");
              if(playerOne.numCards < 4){
                addPile = pOneJunk.getPile();
                addPileLength = addPile.size();
                for(int i = 0; i < addPileLength; i++){
                  playerOne.addCard(addPile.poll());
                }
              }
              if(playerTwo.numCards < 4){
                addPile = pTwoJunk.getPile();
                addPileLength = addPile.size();
                for(int i = 0; i < addPileLength; i++){
                  playerTwo.addCard(addPile.poll());
                }
              }

              if(playerTwo.numCards < 4){
                System.out.println("Player One Wins!!!");
                gameOver = true;
                break;
              }
              if(playerOne.numCards < 4){
                System.out.println("Player Two Wins!!!");
                gameOver = true;
                break;
              }
              for(int i = 0; i < 3; i++){
                thisHand.add(playerOne.playCard());
                thisHand.add(playerTwo.playCard());
              }
            }
            
          }
          System.out.println("Turn number" + turnCounter);
          System.out.println("Player One's cardCount" + playerOne.numCards);
          System.out.println("Player One's JunkPile");
          pOneJunk.printDeck();
          System.out.println("Player two's cardcount: " + playerTwo.numCards);
          System.out.println("Player Two's JunkPile");
          pTwoJunk.printDeck();
          
        }
        if(playerOne.numCards == 0){
          if(pOneJunk.numCards == 0){
            System.out.println("Player Two Wins!!!");
            gameOver = true;
          }
          else{
            addPile = pOneJunk.getPile();
            addPileLength = addPile.size();
            for(int i = 0; i < addPileLength; i++){
              playerOne.addCard(addPile.poll());
            }
          }
        }
        if(playerTwo.numCards == 0){
          if(pTwoJunk.numCards == 0){
            System.out.println("Player One Wins!!!");
            gameOver = true;
          }
          else{
            addPile = pTwoJunk.getPile();
            addPileLength = addPile.size();
            for(int i = 0; i < addPileLength; i++){
              playerTwo.addCard(addPile.poll());
            }
          }
        }
      }

      System.out.println("GG's" + gameOver);
      if(turnCounts.size() == 9){
        System.out.println("Suck my balls hori");
        funOver = true;
        turnCounts.add(turnCounter);
      }
      else{
        
        turnCounts.add(turnCounter);
        turnCounter = 0;
      }
    }
    System.out.println("That took " + turnCounts.size() + "games");
    int average = 0;
    int lowest = 9999999;
    for(int i = 0; i < turnCounts.size(); i++){
      System.out.println(turnCounts.get(i));
      average += turnCounts.get(i);
      if(turnCounts.get(i) < lowest)
        lowest = turnCounts.get(i);  
    }
    System.out.println("lowest turns: " + lowest);
    average = average/turnCounts.size();
    System.out.println("Average turns: " + average);
  }

  public static void playGoFish(){
  	CardDeck deck = new CardDeck();
  	deck.shuffleDeck();
  	int numPlayers = 4;
    ArrayList<Card> stolen = new ArrayList<Card>();

  	ArrayList<PlayerDeckFish> playerHands = new ArrayList<PlayerDeckFish>();
    ArrayList<JunkPile> playerPiles = new ArrayList<JunkPile>();
  	for(int i = 0; i < numPlayers; i++){
  		playerHands.add(i, new PlayerDeckFish());
      playerPiles.add(i, new JunkPile());
  	}
  	for(int i = 0; i < 5*numPlayers; i++){
  		playerHands.get(i%numPlayers).addCard(deck.dealCard());
  	}
    //print out player hands at start
    
    
    

    int turnCounter = 0;
    boolean gameOver = false;
    boolean turnOver = false;
    while(!gameOver){
      turnOver = false;
      while(!turnOver){

        /*print hands*/
        System.out.println("Player 0's hand :" );
        playerHands.get(0).printDeck();
        System.out.println("");
        System.out.println("Player 1's hand :" );
        playerHands.get(1).printDeck();
        System.out.println(" ");
        System.out.println("Player 2's hand :" );
        playerHands.get(2).printDeck();
        System.out.println("");
        System.out.println("Player 3's hand :" );
        playerHands.get(3).printDeck();
        System.out.println("");
        /*end print hands*/

        System.out.println("Player " + turnCounter%numPlayers + ", which player would you like to ask?");
        Scanner scan = new Scanner(System.in);
        int drawFrom = scan.nextInt();
        System.out.println("Player " + turnCounter%numPlayers + ", which card would you like to ask for?");
        int drawNum = scan.nextInt();

        stolen = playerHands.get(drawFrom).stealThese(drawNum);
        if(stolen.size() < 1){
          System.out.println("GO FISH! you're being dealt another card from the deck");
          playerHands.get(turnCounter%numPlayers).addCard(deck.dealCard());
          turnOver = true;
        }
        else{
          System.out.println("You stole " + stolen.size() + " cards from player " + drawFrom);
          for(int i = 0; i < stolen.size(); i++){
            playerHands.get(turnCounter%numPlayers).addCard(stolen.get(i));
          }
        }
        stolen.clear();
       
      }

      

      int check = 0;
      int instances = 0;
      PlayerDeckFish thisPlayer = playerHands.get(turnCounter%numPlayers);
      for(int i = 0; i < thisPlayer.getSize() - 3; i++){
        check = thisPlayer.getCardAt(i).getValue();
        instances = 1;
        for(int j = i+1; j < thisPlayer.getSize(); j++){
          if(thisPlayer.getCardAt(j).getValue() == check){
            instances++;
          }
          if(instances == 4){
            System.out.println("Adding the " + check + " cards to player " + turnCounter%numPlayers + "'s pile");
            stolen = thisPlayer.stealThese(check);
            for(int x = 0; x < stolen.size(); x++){
              playerPiles.get(turnCounter%numPlayers).addCard(stolen.get(x));
            }
          }
        }
      }

      /*print hands*/
      System.out.println("Player 0's hand :" );
      playerHands.get(0).printDeck();
      System.out.println("");
      System.out.println("Player 1's hand :" );
      playerHands.get(1).printDeck();
      System.out.println(" ");
      System.out.println("Player 2's hand :" );
      playerHands.get(2).printDeck();
      System.out.println("");
      System.out.println("Player 3's hand :" );
      playerHands.get(3).printDeck();
      System.out.println("");
      /*end print hands*/

      turnCounter++;
    }
  }
}

//test 