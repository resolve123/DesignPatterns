package com.solid.principles;

/**
 * Subtypes must be substitutable for their base types means base object should be replaceable by subtype objects.
 * Subtypes must be substitutable for their base types
 *
 * As per the LSP, functions that use references to base classes must be able to use objects of the derived class without knowing it.
 * In simple words, derived classes must be substitutable for the base class.
 * Drived class must have all the features of Base class.
 *
 * example if Bird is the base class with Fly method and Ostrich extend bird but Ostrich can not fly so fly method in Ostrich is useless and against LSP principal
 *
 * solution : Break the hirarchy as at the end example we create another class FlyBird
 *    second Tell do not'ask  like no need to use instanceOf
 */
public class LiskovSubstitutionPrincipal {
}

 class Bird{
    public void fly(){}
}

/**
 * The duck can fly
 */
 class Duck extends Bird{}

/**
 * Ostrich is a bird, but it can't fly, Ostrich class is a subtype of class Bird, but it shouldn't be able to use the fly method, that means we are breaking the LSP principle.
 *
 * Good example
 */
 class Ostrich extends Bird{}

/**
 * To solve above issue create Bird class without flying method and create another class FlyingBird
 *
 * public class Bird{}
 * public class FlyingBirds extends Bird{
 *     public void fly(){}
 * }
 * public class Duck extends FlyingBirds{}
 * public class Ostrich extends Bird{}
 *
 *
 */

