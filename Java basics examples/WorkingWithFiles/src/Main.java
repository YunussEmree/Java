import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        createfile("C:\\Users\\Yunus Emre\\Desktop\\Files\\Kariyer\\Full Stack Development\\Java\\simple examples\\WorkingWithFiles\\src\\files\\students.txt");
        getfileinfo("C:\\Users\\Yunus Emre\\Desktop\\Files\\Kariyer\\Full Stack Development\\Java\\simple examples\\WorkingWithFiles\\src\\files\\students.txt");
        writefile("C:\\Users\\Yunus Emre\\Desktop\\Files\\Kariyer\\Full Stack Development\\Java\\simple examples\\WorkingWithFiles\\src\\files\\students.txt");
        readfile("C:\\Users\\Yunus Emre\\Desktop\\Files\\Kariyer\\Full Stack Development\\Java\\simple examples\\WorkingWithFiles\\src\\files\\students.txt");
    }


    public static void writefile(String path){
        try {
            //FileWriter file = new FileWriter(path);
            //BufferedWriter writer = new BufferedWriter(file);
            //BufferedWriter writer = new BufferedWriter(new FileWriter(path)); //bu şekilde dosyanın üzerine yazar bunu engellemek için prametre olarak true değerini ekliyoruz.
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.newLine();
            writer.write("Mehmet");
            System.out.println("Dosyaya yazıldı.");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void readfile(String path){
        File file = new File(path);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getfileinfo(String path){
        File file = new File(path);

        if(file.exists()){
            System.out.println("Dosya adı : " + file.getName());
            System.out.println("Dosya yolu : " + file.getPath()); // gets the path string that the File object was constructed with, and it may be relative current directory
            System.out.println("Dosya yolu : " + file.getAbsolutePath()); // gets the path string after resolving it against the current directory if it's relative, resulting in a fully qualified path
            try {
                System.out.println("Dosya yolu : " + file.getCanonicalPath()); // gets the path string after resolving any relative path against current directory, and removes any relative pathing (. and ..), and any file system links to return a path which the file system considers the canonical means to reference the file system object to which it points.
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Dosya okunabilir mi : " + file.canRead());
            System.out.println("Dosya düzenlenebilir mi : " + file.canWrite());
            System.out.println("Dosya execute edilebilir mi : " + file.canExecute());
            System.out.println("Dosya boyutu (byte) : " + file.length());
        }
    }

    public static void createfile(String path){

        File file = new File(path);

        try {
            if(file.createNewFile()) System.out.println("Dosya oluşturuldu."); //Eğer dosya oluşturabildiyse true değerini döndürür ama oluşturamadıysa false değerini döndürür.
            else System.out.println("Dosya zaten mevcut.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}