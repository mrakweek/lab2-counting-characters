import java.io.*;

public class Main {
    public static void main(String[] args) {

        int a[] = new int[52];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        System.out.print("Введите имя файла: ");

        try {
            filename = reader.readLine();
            File file = new File(filename);

            if (!file.exists()) {
                System.out.println("Файла с таким именем не существует");
                return;
            }
            FileInputStream input = new FileInputStream(file);

            //подсчёт букв входного файла
            int simb;
            while ((simb = input.read()) != -1) {
                int tmp_simb = (int) simb;
                if ((tmp_simb >= 65) && (tmp_simb <= 90)) {
                    a[tmp_simb - 65] += 1;
                }

                if ((tmp_simb >= 97) && (tmp_simb <= 122)) {
                    a[tmp_simb - 71] += 1;
                }
            }

            for (int i = 0; i < 52; i++) {
                if (i <= 25) {
                    System.out.print((char) (i + 65) + " - ");
                    System.out.println(a[i]);
                } else {
                    System.out.print((char) (i + 71) + " - ");
                    System.out.println(a[i]);
                }
            }
            input.close();

            //создание файла для записи результатов подчёта
            System.out.print("Введите имя файла, в который будут записаны результаты: ");
            String outputFilename = reader.readLine();
            outputFilename = outputFilename + ".txt";
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename, true)));

            //запись результатов подсчёта в новый файл
            for (int i = 0; i < 52; i++) {
                if (i <= 25) {
                    writer.print((char) (i + 65) + " - ");
                    writer.println(a[i]);
                } else {
                    writer.print((char) (i + 71) + " - ");
                    writer.println(a[i]);
                }

            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Ошибка файла" + e.getMessage());
        }
    }
}