public class AVLNode {
    private Word data;
    private int height;
    private AVLNode left;
    private AVLNode right;

    /**
     * @param data Từ và nghĩa
     */
    public AVLNode(Word data) {
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

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
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