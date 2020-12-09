package dict;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class AVLTree {
    private AVLNode root;

    /**
     * @param currentNode Node hiện tại
     * @return chiều cao của cây
     */
    private int getHeight(AVLNode currentNode) {
        return currentNode == null ? 0 : currentNode.getHeight();
    }

    /**
     * @param currentNode Node hiện tại
     * @return chỉ số cân bằng của cây hiện tại
     * @implNote tính chiều cao của cây con bên trái trừ đi chiều cao của cây con bên phải
     */
    private int getBalanceFactor(AVLNode currentNode) {
        return currentNode == null ? 0 : getHeight(currentNode.getLeft()) - getHeight(currentNode.getRight());
    }

    /**
     * @param currentNode Node hiện tại
     * @return giá trị nhỏ nhất của cây
     * @implNote giá trị nhỏ nhất nằm ở Node cực trái của cây
     */
    private AVLNode getMinimumValue(AVLNode currentNode) {
        AVLNode newNode = currentNode;
        while (newNode.getLeft() != null)
            newNode = newNode.getLeft();
        return newNode;
    }

    /**
     * @param currentNode Node hiện tại
     * @return Cây kết quả sau khi thực hiện phép quay trái của Node hiện tại
     */
    private AVLNode rotateLeft(AVLNode currentNode) {
        AVLNode returnedNode = currentNode.getRight();
        AVLNode tempNode = returnedNode.getLeft();
        returnedNode.setLeft(currentNode);
        currentNode.setRight(tempNode);
        currentNode.setHeight(
                Math.max(
                        getHeight(currentNode.getLeft()),
                        getHeight(currentNode.getRight())
                ) + 1
        );
        returnedNode.setHeight(
                Math.max(
                        getHeight(returnedNode.getLeft()),
                        getHeight(returnedNode.getRight())
                ) + 1
        );
        return returnedNode;
    }

    /**
     * @param currentNode Node hiện tại
     * @return Cây kết quả sau khi thực hiện phép quay phải của Node hiện tại
     */
    private AVLNode rotateRight(AVLNode currentNode) {
        AVLNode returnedNode = currentNode.getLeft();
        AVLNode tempNode = currentNode.getRight();
        returnedNode.setRight(currentNode);
        currentNode.setLeft(tempNode);
        currentNode.setHeight(
                Math.max(
                        getHeight(currentNode.getLeft()),
                        getHeight(currentNode.getRight())
                ) + 1
        );
        returnedNode.setHeight(
                Math.max(
                        getHeight(returnedNode.getLeft()),
                        getHeight(returnedNode.getRight())
                ) + 1
        );
        return returnedNode;
    }

    /**
     *
     * @param value từ (tiếng Anh)
     * @param definition nghĩa hoặc định nghĩa của từ
     * @return true nếu thêm thành công, ngược lại trả về false
     */
    public boolean add (String value, String definition) {
        try {
            this.root = insertNode(this.root, new Word(value, definition));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * @param currentNode Node hiện tại
     * @param data từ và nghĩa (hoặc định nghĩa) của từ
     * @return Cây kết quả của cây hiện tại sau khi thêm thành công Node mới lên cây
     * @throws Exception Nếu từ được thêm đã có trong cây
     */
    private AVLNode insertNode(AVLNode currentNode, Word data) throws Exception {
         // Nếu cây rỗng, thêm từ đầu tiên vào cây
         // ngược lại, từ sẽ được thêm vào Node lá của Node hiện tại
        if (currentNode == null)
            return new AVLNode(data);

        // Nếu từ được thêm nhỏ hơn từ ở Node hiện tại, tiến hành thêm ở cây bên trái Node hiện tại
        if (currentNode.isGreaterThan(currentNode.getData().getValue(), data.getValue()))
            currentNode.setLeft(insertNode(currentNode.getLeft(), data));

            // nếu từ được thêm lớn hơn từ ở Node hiện tại, tiến hành thêm từ ở cây bên phải Node hiện tại
        else if (currentNode.isLessThan(currentNode.getData().getValue(), data.getValue()))
            currentNode.setRight(insertNode(currentNode.getRight(), data));

            // nếu từ được thêm đã có trong cây thì ném ngoại lệ (thêm không thành công)
        else throw new Exception();

        // Tính chiều cao của cây ở Node hiện tại
        currentNode.setHeight(
                Math.max(
                        getHeight(currentNode.getLeft()),
                        getHeight(currentNode.getRight())
                ) + 1
        );

        // Tính chỉ số cân bằng của cây
        int balFactor = getBalanceFactor(currentNode);

        if (balFactor > 1 && currentNode.isLessThan(data.getValue(), currentNode.getLeft().getData().getValue()))
            return rotateRight(currentNode);
        if (balFactor < -1 && currentNode.isGreaterThan(data.getValue(), currentNode.getRight().getData().getValue()))
            return rotateLeft(currentNode);
        if (balFactor > 1 && currentNode.isGreaterThan(data.getValue(), currentNode.getLeft().getData().getValue())) {
            currentNode.setLeft(rotateLeft(currentNode.getLeft()));
            return rotateRight(currentNode);
        }
        if (balFactor < -1 && currentNode.isLessThan(data.getValue(), currentNode.getLeft().getData().getValue())) {
            currentNode.setRight(rotateLeft(currentNode.getRight()));
            return rotateLeft(currentNode);
        }
        return currentNode;
    }

    /**
     *
     * @param value từ cần xóa
     * @return true nếu xóa thành công từ, ngược lại trả về false
     */
    public boolean remove (String value) {
        try {
            this.root = deleteNode(
                    this.root,
                    new Word(value, "")
            );
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param currentNode Node hiện tại
     * @param data Từ cần xóa
     * @return Cây kết quả sau khi xóa một Node trên cây
     * @throws Exception Nếu từ cần xóa không có trong cây
     */
    private AVLNode deleteNode (AVLNode currentNode, Word data) throws Exception{
        // Ném ngoại lệ nếu cây rỗng
        // hoặc nếu từ cần xóa không có trong cây
        if (currentNode == null)
            throw new Exception();

        // Nếu từ cần xóa nhỏ hơn Node hiện tại, tiến hành xóa ở cây con trái của Node hiện tại
        if (currentNode.isLessThan(data.getValue(), currentNode.getData().getValue()))
            currentNode.setLeft(deleteNode(currentNode.getLeft(), data));

        // nếu từ cần xóa lớn hơn Node hiện tại, tiến hành xóa ở cây con phải của Node hiện tại
        else if (currentNode.isGreaterThan(data.getValue(), currentNode.getData().getValue()))
            currentNode.setRight(deleteNode(currentNode.getRight(), data));

        // ngược lại, đây là Node cần xóa
        else {
            // Node hiện tại không có Node bên trái hoặc Node bên phải hoặc cả hai
            if (currentNode.getLeft() == null || currentNode.getRight() == null) {
                // cho tempNode nhận giá trị của Node con khác null, hoặc tempNode vẫn có giá trị null
                AVLNode tempNode = null;
                if (tempNode == currentNode.getLeft())
                    tempNode = currentNode.getRight();
                else tempNode = currentNode.getLeft();

                // Nếu tempNode vẫn bằng null thì Node hiện tại là Node lá
                if (tempNode == null) {
                    tempNode = currentNode;
                    currentNode = null;
                }
                else currentNode = tempNode;
            }

            // Ngược lại, tìm phần tử thế mạng
            else {
                AVLNode tempNode = getMinimumValue(currentNode.getRight());
                currentNode.setData(tempNode.getData());
                currentNode.setRight(deleteNode(currentNode.getRight(), tempNode.getData()));
            }
        }
        if (currentNode == null)
            return currentNode;

        // Cập nhật chiều cao của cây
        currentNode.setHeight(
                Math.max(
                        getHeight(currentNode.getLeft()),
                        getHeight(currentNode.getRight())
                ) + 1
        );

        // Tính chỉ số cân bằng cây
        int balFactor = getBalanceFactor(currentNode);

        // Trường hợp sau khi xóa Node cây mất cân bằng, tiến hành cân bằng lại cây
        // Quay đơn trái-trái
        if (balFactor > 1 && getBalanceFactor(currentNode.getLeft()) >= 0)
            return rotateRight(currentNode);

        // Quay kép trái-phải
        if (balFactor > 1 && getBalanceFactor(currentNode.getLeft()) < 0) {
            currentNode.setLeft(rotateLeft(currentNode.getLeft()));
            return rotateRight(currentNode);
        }

        // Quay đơn phải-phải
        if (balFactor < -1 && getBalanceFactor(currentNode.getRight()) <= 0)
            return rotateLeft(currentNode);

        // Quay kép phải-trái
        if (balFactor < -1 && getBalanceFactor(currentNode.getRight()) > 0) {
            currentNode.setRight(rotateRight(currentNode.getRight()));
            return rotateLeft(currentNode);
        }
        return currentNode;
    }

    /**
     * @param value từ cần sửa
     * @param newValue từ mới
     * @param newDefinition nghĩa hoặc định nghĩa mới
     * @return true nếu sửa thành công
     */
    public boolean edit (String value, String newValue, String newDefinition) {
        try {
            Word result = search (value);
            if (result != null) {
                if (newValue.isBlank()) {
                    if (newDefinition.isBlank())
                        throw new Exception();
                    else this.root = updateNode(this.root, new Word(value,""), new Word(value, newDefinition));
                } else {
                    if (newDefinition.isBlank())
                        this.root = updateNode(this.root, new Word(value,""), new Word(newValue, result.getDefinition()));
                    else this.root = updateNode(this.root, new Word(value, ""), new Word(newValue, newDefinition));
                }
            }
            else throw new Exception();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * @param currentNode Node hiện tại
     * @param currentData Từ cũ
     * @param dataToUpdate Từ mới
     * @return Cây kết quả của Node hiện tại sau khi thêm một Node mới (trong trường hợp từ cũ khác từ mới)
     * @throws Exception nếu không thêm hoặc không xóa được
     */
    private AVLNode updateNode (AVLNode currentNode, Word currentData, Word dataToUpdate) throws Exception {
        currentNode = deleteNode(currentNode, currentData);
        currentNode = insertNode(currentNode, dataToUpdate);
        return currentNode;
    }

    /**
     * @param value từ cần tìm
     * @return null nếu từ cần tìm không hợp lệ hoặc không tìm thấy từ
     */
    public Word search (String value) {
        try {
            return searchNode(this.root, new Word(value, "")
            );
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * @param currentNode Node hiện tại
     * @param data từ cần tìm
     * @return null nếu không tìm thấy, ngược lại trả về từ cần tìm
     */
    private Word searchNode (AVLNode currentNode, Word data) {
        while (currentNode != null) {
            if (currentNode.isGreaterThan(data.getValue(), currentNode.getData().getValue()))
                return searchNode(currentNode.getRight(), data);
            else if (currentNode.isLessThan(data.getValue(), currentNode.getData().getValue()))
                return searchNode(currentNode.getLeft(), data);
            else return currentNode.getData();
        }
        return null;
    }

    public void print() {
        getSortedNode(this.root);
    }

    public void getSortedNode(AVLNode currentNode) {
        if (currentNode == null)
            return;
        getSortedNode(currentNode.getLeft());
        System.out.print(currentNode.getData());
        getSortedNode(currentNode.getRight());
    }
    public void load (String url) throws Exception {
        loadDictFromFile(url);
    }
    private void loadDictFromFile (String url) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(url);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String reader = bufferedReader.readLine();
        while (reader != null) {
            String[] tmpString = reader.toString().split("\\|");
            String value = tmpString[0].replaceAll("@", "");
            String definition = tmpString[1];
           add(value, definition);
            reader = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileInputStream.close();
    }
}
