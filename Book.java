/**********************************************************************************************************************************
 *                                                MADE BY AMNA                                                                    *
 *********************************************************************************************************************************/
package miniproject;

public class Book {
    
    private String bTitle;
    private int bPubYear;
    private double bPrice;
    
/*  public Book(String Title, double Price, int PubYear){  //constructor
    bTitle = Title;
    bPubYear = PubYear;
    bPrice = Price;}
*/
    
    public void setbTitle(String newbTitle){   //set methods
      bTitle = newbTitle;  
    }
    
    public void setbPubYear(int newbPubYear){
      bPubYear = newbPubYear;  
    }
        
    public void setbPrice(double newbPrice){
      bPrice = newbPrice;
    }
    
    public String getbTitle(){                 //get methods
        return bTitle;
    }
    
    public int getbPubYear(){
        return bPubYear;
    }
    
    public double getbPrice(){
        return bPrice;
    }
    
    public void display(){                  //Display method
        System.out.printf("Book title: %s%nBook price: %f%n Publish Year: %d%n",bTitle, bPrice, bPubYear );
    }
}
    
    

