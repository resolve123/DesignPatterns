package com.solid.principles;

/**
 * Clients should not be forced to depend upon interfaces that they do not use.
 *  reduce the side effects of using larger interfaces by breaking application interfaces into smaller ones.
 *  It's similar to the Single Responsibility Principle, where each class or interface serves a single purpose
 *
 *  General rule is , a class should implement a interface if it need all of the methods of that interface. If there is even a single method
 *  in that interface which class do not need than better to spliut interface in two interface.
 *
 *  Violation Of ISP
 *  1.Fat Interfaces
 *  2. Interfaces with low cohesion ( like inteface have print nd fax methods)
 *  3. Empty method implementation
 *
 */
public class InterfaceSegregationPrincipal {
}

interface Multifucntion {
    public void print();
    public void fax();
    public void xerox();
}

/**
 * This class have print method and rest are empty as it do not need those so it is again ISP. So better create 3
 * different interfaces for print ,scan and fax
 */
class HpXerox  implements Multifucntion{
    @Override
    public void print(){
       //Implementation code
    }

    @Override
    public void fax() {
        //Blank
    }

    @Override
    public void xerox() {
        //Blank
    }
}
