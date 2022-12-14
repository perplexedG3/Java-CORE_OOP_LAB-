
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private E_Methods em = new E_Methods();
    private Scanner sc = new Scanner(System.in);

    //check input String,only enter letter
    public String Input_String() {
        String Input;
        while (true) {
            Input = sc.nextLine();
            if (Input.matches("^[a-zA-Z\\s]+$") && Input.trim().length() > 0) {
                break;
            } else {
                System.err.println("In-valid(only letter and space,not empty)!!!");
                System.out.print("Re-enter:");
            }
        }
        return Input;
    }

    //Check input ID,only enter digit,letter(use for add)
    public String Input_ID() {
        String Input;
        while (true) {
            Input = sc.nextLine();
            if (Input.matches("^[a-zA-Z0-9\\s]+$") && Input.trim().length() > 0) {
                break;
            } else {
                System.err.println("In-valid(only letter,digit,not empty)!!!");
                System.out.print("Re-enter:");
            }
        }
        return Input;
    }

    //check input phone,only enter digit
    public String Input_Phone() {
        String Input;
        while (true) {
            Input = sc.nextLine();
            if (Input.matches("^[0-9]+$") && Input.length() > 7 && Input.length() < 11) {
                break;
            } else {
                System.err.println("In-valid(only digit and length = 8->10)!!!");
                System.out.print("Re-enter:");
            }
        }
        return Input;
    }

    public String Input_Address() {
        String Input;
        while (true) {
            Input = sc.nextLine();
            if (Input.matches("^[A-Za-z0-9\\s\\,]+[A-Za-z0-9\\s]+$")&& Input.trim().length() > 0) {
                break;
            } else {
                System.err.println("In-valid(ex:thanh xuan,ha noi)!!!");
                System.out.print("Re-enter:");
            }
        }
        return Input;
    }

    //check input email
    public String Input_Email() {
        String Input;
        while (true) {
            Input = sc.nextLine();  //+[A-Za-z0-9]
            if (Input.matches("^[A-Za-z0-9.]+@+[A-Za-z]+(\\.[A-Za-z]+)+$")&& Input.trim().length() > 0) {
                break;
            } else {
                System.err.println("Invalid(ex:abc123@gmail.com/fpt.edu.vn)");
                System.out.print("Re-enter:");
            }
        }
        return Input;
    }

    //check input int 
    public int Input_Int() {
        while (true) {
            try {
                int Input = Integer.parseInt(sc.nextLine());
                return Input;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.err.print("Invalid,Re-enter:");
            }
        }

    }

    //check input double 
    public double Input_double() {
        while (true) {
            try {
                double Input = Double.parseDouble(sc.nextLine());
                return Input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.err.println("Invalid,Re-enter:");
            }
        }
    }

    //check input type Date
    public String Input_Date() throws ParseException {
        while (true) {
            try {
                String result = sc.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                String temp[] = result.split("-");

                Calendar instance = Calendar.getInstance();
                int current_year = instance.get(Calendar.YEAR);

                int input_year = Integer.parseInt(temp[2]);
                int age = current_year - input_year;
                if (!(result.equalsIgnoreCase(format.format(date)) && age >= 18 && age <= 100)) {
                    System.err.print("Invalid(dd-MM-yyyy ,Age(18->100)),Re-enter: ");
                } else {
                    return result;
                }
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //check input sex(nam-nu)
    public String Input_Sex() {
        String Input;
        while (true) {
            Input = sc.nextLine();
            if (Input.matches("^[a-zA-Z\\s]+$")
                    && (Input.equalsIgnoreCase("Male") || Input.equalsIgnoreCase("FeMale"))) {
                break;
            } else {
                System.err.println("In-valid(only enter Male or FeMale)!!!");
                System.out.print("Re-enter:");
            }
        }
        return Input;
    }

    //method check answer for add,enter only Y or N    
    public String Ans_Add() {
        String a;
        while (true) {
            a = sc.nextLine();
            if (a.matches("^[yYnN]+$")) {
                break;
            } else {
                System.err.println("Only Enter(Yes(Y) or No(N)!!!");
                System.out.print("Re-Enter: ");
            }
        }
        return a;
    }

}
