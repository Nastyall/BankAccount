public class Main {
    public static void main(String[] args) {
        System.out.println(" БАНКОВСКАЯ СИСТЕМА ");


        BankAccount user1 = new BankAccount("Иван Иванов");
        BankAccount user2 = new BankAccount("Мария Иванова");


        System.out.println("\n СОЗДАНЫ СЧЕТА");
        System.out.println("Счет 1: " + user1);
        System.out.println("Счет 2: " + user2);


        System.out.println("\n ПОПОЛНЕНИЕ СЧЕТА");
        boolean result = user1.deposit(5000);
        System.out.println("Пополнение счета на 5000: " + (result ? "успешно" : "ошибка"));
        System.out.println("Баланс после пополнения: " + user1.getBalance() + " руб.");


        System.out.println("\nСНЯТИЕ СРЕДСТВ");
        result = user1.withdraw(2000);
        System.out.println("Снятие 2000 руб: " + (result ? "успешно" : "ошибка"));
        System.out.println("Баланс после снятия: " +user1.getBalance() + " руб.");


        result = user1.withdraw(5000);
        System.out.println("Снятие 5000 руб: " + (result ? "успешно" : "ошибка"));
        System.out.println("Баланс: " + user1.getBalance() + " руб.");


        System.out.println("\nПЕРЕВОД МЕЖДУ СЧЕТАМИ");
        System.out.println("До перевода:");
        System.out.println("Счет 1: " + user1.getBalance() + " руб.");
        System.out.println("Счет 2: " + user2.getBalance() + " руб.");

        result = user1.transfer(user2, 500);
        System.out.println("Перевод 500 руб: " + (result ? "успешно" : "ошибка"));

        System.out.println("После перевода:");
        System.out.println("Счет 1: " + user1.getBalance() + " руб.");
        System.out.println("Счет 2: " + user2.getBalance() + " руб.");


        System.out.println("\nБЛОКИРОВКА СЧЕТА");
        user1.setBlocked(true);
        System.out.println("Счет заблокирован: " + (result? "да":"нет"));


        result = user1.deposit(1000);
        System.out.println("Пополнение заблокированного счета: " + (result ? "успешно" : "ошибка"));

        result = user1.withdraw(500);
        System.out.println("Снятие с заблокированного счета: " + (result ? "успешно" : "ошибка"));


        user1.setBlocked(false);
        System.out.println("Счет разблокирован: " + (result? "да": "нет"));

        System.out.println("\nНОМЕРА СЧЕТОВ И СРАВНЕНИЕ");
        System.out.println("Номер счета 1: " + user1.getNumber());
        System.out.println("Номер счета 2: " + user2.getNumber());
        System.out.println("Счета одинаковые? " + (result? "да": "нет"));

        System.out.println("\n ФИНАЛЬНОЕ СОСТОЯНИЕ СЧЕТОВ");
        System.out.println("Счет 1: " + user1 +" Номер счета:"+user1.getNumber());
        System.out.println("Счет 2: " + user2 +" Номер счета:"+user2.getNumber());


    }
}