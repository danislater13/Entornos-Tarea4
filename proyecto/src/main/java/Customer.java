import java.util.Enumeration;
import java.util.Vector;

public class Customer{
    private String _name;
    private Vector _rentals = new Vector();
    Movie movie; int daysRented;

    public Customer (String name) {
        _name = name;
    }

    public void addRental (Rental arg) {
        _rentals.addElement(arg);
    }

    public String statement () {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //simplified code 
            //calculo realizado en el metodo for para mejor lectura
            /*2ºRefactoring */
            each.getCharge(each, thisAmount);
            
            
            /*// add frequent renter points
            frequentRenterPoints ++;
            // add bounus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints ++;
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }*/
            //creo el metodo getFrequentRenterPoints para que el metodo sea mas legible
            getFrequentRenterPoints(frequentRenterPoints, each, result,thisAmount, totalAmount);
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
    
    
    public String getName() {
        return _name;
    }
    
    public int getFrequentRenterPoints(int frequentRenterPoints,Rental each,String result,double thisAmount,double totalAmount){
        // add frequent renter points
            frequentRenterPoints ++;
            // add bounus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1){
                frequentRenterPoints ++;
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
            return 2;
    }
            else {
            return 1;}
        }
    

}
