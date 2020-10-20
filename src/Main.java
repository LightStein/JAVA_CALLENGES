import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Documents");

        File[] fileList = file.listFiles(new FileFilter(){
            public boolean accept(File file) {
                System.out.println(file.getName());
                return file.getName().contains("secret");
            }
        });

        for (File currentFile : fileList){
            File dest = new File("F:\\stolenFiles\\"+currentFile.getName());
            Files.copy(currentFile.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
