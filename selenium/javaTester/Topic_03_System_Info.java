package javaTester;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;

import java.io.File;

public class Topic_03_System_Info {
    public  static void main(String args[]) {

        // lấy ra đường dẫn tương đối tại thư mục hiện tại
        String projectPath = System.getProperty("user.dir");
        System.out.println("Đường dẫn hiện tại là:\n" + projectPath);


        String hnName = "HaNoi.jpg";
        String hnFilePath = projectPath + "\\uploadFiles\\" + hnName;

        System.out.println("Đường dẫn uploadfiles:\n" + hnFilePath);


        // Auto cho Mac - Win
        String osName = System.getProperty("os.name");
        System.out.println("System hiện tại là: " + osName + "\n");

        Keys keys;
        if (osName.startsWith("Windows")){
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;        }

        Keys cmdCtrl = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND;

        String character = Platform.getCurrent().is(Platform.WINDOWS) ? "\\" : "/";
        System.out.println("Đường dẫn window/mac:\n"
                + projectPath + character + "uploadFiles" + character + hnName);


        // 1 cách nữa
        System.out.println(
                projectPath + File.separator + "uploadFiles" + File.separator + hnName);

        System.out.println(File.separator);

    }
}
