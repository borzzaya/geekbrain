public class lesson1 {
    /*
    1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
    3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

     */

    public void lesson1Run() {


    }

    public void ex1() {
        byte a = 12;
        short b = 30000;
        int c = -128000;
        long d = 3568425L;
        float e = 45.78f;
        double f = -35.95;
        char g = '#';
        boolean h = true;
        String j = "Моя первая строка";
    }

    public double calc1(double a, double b, double c, double d){
        return a * (b + (c / d));
    }

    public boolean calc2(double x, double z){
        double sum = x+z;
        if ((sum>=10) & (sum<=20)){
            return true;
        }
        return false;
    }

    public void print1(int w){
        if (w>=0){
            System.out.println("Число положительное");
        }else {
            System.out.println("Число отрицательное");
        }
    }
    public boolean checkPositive(int r){
        if (r<0){
            return true;
        }
        return false;
    }
    public void print2(String name){
        System.out.println("Привет," + name + "!");
    }
}
