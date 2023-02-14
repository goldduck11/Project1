import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class TSpisok {
    void WorkWithSpisok() throws IOException {
        WorkWithFile WWF = new WorkWithFile();
        String FileName = WWF.CreateFile();
        Scanner sc = new Scanner(System.in);
        List<String> list = WWF.FileReader(FileName, StandardCharsets.UTF_8);
        ArrayList<TPerson> TP = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] words = str.split(" ");
            switch (words.length) {
                case 3: {
                    TP.add(TP.size(), new TPerson(words[0],words[1],words[2]));
                    break;
                }
                case 4: {
                    TP.add(TP.size(), new TSotrudnik(words[0],words[1],words[2], words[3]));
                    break;
                }
                case 5: {
                    TP.add(TP.size(),new TStudent(words[0],words[1],words[2], words[3],words[4]));
                    break;
                }
            }
        }
        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("Нажмите 1, чтобы прочитать данные из файла.");
            System.out.println("Нажмите 2, чтобы найти человека по индексу.");
            System.out.println("Нажмите 3, чтобы найти получить ссылку на индекс человека.");
            System.out.println("Нажмите 4, чтобы записать данные.");
            System.out.println("Нажмите 5, чтобы завершить работу с файлом и записать данные.");
            System.out.print("Введите значение: ");
            Integer num = sc.nextInt();
            switch (num) {
                case 1: {
                    PrintSpisok(TP);
                    break;
                }
                case 2: {
                    indexPeople(TP);
                    break;
                }
                case 3: {
                    linkPeaple(TP);
                    break;
                }
                case 4: {
                    addPerson(TP);
                    break;
                }
                case 5: {
                    WWF.FileWriter(FileName, TP);
                    exit(0);
                }
            }
        }

    }

    //Выводит список людей на экран.
    void PrintSpisok(ArrayList<TPerson> TP) {
        System.out.println("\nСписок людей: ");
        for (int i = 0; i < TP.size(); i++) {
            System.out.println(TP.get(i).getFullData());
        }
        System.out.println();
    }


    //Поиск человека по номеру в списке.
    void indexPeople(ArrayList<TPerson> TP) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nВведите индекс какого человека вы хотите увидеть:");
        Integer count = sc.nextInt() - 1;
        try  {
            System.out.println(TP.get(count).getFullData());
        }
        catch ( IndexOutOfBoundsException e){
            System.out.println("Index out of range");
        }
        System.out.println();
    }

    //Ссылка на объект
    void linkPeaple(ArrayList<TPerson> TP){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nВведите индекс какого человека вы хотите увидеть:");
        Integer count = sc.nextInt() - 1;
        try  {
            System.out.println(TP.get(count));
        }
        catch ( IndexOutOfBoundsException e){
            System.out.println("Index out of range");
        }
        System.out.println();
    }

    //Добавление нового человека в список
    ArrayList<TPerson> addPerson(ArrayList<TPerson> TP) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nКакое количество людей вы хотели бы записать: ");
        Integer num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.print("Введите данные человека, которого хотите записать: ");
            String data;
            if (i==0) {
                data = sc.nextLine();
                data = sc.nextLine();
            }
            else {
                data = sc.nextLine();
            }
            String[] words = data.split(" ");
            switch (words.length) {
                case 3: {
                    TP.add(TP.size(),new TPerson(words[0],words[1],words[2]));
                    break;
                }
                case 4: {
                    TP.add(TP.size(), new TSotrudnik(words[0],words[1],words[2],words[3]));
                    break;
                }
                case 5: {
                    if (Integer.parseInt(words[4]) < 1 || Integer.parseInt(words[4]) > 5){
                        while (Integer.parseInt(words[4]) < 1 || Integer.parseInt(words[4]) > 5){
                            System.out.println("Произведите повторный ввод студента.(Курс должен быть c 1 по 5");
                            data = sc.nextLine();
                            words = data.split(" ");
                        }
                    }
                    TP.add(TP.size(), new TStudent(words[0],words[1],words[2],words[3],words[4]));
                    break;
                }
            }
        }
        return TP;
    }
}
