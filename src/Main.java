import java.io.File;
import java.util.Scanner;

public class Main {
    private static void listMenu() {
        String title = """
                TỪ ĐIỂN ANH VIỆT""";
        String menu =
                """
                        1. Tra từ
                        2. Thêm từ
                        3. Xóa từ
                        4. Sửa từ
                        5. Thoát chương trình""";
        System.out.println("\n" + title + "\n" + menu);
    }

    public static void main(String[] args) {
        String command = "";
        try {
            AVLTree tree = new AVLTree();
            do {
                Scanner input = new Scanner(System.in);
                listMenu();
                System.out.print("Nhập vào lựa chọn của bạn: ");
                command = input.nextLine();
                switch (command) {
                    case "1" -> {
                        System.out.print("-> Nhập vào từ cần tra cứu: ");
                        String word = input.nextLine();
                        Word result = tree.search(word);
                        if (result == null)
                            System.out.println("-> Từ bạn cần tìm chưa có trong từ điển!");
                        else System.out.println("-> Kết quả: \n" + result);
                    }
                    case "2" -> {
                        System.out.print("-> Nhập vào từ cần thêm: ");
                        String value = input.nextLine();
                        System.out.print("-> Nhập vào nghĩa (Nhấn Enter để bỏ qua): ");
                        String definition = input.nextLine();
                        if (!tree.add(value, definition))
                            System.out.println("-> Thêm không thành công!");
                        else System.out.println("-> Thêm thành công!");
                    }
                    case "3" -> {
                        System.out.print("-> Nhập vào từ cần xóa: ");
                        String value = input.nextLine();
                        if (!tree.remove(value))
                            System.out.println("-> Xóa không thành công!");
                        else System.out.println("-> Xóa thành công!");
                    }
                    case "4" -> {
                        System.out.print("-> Nhập vào từ cần sửa: ");
                        String value = input.nextLine();
                        System.out.print("-> Nhập vào từ mới (Nhấn Enter để bỏ qua): ");
                        String newValue = input.nextLine();
                        System.out.print("-> Nhập vào nghĩa (Nhấn Enter để bỏ qua): ");
                        String newDefinition = input.nextLine();
                        if (!tree.edit(value, newValue, newDefinition))
                            System.out.println("-> Sửa không thành công!");
                        else System.out.println("-> Sửa thành công!");
                    }
                    case "5" -> {
                        System.out.println("-> Cảm ơn bạn");
                        tree.save(tree.getRoot());
                        File file = new File("src/tmp~.txt");
                        boolean isRenamed  = file.renameTo(new File("src/dict.txt"));
                        if (!isRenamed)
                            throw new Exception();
                        input.close();
                    }
                    default -> {
                        System.out.println("-> Dữ liệu không hợp lệ!");
                    }
                }
            }
            while (!command.equals("5"));
        } catch (Exception e) {
            System.out.println(e.getMessage() == null ? "Lỗi" : e.getMessage());
        }
    }
}
