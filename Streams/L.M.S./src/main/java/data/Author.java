package data;


public record Author(String name, String nationality, String birthday) {
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
