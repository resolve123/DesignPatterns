package com.structural.design.patterns;

/**
 * Provide a surrogate or placeholder for another object to control access to it.
 * Proxy is heavily used to implement lazy loading related usecases where we do not want to create full object until it is actually needed.
 * The Proxy pattern allows us to create an intermediary that acts as an interface to another resource, while also hiding the underlying complexity of the component.
 * When to Use Proxy----------------
 *
 *1.  When we want a simplified version of a complex or heavy object. In this case, we may represent it with a skeleton object which loads the
 * original object on demand, also called as lazy initialization. This is known as the Virtual Proxy
 *
 * 2. When the original object is present in different address space, and we want to represent it locally.
 * We can create a proxy which does all the necessary boilerplate stuff like creating and maintaining the connection, encoding,
 * decoding, etc., while the client accesses it as it was present in their local address space. This is called the Remote Proxy
 *
 * 3.When we want to add a layer of security to the original underlying object to provide controlled access based on access rights of the client. This is called Protection Proxy
 */
public class ProxyPattern {
    public static void main(String[] args) {
        ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();
    }
}

interface ExpensiveObject {
    void process();
}

class ExpensiveObjectImpl implements ExpensiveObject {

    public ExpensiveObjectImpl() {
        heavyInitialConfiguration();
    }

    /**
     * Consider a heavy Java object (like a JDBC connection or a SessionFactory) that requires some initial configuration.
     *
     * We only want such objects to be initialized on demand, and once they are, we'd want to reuse them for all calls
     */
    @Override
    public void process() {
      System.out.println("processing complete.");
    }

    private void heavyInitialConfiguration() {
        System.out.println("Loading initial configuration...");
    }

}

/**
 * We'll now utilize the Proxy pattern and initialize our object on demand. This proxy implements the same interface as main object implements
 */

 class ExpensiveObjectProxy implements ExpensiveObject {
    private static ExpensiveObject object;

    @Override
    public void process() {
        if (object == null) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }
}