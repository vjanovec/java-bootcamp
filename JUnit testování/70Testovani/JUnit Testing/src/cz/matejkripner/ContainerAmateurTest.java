package cz.matejkripner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Matìj Kripner <kripnermatej@gmail.com>
 * @version 1.0
 */
public class ContainerAmateurTest {
    private Container toTest;

    private void prepare() {
        toTest = new Container("random");
    }

    public void testShortValueSetting() {
        prepare();
        // generate String of acceptable length for the container
        String value = Stream.generate(() -> String.valueOf('x')).limit(Container.MAX_VALUE_LENGTH).collect(Collectors.joining());
        toTest.setValue(value);
        System.out.println(toTest.getValue().equals(value) ? "Short value setting test passed!" : "Short value setting test failed!");
    }

    public void testLongValueSetting() {
        prepare();
        // generate String of not acceptable length for the container
        String value = Stream.generate(() -> String.valueOf('x')).limit(Container.MAX_VALUE_LENGTH + 1).collect(Collectors.joining());
        toTest.setValue(value);
        String shouldContain = value.substring(0, Container.MAX_VALUE_LENGTH - 3) + "...";
        System.out.println(toTest.getValue().equals(shouldContain) ? "Long value setting test passed!" : "Long value setting test failed!");
    }

    public void testNullSetting() {
        prepare();
        try {
            toTest.setValue(null);
            System.out.println("Null settings test failed - should throw an IllegalArgumentException!");
        } catch (IllegalArgumentException e) {
            System.out.println("Null settings test passed!");
        } catch (Throwable t) {
            System.out.println("Null settings test failed - threw another throwable!");
        }
    }

    public static void main(String[] args) {
        ContainerAmateurTest test = new ContainerAmateurTest();
        test.testShortValueSetting();
        test.testLongValueSetting();
        test.testNullSetting();
    }
}
