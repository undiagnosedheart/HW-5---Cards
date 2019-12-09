/**
* @author Joshua Levi Flores Rankin
* @version 11/06/2019
*/
/**
* This method
* @extends Card allowing you to use it's methods unless over-written (such as toString)
*/
public class PremiumCard extends Card{
   /**
   * Constructs a Premium card with random Power and toughness
   */
   public PremiumCard() {
      super();
   }
   /**
   * Constructs a Premium card with x Power and toughness
   * @param int x power and toughness
   */
   public PremiumCard(int x) {
      super(x);
   }
   /**
   * Constructs a Premium card with P Power and T toughness
   * @param int P Power
   * @param int T Toughness
   */
   public PremiumCard(int P, int T) {
      super(P, T);
   }
   /**
   * This method returns a string with {{}} rather than []
   * @return String 
   */
   public String toString() {
      return "{{"+getPower()+"/"+getToughness()+"::"+getCost()+"}}";
   }
}
