package pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        double len = 5;
        double a=4;
        double b=6;

        System.out.println("Hello World!");
        System.out.println("Площадь квадрата со стороной " +len + " = " + area(len));
        System.out.println("Площадь прямоугольника со сторонами " + a + " и "+ b + " = " + area(a,b));

    }

        public static double area(double l)
    {
return l*l;
    }

    public static double area(double a, double b)
    {
        return a*b;
    }

    }

