package com.structural.design.patterns;

/**
 * A Decorator pattern can be used to attach additional responsibilities to an object either statically or dynamically.
 * A Decorator provides an enhanced interface to the original object
 *
 * Example we have to decorate christmas tree so base implementaion docorate it then we created furher decorator to decorate it further.
 * Create an interface.
 * Create concrete classes implementing the same interface.
 * Create an abstract decorator class implementing the above same interface.
 * Create a concrete decorator class extending the above abstract decorator class.
 * Now use the concrete decorator class created above to decorate interface objects.
 * Lastly, verify the output
 */
public class DecoratorPattern {
public static void main(String s[]) {
    ChristmasTree christmasTree= new BubbleLights( new ChristmasTreeImpl());
}
}

interface ChristmasTree {
    String decorate();
}

class ChristmasTreeImpl implements ChristmasTree {

    @Override
    public String decorate() {
        return "Christmas tree";
    }
}

abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree tree;


    public TreeDecorator(ChristmasTree c){
        this.tree=c;
    }
    @Override
    public String decorate() {
        return tree.decorate();
    }
}

class BubbleLights extends TreeDecorator {

    public  BubbleLights(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}

class StarSign extends TreeDecorator {

    public  StarSign(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithStarSign();
    }

    private String decorateWithStarSign() {
        return " with Bubble Lights";
    }
}
