import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class WorkWithFile {
    String CreateFile() throws IOException {
        String FileName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Хотите ли вы сами указать путь к файлу?(Yes/No)");
        System.out.print("Ответ: ");
        String flag = sc.nextLine();
        if (!flag.equalsIgnoreCase("Yes") && !flag.equalsIgnoreCase("No")){
            do{
                System.out.println("Неправильный ввод. Попробуйте снова.");
                System.out.println("Хотите ли вы сами указать путь к файлу?(Yes/No)");
                System.out.print("Ответ: ");
                flag = sc.nextLine();
            }while (!flag.equalsIgnoreCase("Yes") && !flag.equalsIgnoreCase("No"));
        }
        if (flag.equalsIgnoreCase("Yes")) {
            System.out.print("Введите путь к вашему файлу: ");
            FileName = sc.nextLine();
            Path path = Paths.get(FileName.toString());
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл был открыт");
            }
            List<String> list = Files.readAllLines(path);
        } else{
            FileName = "temp.dat.txt";
            Path path = Paths.get(FileName);
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("файл создан");
            } else {
                System.out.println("Файл был открыт");
            }
        }

        return FileName;
    }

    List<String> FileReader(String FileName, Charset utf8) throws IOException {
        Path path = Paths.get(FileName);
        List<String> list = Files.readAllLines(path);
        return list;
    }

    void FileWriter(String FileName, ArrayList<TPerson> TP) throws IOException {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        Path path = Paths.get(FileName);
        if (flag) {
            Files.write(path, Collections.singleton(""));
            flag = false;
        }
        for (int i = 0; i < TP.size(); i++) {
            String str = TP.get(i).getFullData();
            if (i == 0) {
                Files.writeString(path, str);
            } else {
                Files.writeString(path, "\n", StandardOpenOption.APPEND);
                Files.writeString(path, str, StandardOpenOption.APPEND);
            }
        }
    }


    //Поиск в файле по заданному параметру
    /*void FindOnFile(String FileName) throws IOException {
        Path path = Paths.get(FileName);
        String find = "Волков";
        try (Stream<String> lines = Files.lines(path)) {
            if (lines.anyMatch(l -> l.contains(find))) {
                System.out.println("found");
            } else {
                System.out.println("not found");
            }
        }
    }*/
}
