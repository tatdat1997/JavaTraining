package java_core;

import java.util.*;

public class Demo_Map {
	public static void main(String[] args) {	
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
        // add elements to hashMap
        hashMap.put(1, "Java");
        hashMap.put(5, "C++");
        hashMap.put(6, "PHP");
        hashMap.put(4, "Python");
        // show hashMap
        for (Integer key : hashMap.keySet()) {
        	 System.out.println("key: " + key + " value: " + hashMap.get(key));
        }

        show(hashMap);
        hashMap.forEach((key, value) -> {
            System.out.println("Key : " + key + " Value : " + value);
        });
        // remove element
        hashMap.remove(2);
        // show hashMap after remove
        System.out.println("After remove:");
        // show hashMap
        show(hashMap);
 
    }
 
    
    public static void show(Map<Integer, String> hashMap) {
        Set<Integer> keySet = hashMap.keySet();
        for (Integer key : keySet) {
            System.out.println(key + " " + hashMap.get(key));
        }
    }
}