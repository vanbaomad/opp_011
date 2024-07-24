package constant;

public enum LoaiKH {
    CN("Ca nhan"),
    TT("Tap the"),
    DN("Doanh nghiep");
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    LoaiKH(String value) {
        this.value = value;
    }
}
