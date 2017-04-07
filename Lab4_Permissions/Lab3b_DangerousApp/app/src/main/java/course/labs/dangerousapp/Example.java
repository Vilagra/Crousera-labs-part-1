package course.labs.dangerousapp;

/**
 * Created by Vilagra on 03.03.2017.
 */

public class Example {
    public static void main(String[] args) {
        double a = 0;
        double b = 10;
        double c = 0;
        double discriminat = b*b - 4*a*c;
        if(discriminat>0&&a!=0){
            System.out.println("x1=" + ((-b+Math.sqrt(discriminat))/(2*a)));
            System.out.println("x2=" + ((-b-Math.sqrt(discriminat))/(2*a)));
        }
        else if(discriminat==0&&a!=0){
            System.out.println("x1=" + ((-b+Math.sqrt(discriminat))/2*a));
            System.out.println("x2=" + ((-b+Math.sqrt(discriminat))/2*a));
        }
        else {
            System.out.println("x1=");
            System.out.println("x2=");
        }
    }
}
