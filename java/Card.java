/**
* @author Joshua Levi Flores Rankin
* @version 11/03/2019
*/
import java.util.*;
import java.lang.*;
/**
* This class creates an object Card that
* @implements Comparable<Card> allowing you to compare them to one another
*/
public class Card implements Comparable<Card>{
   private int power;
   private int toughness;
   /**
   * A constructor that creates a card with random power and toughness within the
   *  acceptable bounds.
   */
   public Card() {
      Random rand = new Random();
      power = rand.nextInt(1000 + 1);
      toughness = rand.nextInt(1000 + 1);
   } 
   /**
   * A constructor that creates a card with x power and x toughness
   * @param int x power and toughness
   * @throw IllegalArgumentException when x is below 1 or above 1000.
   */
   public Card(int x) {
      if (x < 1 || x > 1000) { throw new IllegalArgumentException("Power and Toughness need to be between 1 and 1000!"); }
      power = x;
      toughness = x;
   } 
   /**
   * A constructor that creates a card with P power and T toughness
   * @param int P power
   * @param int T toughness
   * @throw IllegalArgumentException when P is below 1 or above 1000
   * @throw IllegalArgumentException when T is below 1 or above 1000
   */
   public Card(int P, int T) {
      if (P < 1 || P > 1000) { throw new IllegalArgumentException("Power need to be between 1 and 1000!"); }
      if (T < 1 || T > 1000) { throw new IllegalArgumentException("Toughness need to be between 1 and 1000!"); }
      power = P;
      toughness = T;
   }
   /**
   * This method returns power
   * @returns int Power
   */
   public int getPower() {
      return power;
   }
   /**
   * This method returns toughness
   * @returns int toughness
   */
   public int getToughness() {
      return toughness;
   }
   /**
   * This method returns cost
   * @returns int cost
   */
   public int getCost() {
      double temp = Math.pow((1.2 * power) + (0.75 * toughness), (0.75));
      return (int)Math.round(temp+0.5);
   }
   /**
   * This method returns a String in the decided format
   * @returns String [Power/Toughness::Cost]
   */
   public String toString() {
      return "["+power+"/"+toughness+"::"+getCost()+"]";
   }
   /**
   * This compareTo method compares two cards based on their cost, power, and then toughness.
   * @param Card x, the card you want to compare this current object to
   * @returns a positive, negative, or 0 dependent on what's bigger or smaller
   */
   public int compareTo(Card x) {
      if (getCost() != x.getCost()) {
         return getCost() - x.getCost();
      } else if (getPower() != x.getPower()) {
         return getPower() - x.getPower();
      } else {
         return getToughness() - x.getToughness();
      }
   }
   /**
   * This method lowers the power and toughness of a card by 10%
   */
   public void weaken() {
      this.power = power - (power / 10);
      this.toughness = toughness - (toughness / 10);
   }
   /**
   * This method increases the power and toughness of a card by 10%
   */
   public void boost() {
      this.power = power + (power / 10);
      this.toughness = toughness + (toughness / 10);
   }
}
