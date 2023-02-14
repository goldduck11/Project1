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
        System.out.println("������ �� �� ���� ������� ���� � �����?(Yes/No)");
        System.out.print("�����: ");
        String flag = sc.nextLine();
        if (!flag.equalsIgnoreCase("Yes") || !flag.equalsIgnoreCase("No")){
            do{
                System.out.println("������������ ����. ���������� �����.");
                System.out.println("������ �� �� ���� ������� ���� � �����?(Yes/No)");
                System.out.print("�����: ");
                flag = sc.nextLine();
            }while (!flag.equalsIgnoreCase("Yes") && !flag.equalsIgnoreCase("No"));
        }
        if (flag.equalsIgnoreCase("Yes")) {
            System.out.print("������� ���� � ������ �����: ");
            FileName = sc.nextLine();
            Path path = Paths.get(FileName.toString());
            List<String> list = Files.readAllLines(path);
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("���� ������");
            } else {
                System.out.println("���� ��� ������");
            }
        } else{
            FileName = "temp.dat.txt";
            Path path = Paths.get(FileName);
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("���� ������");
            } else {
                System.out.println("���� ��� ������");
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


    //����� � ����� �� ��������� ���������
    /*void FindOnFile(String FileName) throws IOException {
        Path path = Paths.get(FileName);
        String find = "������";
        try (Stream<String> lines = Files.lines(path)) {
            if (lines.anyMatch(l -> l.contains(find))) {
                System.out.println("found");
            } else {
                System.out.println("not found");
            }
        }
    }*/
}