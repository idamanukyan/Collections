package com.company;

public class Main {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        //Testing add methods
        arrayList.add(1);
        arrayList.add(10);
        arrayList.add(100);
        arrayList.add(2);
        arrayList.add(20);
        arrayList.add(200);
        arrayList.add(3,1000);
        arrayList.add(7,2000);
        arrayList.addAll(new int[]{3,30,300,3000});
        arrayList.print(); //1,10,100,1000,2,20,200,2000,3,30,300,3000

        //Testing get methods
        System.out.println();
        System.out.println(arrayList.getElement(2));
        System.out.println(arrayList.getIndex(30));

        //Testing subList method

        int[] ints = arrayList.subList(2, 4);// 100,1000,2
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

        //Testing remove methods
        arrayList.removeElementOfIndex(1);
        arrayList.removeElement(30);
        arrayList.print();// 1 100 1000 2 20 200 2000 3 300 3000
        System.out.println();
        arrayList.removeAll();

        System.out.println(arrayList.isEmpty());

    }
}
