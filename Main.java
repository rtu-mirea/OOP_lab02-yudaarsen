import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int menu;
        do
        {
            System.out.println("Меню\n1 - Задание 1\n2 - Задание 2\n3 - Задание 3\n0 - Выход");
            menu = in.nextInt();
            switch (menu) {
                case 0: return;
                case 1:
                    startTask1();
                    break;
                case 2:
                    startTask2();
                    break;
                case 3:
                    startTask3();
                    break;
                default:
                    System.out.println("Неверная операция");
                    System.out.println("Меню\n1 - Задание 1\n2 - Задание 2\n3 - Задание 3\n0 - Выход");
            }

            }while(menu  != 0);
    }

    public static void startTask1() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите список товаров в формате: название цена;");
        Task1 t = new Task1(in.nextLine());
        System.out.println("Сумма: " + t.priceSum());
        System.out.println("Первые буквы прописные: " + t.chageLetter());
        System.out.println("Рейтинг: " + t.topList());
        System.out.println("Введите индекс, по которому найти товар (начиная с 0):");
        int index = in.nextInt();
        System.out.println("Товар по индексу " + index + ": " + t.getProduct(index));
    }

    public static void startTask2() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите список товаров в формате: название цена;");
        Task2 t = new Task2(in.nextLine());
        System.out.println("Удалены нулевые стоимости: " + t.deleteZero());
        t.changeMinToMax();
        System.out.println("Ввдите название и стоимость продукта, который хотите добавить: ");
        t.addProduct(in.nextLine());
    }

    public static void startTask3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку даты: ");
        Task3 t = new Task3(in.nextLine());
        t.isDateFormat();
        System.out.println("Введите текст с датами: ");
        t.changeFormat(in.nextLine());
    }
}
