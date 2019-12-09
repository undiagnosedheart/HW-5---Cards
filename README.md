# Homework 5: Cards
This program primarily focuses on the implementation of an ArrayList type interface and the necessary methods to implement the ArrayList. It also includes polymorphism and class comparison.

# Instructions:
Your deliverable will be to turn in three files.  The files will be named Card.java, PremiumCard.java and the last file will be called CardArrayList.java.  
 
For this assignment, any use of a data control structure other than a simple Arrary or String will result in no credit.   I am aware that this assignment could be done quite simply by the implementation of an ArrayList<> but the point of the assignment is to do it without the standard implementation to get a feel for how they work “under the hood”.  

# Collectable Card:
While the primary goal of this assignment will be the implementation and use of a custom ArrayList.   The particular implementation we will use will focus on the idea of a simple collectable card game.    
 
For our card game, we will assume that every card has two values expressed as integers.   Each card will have power and a toughness rating.   These numbers need to be a minimum of 1 and a maximum of 1000.    
 
Cards then have a calculated cost attribute that comes from the formula below. 
 
𝑐𝑜𝑠𝑡 = ⌈(1.2 ⋅ 𝑝𝑜𝑤𝑒𝑟 + 0.75 𝑡𝑜𝑢𝑔ℎ𝑛𝑒𝑠𝑠)^(3/4)⌉ 
 
Rounded up to the nearest integer.  

When comparing two cards, the one with the higher cost comes after the other unless they have the same cost, in which case the one with the higher power comes after the other.   If both cost and power are equal then the higher toughness comes after.  Only if all three values are equal would the cards be considered equal.    
 
{30,15} > {30,10} > {20,20} > {20,10} > {10,20} > {10, 10}  
 
Note that in the assignment you will sort from low to high...but the list above is high to low. 
 
In addition there are some cards that are considered Premium cards.   In a GUI based program, these would be drawn graphically different on the screen, but for our purposes there will only be a slight difference in the output of the card information.   But this will give you some practice in polymorphism.

# Program Description
In this assignment you will construct an ArrayList that can manage a set of Cards which includes both normal and premium cards.   You will implement the various methods that are required in order to make the ArrayList function. 
A sample program will be provided for you to test with, but you may want to alter it to check different functionality of your ArrayList.
