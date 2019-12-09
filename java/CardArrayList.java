/**
* @author Joshua Levi Flores Rankin
* @version 11/06/2019
*/
import java.util.*;
import java.lang.*;
/**
* This CardArrayList class implements CardList. It allows you to put your cards into an array, and do things
* such as sort, clear, add, etc. to it.
* @implements CardList
*/
public class CardArrayList implements CardList {
   //DEBUGGER for size in array. False sets the cardArrayMaster GUI #12 to true, but
   // set to true if you want to follow the instructions on canvas.
   private boolean DEBUGsizeTest = false;
   //Variables
   private int size = 0;
   private Card[] cardArray;
   /**
   * This constructor is the default constructor. It makes an array of Cards with 10 free slots.
   */
   public CardArrayList() {
      this.cardArray = new Card[10];
   }
   /**
   * This constructor creates an array of Cards with x space.
   * @throw IllegalArgumentException when x is less than 1
   */
   public CardArrayList(int x) {
      if (x < 1) { throw new IllegalArgumentException(); }
      this.cardArray = new Card[x];
   }
   /**
   * This method returns a string in the format [0: ARRAYLIST :size]
   * @return String temp 
   */
   public String toString() {
      String temp = "[0:";
      for (int i = 0; i < size; i++) {
         temp = temp + cardArray[i].toString();
         if (i + 1 < size) {
            temp = temp.trim() + ",";
         }
      } temp = temp + " :" + size + "]";
      return temp;
   }
   /**
   * This method counts how many actual cards are in the array list and returns the size
   * @return int counter
   */
   public int size() {
      int counter = 0;
      for (int i = 0; i < cardArray.length; i++) {
         if (cardArray[i] != null) {
            counter++;
         }
      }
      return counter;
   }
   /**
   * This method adds Card x to the end of the array list, increasing the array's size if needed.
   * Increments size by 1.
   */
   public void add(Card x) {
      if (isRoom()) {
         cardArray[size] = x;
         size++;
         return;
      }
      Card[] tempArray = new Card[cardArray.length + 1];
      for (int i = 0; i < size; i++) {
         tempArray[i] = cardArray[i];
      }
      tempArray[size] = x;
      this.cardArray = new Card[tempArray.length];
      for (int i = 0; i < tempArray.length; i++) {
         this.cardArray[i] = tempArray[i];
      }
      size++;
   }
   /**
   * This method removes a card at the end of the array list by decrementing size by 1, without actually
   *  erasing the card away.
   * @return Card removed
   */ 
   public Card remove() {
      Card removed = cardArray[size - 1];
      size--;
      return removed;
   }
   /**
   * This method returns the card at a given index
   * @return Card at index x
   */
   public Card get(int x) {
      if (x > size || x < 0) { throw new IllegalArgumentException(); }
      return cardArray[x];
   }
   /**
   * This method checks if a card exists inside of the array and
   * @param Card x
   * @return int returns the index of where it was found
   */
   public int indexOf(Card x) {
      for (int i = 0; i < size; i++) {
         if (0 == x.compareTo(cardArray[i])) {
            return i;
         }
      } return -1;
   }
   /**
   * This method adds a Card x at a given index by moving everything to the right and replacing
   *  the card at l. Increments size.
   * @param int l the index
   * @param Card x the card
   */
   public void add (int l, Card x) {
      Card[] tempArray;
      if (isRoom()) {
         tempArray = new Card[cardArray.length];
      } else {
         tempArray = new Card[cardArray.length + 1];
      } for (int i = size; i > l; i--) {
         tempArray[i] = cardArray[i - 1];
      }
      tempArray[l] = x;
      for (int i = l; i < tempArray.length; i++) {
         this.cardArray[i] = tempArray[i];
      }
      size++;
   }
   /**
   * This method removes a card from the array and moves everything to the right to cover it up, decrements size
   * @param int j index of card to be removed
   * @return Card returns the removed card
   */
   public Card remove(int j) {
      Card tempCard = cardArray[j];
      Card[] tempArray = new Card[cardArray.length - 1];
      for (int i = j; i < cardArray.length; i++) {
         tempArray[i - 1] = cardArray[i];
      } for (int i = j; i < tempArray.length; i++) {
         this.cardArray[i] = tempArray[i];
      }
      size--;
      return tempCard;
   }
   /**
   * Starts the mergeSort method, size based on DEBUGsizeTest boolean and actual size of the array list
   */
   public void sort() {
      int DEBUGsize;
      if (DEBUGsizeTest) {
         DEBUGsize = 60;
      } else {
         DEBUGsize = size;
      }
      if (size < 60) {
         mergeSort(cardArray, size);
      } else {
         mergeSort(cardArray, DEBUGsize);
      }
   }
   /**
   * This Method is the mergeSort. It takes in an array and the size of it, and recursively divides them up
   *  before sortation.
   * @param Card[] inputArray the whole array of cards
   * @param int sizeArray the size of the array put into this method
   */
   private static void mergeSort(Card[] inputArray, int sizeArray) {
      if (sizeArray < 2) return;
      
      Card[] leftArray= new Card[sizeArray / 2];
      Card[] rightArray= new Card[sizeArray - leftArray.length];
      for (int i = 0; i < leftArray.length; i++) {
         leftArray[i] = inputArray[i];
      }
      for (int i = 0; i < rightArray.length; i++) {
         rightArray[i] = inputArray[leftArray.length + i];
      }
      
      mergeSort(leftArray, leftArray.length);
      mergeSort(rightArray, rightArray.length);
      
      merge(leftArray, rightArray, inputArray);
   }
   /**
   * This method takes the bits and pieces from the previous method and stitches them together while
   *  organizing it from least cost to most.
   * @param Card[] leftArray the first half of the input array
   * @param Card[] rightArray the latter half of the input array
   * @param Card[] outputArray a copy of the input array
   */
   private static void merge(Card[] leftArray, Card[] rightArray, Card[] outputArray) {
      int iLeft = 0, iRight = 0, iMerged = 0;
      while (iLeft < leftArray.length && iRight < rightArray.length) {
         if (leftArray[iLeft].compareTo(rightArray[iRight]) < 0) {
            outputArray[iMerged++] = leftArray[iLeft++];
         } else {
            outputArray[iMerged++] = rightArray[iRight++];
         }
      }
      while (iLeft < leftArray.length) {
         outputArray[iMerged++] = leftArray[iLeft++];
      }
      while (iRight < rightArray.length) {
         outputArray[iMerged++] = rightArray[iRight++];
      }
   }
   /**
   * This method shuffles the deck
   */
   public void shuffle() {
      Random rand = new Random();
      for (int i = 0; i < (size * 5); i++) {
         int randOne = rand.nextInt(size);
         int randTwo = rand.nextInt(size);
         
         Card temp = cardArray[randOne];
         cardArray[randOne] = cardArray[randTwo];
         cardArray[randTwo] = temp;
      }
   }
   /**
   * This method checks if there is room left in the array that are null
   * @returns boolean isRoom
   */
   private boolean isRoom() {
      boolean isRoom = false;
      for(int i = 0; i < cardArray.length; i++) {
         if (cardArray[i] == null) {
            isRoom = true;
         }
      }
      return isRoom;
   }
   /**
   * This method doubles the amount of space of Cards the array an hold
   */
   private void expand() {
      Card[] tempArray = new Card[cardArray.length*2];
      for (int i = 0; i < cardArray.length; i++) {
         tempArray[i] = cardArray[i];
      } cardArray = new Card[tempArray.length];
      for (int i = 0; i < tempArray.length; i++) {
         cardArray[i] = tempArray[i];
      }
   }
   /*
   * This method swaps two cards
   * @param int a index of first card
   * @param int b index of second card
   */
   private void swap(int a, int b) {
      Card temp = cardArray[a];
      cardArray[a] = cardArray[b];
      cardArray[b] = temp;
   }
   /**
   * This method completely clears up the whole array
   */
   public void clear() {
      cardArray = new Card[10];
      size = 0;
   }
}
