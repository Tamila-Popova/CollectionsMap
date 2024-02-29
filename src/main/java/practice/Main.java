package practice;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер, имя или команду: ");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("LIST")) {
                for (String list : phoneBook.getAllContacts()) {
                    System.out.println(list);
                }
                break;
            }

            if (phoneBook.getNumFormat(input)) {
                System.out.println("Такого номера нет в телефонной книге." + "\n\r" + "Введите имя для абонента номера " + input + ": ");
                String name = sc.nextLine();
                phoneBook.addContact(input, name);
                System.out.println("Контакт сохранен!");
            }
            if (phoneBook.getNameFormat(input)) {
                System.out.println("Такого имени нет в телефонной книге." + "\n\r" + "Введите номер для абонента с именем " + input + ": ");
                String phone = sc.nextLine();
                phoneBook.addContact(phone, input);
                System.out.println("Контакт сохранен!");
            }
        }
    }
}
