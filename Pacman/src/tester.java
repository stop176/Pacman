import java.util.Scanner;


public class tester {
    public static void main(String[]args){

        System.out.print("hello world");

        double y = 140.02;
        char z = 'c';
        System.out.print(z);
        int sum=0;
        for(int i = 1; i<=100; i++){
            sum+=i*i;
        }
        System.out.print(fraction(3,5));
    }

    public static double fraction(int m, int n){
        double sum =0;
        if(m>0 && n>0 &&m<n){
            for(m=m; m<=n; m++){
                sum+=(1/((double)m));

            }


        }
        return sum;
    }

    public String fractions(int num, int den, int num2, int den2){

        int sumNum = num*den2+num2*den;
        int sumDen = den*den2;






         return "sumNum"+ "/"+"sumDen";
    }

    public int inputString(){

        int x = 0;

        Scanner scan = new Scanner(System.in);
        String name =scan.next();
        name.replaceAll(",// *()&^%$#@!:<>?|", "");
        return name.length();
    }


    public double newton(double x){

        double root = 1;
        for(int i =0; i<=25; i++){
            root = x/root;
            root = (x+root)/2;

        }

        return root;
    }







}
