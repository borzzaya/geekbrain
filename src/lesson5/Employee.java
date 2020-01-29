package lesson5;

//* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
//* Конструктор класса должен заполнять эти поля при создании объекта;
//* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
//* Создать массив из 5 сотрудников
//* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
public class Employee {
    private String fio;
    private String position;
    private String email;
    private String tel;
    private float salary;
    private int age;

    public Employee(String _fio, String _position, String _email, String _tel, float _salary, int _age) {
        fio = _fio;
        position = _position;
        email = _email;
        tel = _tel;
        salary = _salary;
        age = _age;
    }

    public void printToConsole(boolean header) {

        if (header) {
            System.out.println(SetWidth("ФИО", 30)
                    + SetWidth("Должность", 20)
                    + SetWidth("email", 20)
                    + SetWidth("Телефон", 12)
                    + SetWidth("Зарплата", 10)
                    + SetWidth("Возраст", 7)
            );
        }

        System.out.println(SetWidth(fio, 30)
                + SetWidth(position, 20)
                + SetWidth(email, 20)
                + SetWidth(tel, 12)
                + SetWidth(String.valueOf(salary), 10)
                + SetWidth(String.valueOf(age), 7)
        );
    }


    private String SetWidth(String inputString, int width) {
        String resultString = inputString;
        while (resultString.length() < width) {
            resultString += " ";
        }

        return resultString;
    }

    public int getAge() {
        return age;
    }

}
