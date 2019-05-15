/**********************************************************************************************************************************
 *                                                    MADE BY AMNA                                                                *
 *********************************************************************************************************************************/
package miniproject;

import java.io.*;
import java.util.*;
public class BookStore2{
     /*
     these VARs must be static & here to access them by any method  
     */
    
                           
    private static int Textbook = 0;                                     //0 initial value
    private static final Scanner input = new Scanner(System.in);        //Scanner obj
    private static final String SGAP = "       ";
    private static int r = 0;                                          //i.v./r var must be here to add Book after disply method
    private static final Book[] book = new Book[20];
    
   
    public static void main(String[] args)throws IOException{
        
        //Book[] book = new Book[20]; 
         menu();                                                       //prompt the user to select a choice from a menu
    }
    
    
    public static String menu()throws IOException{
        
 String one = "1.Enter books information",    //prompts Numbers
        two = "2.Display books information",
        three = "3.Search by book's title",
        four = "4.Discount 15% from books prices",
        five = "5.Exit",
        gap = "                     ",
        l1 = gap+"♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥\n",   //menu lines
        l2 = gap+"♥♥♥♥♥♥♥♥♥♥♥♥♥    MENU   ♥♥♥♥♥♥♥♥♥♥♥♥♥\n",
        l3 = gap+"♥♥♥♥ "+one+"           ♥♥♥♥\n",
        l4 = gap+"♥♥♥♥ "+two+"         ♥♥♥♥\n",
        l5 = gap+"♥♥♥♥ "+three+"            ♥♥♥♥\n",
        l6 = gap+"♥♥♥♥ "+four+"    ♥♥♥♥\n",
        l7 = gap+"♥♥♥♥ "+five+gap+"         ♥♥♥♥\n";
 
        System.out.print(l1+l2+l1+l3+l4+l5+l6+l7+l1+"\n\n");  //prints whole menu
        System.out.print("Your choice:");
        String choiceNum = input.nextLine();    //String,to let the user to enter any thing without Exceptions
        while(!"5".equals(choiceNum)){         //like choiceNum != 5
           
           switch(choiceNum){
               case "1":
                   setBooks(book);
               break;
               case "2":
                   displayBooks();
               break;
               case "3":
                   findBooks();
               break;
               case "4":
                   discountPrice();
               break;
               default:
                   System.out.print("Invalid choice!"+"\n\nYour choice:");
                   choiceNum = input.nextLine();
                   continue;
           }
           System.out.print("\n"+l1+l2+l1+l3+l4+l5+l6+l7+l1+"\nYour choice:");
           choiceNum = input.nextLine();
        }
        return choiceNum;
    } //end menu method
    
    
    
   //Book[] 'Book'here is dataType ,which is our class Book.java
    public static int setBooks(Book[] book)throws IOException{          //prompt 1
       
        String sPrice,
               PubYear;
       
        String Add = "y";                  //initil value cuz when user input pt1 that's means he want to add book!
        while("y".equals(Add) || "Y".equals(Add)){
        if(Textbook < 20){
        if( r <= book.length){
            book[r] = new Book();
        
        Textbook = 1+Textbook;
        int t = 0,              //t,y to know if we reached the valid value,if t,y = 1 ok take it and move
            y = 0; 
       
        System.out.printf("\nTextbook #%d %n",Textbook); 
        System.out.print("Title: ");
        book[r].setbTitle(input.nextLine());
        System.out.print("Price: ");
        sPrice = input.next(); 
        while(t == 0) {                                           //sPrice,PubYear Strings to let user input anything then 
           try{                                                  //we'll try to convert them to numerical value if we could't
               book[r].setbPrice(Double.valueOf(sPrice));       //that's means user input invalid value(St),then let it input again
               if( book[r].getbPrice() >= 0){                  //if we could convert them to numerical,then check more conditions
                   t = t + 1;
              }
               else{
                 System.out.print("Price Again : ");
                 sPrice = input.next();  
               }
               
               
          }catch(NumberFormatException e){
              System.out.print("Price Again : ");
              sPrice = input.next();
         }}        


        System.out.print("Publication year: ");
        PubYear = input.next();
        
        while(y == 0) { 
           try{
               book[r].setbPubYear(Integer.valueOf(PubYear));
               if(book[r].getbPubYear() > 0 && book[r].getbPubYear() <= 2019){
                  y = y + 1;
               }
               else{
                 System.out.print("Publication year Again : ");
                 PubYear = input.next();  
               }
               
          }catch(NumberFormatException e){
              System.out.print("Publication year Again : ");
              PubYear = input.next(); 
         }}
        
        
        input.nextLine();                               // This line you have to add (It consumes the \n character)
        r = 1+r;     //r here to let r start from 0, index of the array start from 0,and updated after adding
        
        System.out.print("Add another textbook (y/n)? ");
        Add = input.nextLine();
        while(!"n".equals(Add) && !"N".equals(Add) && !"y".equals(Add) && !"Y".equals(Add)){ //if user input invalid value
           System.out.print("Add another textbook (Y/N)? ");                                //prompt it until y/n
           Add = input.nextLine();
        }}}else{
           Add = "n"; //if books > 20 change Add to "n" to skip what user want (Add=y he want to Add book)
           System.out.print("You can't add more than 20 books!\n\n"); 
        }
        } 
        return Textbook;  //Num of Books entered
        
   } //end setBook method 
    
    
    
    public static void displayBooks(){  //prompt 2
        switch(Textbook){  
            case(0):
                System.out.print("There is no books info to display!! \n\n"); 
            break;
            default:
                int i = 1;
                int b = 0; //means first book
               while(i <= Textbook){
                    int Textbook2 = Textbook-(Textbook-i); 
                    System.out.printf("\nTextbook #%d\n",Textbook2); 
                    System.out.printf("Title: %s %S",book[b].getbTitle(),SGAP); 
                    System.out.printf("Price: £%.1f %S",book[b].getbPrice(),SGAP);
                    System.out.printf("Publication year: %S \n\n",book[b].getbPubYear());
                    i = i + 1;
                    b = b + 1; //to go to the next Index of The book Array
                   
                }
                }
        
    }//end displayBooks method
    
    
    
    public static void findBooks(){   //prompt 3
        switch(Textbook){
            case 0:
                System.out.print("No books have been added to search in! \n\n");
            break;
            default:
       System.out.println("\nFind the first THREE books with the same title:");
       String fBook = input.nextLine(), 
       sfBook = fBook.toLowerCase();  //search by LC to find all possible Titles,what ever they(LC,UC,mixed)
       int abook = 0,                //to check if we found a book
           b = 0;                   //to start from Index 0
       for(int i = 1; i <= Textbook; i++){
            
       boolean check = sfBook.equals(book[b].getbTitle().toLowerCase()); //make all Titles LC to match sfBook
       if(check == true){
           if(abook < 3){    //to print first 3
                    
                    System.out.printf("Title: %s %S",book[b].getbTitle(),SGAP);
                    System.out.printf("Price: £%.1f %S",book[b].getbPrice(),SGAP);
                    System.out.printf("Publication year: %S \n\n",book[b].getbPubYear());
                    abook = abook + 1;
                    b = b + 1;
                    }}
             
      else if(check == false){ b = b + 1;} 
  }              
       if(abook == 0) {
                System.out.printf("There is no books with title \"%s\"\n\n",fBook);}
       }
}  //end findBooks method
    
    
    
    
  public static void discountPrice(){  //prompt 4
      switch(Textbook){  
            case(0):
                System.out.print("No books have been added to discount!! \n\n"); 
            break;
            default:
            int i = 1;
            int b = 0; //to start from Index 0 
            while(i <= Textbook){
                   book[b].setbPrice(book[b].getbPrice() - (book[b].getbPrice()*0.15)); 
                   b = b + 1;                             //to go to the next Index of The book Array
                   i = i + 1;                            
               } System.out.println("Discount is done! ");
      }
   } //end discountPrice method
  
   
} //end the class
