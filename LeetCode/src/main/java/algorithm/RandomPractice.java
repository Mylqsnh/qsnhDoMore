package algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomPractice {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        List<String> fileList = new ArrayList<>();
        getAllFiles(new File(property + "/src/main/java/algorithm"), fileList);
        Collections.shuffle(fileList);
        System.out.println(fileList.get(0));
    }

    public static void getAllFiles(File folder, List<String> fileList) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileList.add(file.getName());
                } else if (file.isDirectory()) {
                    getAllFiles(file, fileList);
                }
            }
        }
    }
}
