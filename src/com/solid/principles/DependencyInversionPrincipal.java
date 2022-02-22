package com.solid.principles;

import java.util.ArrayList;
import java.util.List;

/**
 * High-level modules should not depend on low-level modules. Both should depend on abstractions
 * Abstractions should not depend on details. Details should depend on abstractions
 */
public class DependencyInversionPrincipal {
    // Here we are hardcoding object creation. We need to add the abstarction
   // ProductRepo repo = new ProductRepo();

    // Here we added interface refrence variable and ProductRepo implelents interface . We should also inject object from  outside clas.
    ProductRepoInterface  repo = new ProductRepo();
}



interface ProductRepoInterface{
    public List<String> getProductList();
        }

class ProductRepo implements ProductRepoInterface{
    @Override
    public List<String> getProductList(){
        List products = new ArrayList<String>();
        return products;
    }

        }
