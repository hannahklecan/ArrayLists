/* 
 * To Do: 
 *    Complete all the menu items, passing the arraylist to the module. 
 *    Check for an empty arrayList when appropriate. 
 *    Check for a valid index number when appropriate.
 * 
 *    The program should not crash under any circumstances.  
 */
import java.util.*;

public class ArrayListPractice_1 {
    private final static int EXIT = 99;
    
    private static ArrayList<String> myArrayList = new ArrayList<String>();
    
    public static void main(String[] args) {
        displayMenu();
        int menuOption = IR4.getInteger("\nPlease enter a menu item");
        while (menuOption != EXIT){
            switch(menuOption){ 
                case 1: displayList();               
                        break;
                case 2: addNameAtEndOfList();        
                        break;
                case 3: addNameByIndex();        
                        break;
                case 4: deleteName();             
                        break;  
                case 5: deleteNameByIndex();       
                        break;  
                case 6: displaySizeOfList();      
                        break;  
                case 7: deleteAllNames();         
                        break;  
                case 8: searchForName();           
                        break;  
                case 9: displayListInReverseOrder();
                        break;  
                case 10: sortAndDisplayTheList(); 
                        break;  
                case 11: displayTheMinElement();  
                        break;  
                case 12: displayTheMaxElement();  
                        break;  
                case EXIT:                         
                        break;
                default: 
                    System.err.println("Invalid menu option. Try again."); 
                    break; 
            }
            displayMenu();
            menuOption = IR4.getInteger("\nPlease enter a menu item");
        }
        System.out.println("--- ArrayList practice program ending normally ---");
    }    
    
    private static void displayList(){
      
      System.out.println("\nContents of myArrayList:\n");
      for(int i = 0; i< myArrayList.size(); i++){
        System.out.println(myArrayList.get(i));
      }
    }
    
    private static void addNameAtEndOfList(){
        String nameToAdd = IR4.getString("Please enter a name to be added to the List. Enter 999 to stop.");
        while (!nameToAdd.equals("999")){
            System.out.println("Adding name: " + nameToAdd);
            
            myArrayList.add(nameToAdd);
            
            nameToAdd = IR4.getString("Please enter a name to be added to the List. Enter 999 to stop.");
        }
        displayList();
    }
    private static void addNameByIndex(){
        String nameToAdd  = IR4.getString("Please enter a name to be added to the List");
        int locationToAdd = IR4.getInteger("Please enter the index location where the name should be added");
        
        myArrayList.add(locationToAdd, nameToAdd);
        
    }
    
    //deletes all occurrences of the entered name
    private static void deleteName(){
        String nameToDel  = IR4.getString("Please enter a name to be deleted from the List");
        
        nameToDel = nameToDel.trim();
        
        if(!myArrayList.contains(nameToDel)){
          System.err.println("\n" +nameToDel+  " does not exist in the list.");
        }
        
        //returns true as long as the name is found in the arrayList
        while(myArrayList.contains(nameToDel)){
          
          System.out.println("Deleting name: " + nameToDel);
            myArrayList.remove(nameToDel);
        }
        
        displayList();
    }
    
    private static void deleteNameByIndex(){
      
        int locationToDel = IR4.getInteger("Please enter the index location where the name should be deleted");
        
        if(myArrayList.size() > 0)dd{
        while((locationToDel < 0 || locationToDel >= myArrayList.size() ) && locationToDel != 999){
          System.err.println("Invalid index");
          locationToDel = IR4.getInteger("Please enter the index location where the name should be deleted, or 999 to return to menu:");
        }
        
        if(locationToDel != 999){
          System.out.println("Removing " + myArrayList.get(locationToDel) + " from list.");
          myArrayList.remove(locationToDel);
        }
        }
           else{
             System.err.println("There are no elements in the list to remove.");
           }
          
        displayList();
    }
    
    private static void displaySizeOfList(){
        System.out.println("\nSize of List: " + myArrayList.size());      
        displayList();
    }
    
    private static void deleteAllNames(){
        myArrayList.clear();
        displayList();
    }
    
    private static void searchForName(){
        String nameToSearch  = IR4.getString("Please enter a name to search: ");
        if(myArrayList.contains(nameToSearch)){
          System.out.println(nameToSearch +" is in the list.");
        }
        else{
          System.err.println(nameToSearch +" is not in the list.");
        }
        displayList();
    }
    
    private static void displayListInReverseOrder(){ 
      System.out.println("\nmyArrayList in reverse order:\n");
      for(int i = myArrayList.size()-1; i >= 0; i--){
        System.out.println(myArrayList.get(i));
      }
        displayList();
    }
    
    private static void sortAndDisplayTheList(){
      
        Collections.sort(myArrayList);
        System.out.println("- Sorting myArrayList -");      
        displayList();
    }
    
    private static void displayTheMinElement(){
        String min = "";
      
        if(myArrayList.size()>0)
        min = myArrayList.get(0);
      
        for(int i = 0; i< myArrayList.size(); i++){
          if((myArrayList.get(i)).compareTo(min) < 0){
           min =  myArrayList.get(i);
          }
        }
        
        System.out.println("\nThe min element is: " + min );
        
        displayList();
    }
    
    private static void displayTheMaxElement(){
      
        String max = "";
      
        if(myArrayList.size()>0)
        max = myArrayList.get(0);
      
        for(int i = 0; i< myArrayList.size(); i++){
          if((myArrayList.get(i)).compareTo(max) > 0){
           max =  myArrayList.get(i);
          }
        }
        
        System.out.println("\nThe max element is: " + max );      
        displayList();
    }
    
    private static int getValidNumberBetweenTwoInclusive (String message, int first, int second) {
        int newValue;
        newValue = IR4.getInteger (message); 
        while (newValue < first || newValue > second){
            System.out.println("Invalid entry.");
            newValue = IR4.getInteger (message); 
        }
        return newValue;  
    }
    
    private static void displayMenu(){
        System.out.println("");
        System.out.println("----- ArrayList Practice 1 Menu -----");
        System.out.println("");
        System.out.println("1.  Display the List");
        System.out.println("2.  Add a name at the end of the List");
        System.out.println("3.  Add a name by index");
        System.out.println("4.  Delete a name");
        System.out.println("5.  Delete a name by index");
        System.out.println("6.  Display the size of the List");
        System.out.println("7.  Delete all names");
        System.out.println("8.  Search for a name");
        System.out.println("9.  Display the List in reverse order");
        System.out.println("10. Sort the List");
        System.out.println("11. Display the min element");
        System.out.println("12. Display the max element");
        System.out.println("99. Exit");
    }
    
    
}
