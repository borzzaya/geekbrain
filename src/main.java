import lesson6.Cat;
import lesson6.Dog;
import lesson8.window;

public class main {
    public static void main(String[] args) {
        //lesson1 lesson1 = new lesson1();
        //lesson1.lesson1Run();

        //lesson2 lesson2 = new lesson2();
        //lesson2.lesson2Run();

        // classLesson3 lesson3 = new classLesson3();
        // lesson3.start();a

        //classLesson4 lesson4 = new classLesson4();
        //lesson4.ticTacToe();

//        lesson5.Employee[] employees = new lesson5.Employee[5];
//
//        employees[0] = new lesson5.Employee("Иванов Иван Иванович"
//                , "Менеджер"
//                , "email@me.ru"
//                , "123456789"
//                , 123
//                , 23
//        );
//
//        employees[1] = new lesson5.Employee("Петрова Вера Ивановна"
//                , "бухгалтер"
//                , "buh@me.ru"
//                , "126586789"
//                , 1235
//                , 50
//        );
//
//        employees[2] = new lesson5.Employee("Сидорова Ольга Петровна"
//                , "Уборщица"
//                , "ubor@me.ru"
//                , "123145789"
//                , 321
//                , 57
//        );
//
//        employees[3] = new lesson5.Employee("Петров Петр Петрович"
//                , "Директор"
//                , "dir@me.ru"
//                , "1234615493"
//                , 123654
//                , 40
//        );
//
//        employees[4] = new lesson5.Employee("Иванова Зоя Ивановна"
//                , "секретарь"
//                , "sekr@me.ru"
//                , "123124589"
//                , 12312
//                , 27
//        );
//
//        boolean header = true;
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i].getAge() > 40) {
//                employees[i].printToConsole(header);
//                header = false;
//            }
//        }

//        lesson6.Cat Murzik = new lesson6.Cat();
//        lesson6.Dog Tuzik = new lesson6.Dog();
//        lesson6.Dog Pers = new lesson6.Dog();
//        Pers.initLimit(700, 1, 5);
//        System.out.println("Перс пробегает 650:"+Pers.run(650));
//
//        lesson6.Dog Imar = new lesson6.Dog();
//        Imar.initLimit(1000, (float)1.5, 0);
//        System.out.println("Имар подпрыгнул на 1,3 м:"+ Imar.jump((float)1.3));
//        System.out.println("Имара отправили плавать на 5 метров:"+Imar.swim(5));
//
//        System.out.println("Мурзик прыгает на 1 метр:" + Murzik.jump(1));
//        System.out.println("Мурзик пробежал 75 метров:" + Murzik.run(75));
//        System.out.println("Мурзик пробежал 350 метров:" + Murzik.run(350));
//        System.out.println("Мурзик проплыл 3 метра:" + Murzik.swim(3));
//
//        System.out.println("Тузик прыгает на 0,5 метра:" + Tuzik.jump((float)0.5));
//        System.out.println("Тузик прыгает на 5 метров:" + Tuzik.jump((float)5));
//        System.out.println("Тузик пробежал 450 метров:" + Tuzik.run(450));
//        System.out.println("Тузик проплыл 8 метров:" + Tuzik.swim(8));

//        lesson7.Cat cat = new lesson7.Cat("Barsik", 5);
//        lesson7.Plate plate1 = new lesson7.Plate(100);
//        plate1.info();
//        cat.eat(plate1);
//        cat.PrintSatiety();
//        plate1.info();
//
//        lesson7.Plate plate2 = new lesson7.Plate(4);
//        plate2.info();
//        cat.eat(plate2);
//        cat.PrintSatiety();
//        plate2.info();
//
//        lesson7.Cat[] Cats = new lesson7.Cat[5];
//        Cats[0] = new lesson7.Cat("Murzik", 20);
//        Cats[1] = new lesson7.Cat("Nura", 20);
//        Cats[2] = new lesson7.Cat("Pushok", 20);
//        Cats[3] = new lesson7.Cat("Marusya", 20);
//        Cats[4] = new lesson7.Cat("Nafanya", 20);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Ест кот "+Cats[i].getName());
//            Cats[i].eat(plate1);
//            Cats[i].PrintSatiety();
//            plate1.info();
//        }
//
//        plate1.increaseFood(10);
//        plate1.info();
        window myWindow = new window();
        myWindow.setVisible(true);

    }
}
