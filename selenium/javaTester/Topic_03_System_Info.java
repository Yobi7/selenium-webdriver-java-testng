package javaTester;

public class Topic_03_System_Info {
    public  static void main(String args[]) {

        // lấy ra đường dẫn tương đối tại thư mục hiện tại
        String projectPath = System.getProperty("user.dir");
        System.out.println("Đường dẫn hiện tại là:" + projectPath);

    }
}
