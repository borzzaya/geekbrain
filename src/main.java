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

        lesson5.Employee[] employees = new lesson5.Employee[5];

        employees[0] = new lesson5.Employee("Иванов Иван Иванович"
                , "Менеджер"
                , "email@me.ru"
                , "123456789"
                , 123
                , 23
        );

        employees[1] = new lesson5.Employee("Петрова Вера Ивановна"
                , "бухгалтер"
                , "buh@me.ru"
                , "126586789"
                , 1235
                , 50
        );

        employees[2] = new lesson5.Employee("Сидорова Ольга Петровна"
                , "Уборщица"
                , "ubor@me.ru"
                , "123145789"
                , 321
                , 57
        );

        employees[3] = new lesson5.Employee("Петров Петр Петрович"
                , "Директор"
                , "dir@me.ru"
                , "1234615493"
                , 123654
                , 40
        );

        employees[4] = new lesson5.Employee("Иванова Зоя Ивановна"
                , "секретарь"
                , "sekr@me.ru"
                , "123124589"
                , 12312
                , 27
        );

        boolean header = true;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].printToConsole(header);
                header = false;
            }
        }


    }
}
