package com.creational.design.patterns;
import java.util.ArrayList;
import java.util.List;
/**
 * This design pattern is use to create a unique object from existing object.
 * This is useful when creation of new object is very costly like it involve fetching
 * data from database. If already have an object and you want to create similar object then use
 * prototype pattern.
 * Class should provide the clone implementation
 * example with shallow copy
 */
public class PrototypePattern implements Cloneable{

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    List data  = new ArrayList();

    public Test getName() {
        return name;
    }

    public void setName(Test name) {
        this.name = name;
    }

    Test name ;


    @Override
    public  Object clone()  {
           try {
           return super.clone();
       }catch(CloneNotSupportedException e){
               // We are doing deep copy
           List data  = new ArrayList();
           data.addAll(this.getData());
           PrototypePattern pattern =new PrototypePattern();
            pattern.setData(data);
            return pattern;
       }
    }
    public void loadData(){
        this.data.add("first");
        this.data.add("second");
    }


    public static void main(String s[]){
        PrototypePattern firstObject = new PrototypePattern();
        firstObject.loadData();
        Test t1= new Test("Amit");
        firstObject.setName(t1);
        firstObject.data.forEach(x->System.out.println(x));
        System.out.println("object test name in first object: "+firstObject.name.getName());

        PrototypePattern secondObject = (PrototypePattern)firstObject.clone();
        firstObject.name.setName("sharma");
        firstObject.data.add("Third");
        secondObject.data.forEach(x->System.out.println(x));
        System.out.println(secondObject.name.getName());
    }
}

class Test{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Test(String name){
        this.name=name;
    }

    String name;
}
