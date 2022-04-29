import java.util.Scanner;

public class TempConverter {


    private static double celc;
    private static double fahr;
    private static double kelv;

    static void convertCelc(double celc){
        fahr = celc*1.8+30;
        kelv = celc+273.15;
    }
    static void convertFahr(double fahr){
        celc = (fahr-32)/1.8;
        kelv = (fahr+459.67)*(5/9);  // 5/9 is nearly equal to 0.5555555555
    }
    static void convertKelv(double kelv){
        fahr = kelv*(9/5)-459.67;
        celc = kelv-273.15;
    }
    static double getCelc(){
        return celc;
    }
    static double getKelv(){
        return kelv;
    }
    static double getFahr(){
        return fahr;
    }

    public static void main(String[] args){

        String fullTypeName = "";

        Scanner myObj = new Scanner(System.in);
        System.out.println("Choose type of temperature to convert.\n For fahrenheit type \"fahr\"\n For celcius type \"celc\"\n For kelvin type \"kelv\"\n");

        String typeOfTemp = myObj.nextLine();
        if(typeOfTemp.equals("kelv")){    // spróbuj zamienić na switch
            fullTypeName = "kelvin";
        }else if(typeOfTemp.equals("celc")){
            fullTypeName = "celcius";
        }else if(typeOfTemp.equals("fahr")){
            fullTypeName = "fahrenheit";
        }else{
            System.out.println("Wrong type. Try again.");
            System.exit(0);
        }

        System.out.println("Type of temperature to convert is " +fullTypeName +".\nPlease enter the temperature value in "+fullTypeName+" to convert, seperate with coma.");

        double degrees = myObj.nextDouble();

        System.out.println("temperature is: "+degrees +" "+ fullTypeName);

        // to jest brzydkie, zaokrąglij to
        if(typeOfTemp.equals("kelv")){
            convertKelv(degrees);
            System.out.println(getCelc()+" C");
            System.out.println(getFahr()+" F");
            System.out.println(degrees+" K");
        }else if(typeOfTemp.equals("celc")){
            convertCelc(degrees);
            System.out.println(degrees +" C");
            System.out.println(getFahr()+" F");
            System.out.println(getKelv()+" K");
        }else{
            convertFahr(degrees);
            System.out.println(getCelc()+" C");
            System.out.println(degrees+" F");
            System.out.println(getKelv()+" K");
        }
    }

}
