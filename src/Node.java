public class Node {
    private Word data;
    private int height;
    private Node left;
    private Node right;

    /**
     * @param data Từ và nghĩa
     */
    public Node(Word data) {
        setData(data);
        setHeight(1);
        setLeft(null);
        setRight(null);
    }

    public Word getData() {
        return data;
    }

    public void setData(Word data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isGreaterThan(String string, String otherString) {
        return string.compareToIgnoreCase(otherString) > 0;
    }

    public boolean isLessThan(String string, String otherString) {
        return string.compareToIgnoreCase(otherString) < 0;
    }

    public boolean isEqual(String string, String otherString) {
        return string.compareToIgnoreCase(otherString) == 0;
    }
}