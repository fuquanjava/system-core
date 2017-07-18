package string;


import lombok.Data;

@Data
public class Foo {

    private String name;

    public static void main(String[] args) {
        System.out.println(new Foo());
    }
}
