public class Word {
    private String value;
    private String definition = "Chưa xác định";

    public Word(String value, String definition) throws Exception {
        setValue(value);
        setDefinition(definition);
    }

    /**
     * @param string Chuỗi cần chuẩn hóa
     * @return Chuỗi đã chuẩn hóa (Xóa dấu cách trắng thừa)
     */
    public static String standardizedWord(String string) {
        string = string.trim();
        string = string.replaceAll("\\s+", " ");
        return string;
    }

    /**
     * @return từ gốc (Tiếng Anh)
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value từ gốc
     * @throws Exception Nếu từ sau khi chuẩn hóa là một chuỗi rỗng
     */
    public void setValue(String value) throws Exception {
        value = standardizedWord(value);
        if (!value.equals(""))
            this.value = value;
        else throw new Exception("Dữ liệu không hợp lệ!");
    }

    /**
     * @return nghĩa (hoặc định nghĩa) của từ, mặc định là "Chưa xác định"
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * @param definition nghĩa (hoặc định nghĩa) của từ
     */
    public void setDefinition(String definition) {
        definition = standardizedWord(definition);
        if (!definition.equals(""))
            this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return value.equals(word.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return String.format(
                """
                        Từ: %s
                        |
                        |____ Nghĩa: %s
                        """,
                value, definition
        );
    }
}