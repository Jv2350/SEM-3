import java.util.*;
public class list{
    public static void main(String[] args){
        List<String> arrayList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();
        List<String> vectorObject = new Vector<String>();
    
        arrayList.add("This");
        arrayList.add("is");
        arrayList.add("Arraylist");
        
        linkedList.add("This");
        linkedList.add("is");
        linkedList.add("linkedList");
        
        vectorObject.add("This");
        vectorObject.add("is");
        vectorObject.add("vectorObject");

        System.out.println("Array list: "+arrayList);
        System.out.println("Linked list: "+linkedList);
        System.out.println("Vector: "+vectorObject);        
    }
}