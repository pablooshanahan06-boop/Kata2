package software.ulpgc.domain;
public enum Gender {
    Male, Female;
    public static Gender from(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("El género no puede estar vacío");
        }
        return Gender.valueOf(s);
    }
}