package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by msharafat on 4/14/17.
 */
public class Sorting {

    public static void  main(String [] args){

        String a[] = {"luis", "hector", "selena", "emmanuel", "amish" };

        Sorting  sorting = new Sorting();
        //sorting.sort_modified(a);

        Person person1 = sorting.new Person("luis", 12, "M");
        Person person2 = sorting.new Person("dfsdf", 11, "M");
        Person person3 = sorting.new Person("dfsdf", 1, "M");
        Person person4 = sorting.new Person("hector", 112, "M");
        Person person5 = sorting.new Person("selena", 122, "M");
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);

        persons.add(person3);
        persons.add(person4);
        persons.add(person5);

        sorting.sortPersons(persons);

        for(Person person:persons){
            System.out.println(person.name);
        }



        int i =0;
       /* while(i < a.length){
            System.out.println(a[i]);
            i++;
        }*/

    }

    public void sort_modified(String [] stringArrray){

        int i =0;
        while(i < stringArrray.length){
            int j =0;
            while(j<stringArrray.length){
                //System.out.println(stringArrray[j]);

                char a = stringArrray[i].charAt(stringArrray[i].length()-1);
                char b =stringArrray[j].charAt(0);
               // System.out.println(a);
                //System.out.println(b);
                if(a == b){
                    if(j == i +1 || j ==i){
                        j++; continue;
                    }
                    else if (j < i){

                        swap(stringArrray, j, i-1);

                    }
                    else {
                        swap(stringArrray, i, j-1);
                        //swap(stringArrray, i+1, j);

                    }

                }
                j++;
            }
            i++;
        }
    }

    public void swap(String [] stringArrray, int i, int j){
        System.out.println("swapping "+stringArrray[i]+" with "+stringArrray[j]);
        if(i >= stringArrray.length || j >=stringArrray.length) return;
        String temp = stringArrray[i];
        stringArrray[i] = stringArrray[j];
        stringArrray[j] = temp;
    }


    public void sortPersons(ArrayList<Person> persons){
        MyComp myComp = new MyComp();
        Collections.sort(persons,myComp);

    }
    private class Person{
        String name;
        int age;
        String gender;

        public Person(String name,int age, String gender){
            this.name = name;
            this.age = age;
            this.gender = gender;
        }


    }
    private class MyComp implements Comparator{

        public int compare(Object obj1, Object obj2){
            Person emp1 = (Person) obj1;
            Person emp2 = (Person) obj2;

            return emp1.age - emp2.age;

        }

    }
}

