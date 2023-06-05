import com.github.javafaker.Faker;

public class Test {
    public static void main(String[] args) {
        Faker randomInfo = new Faker();

        System.out.println(randomInfo.animal().name());
        System.out.println(randomInfo.name().username());

    }
}
