package cz.matejkripner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Matìj Kripner <kripnermatej@gmail.com>
 * @version 1.0
 */
public class ContainerTest {

    public Container toTest;

    @Before
    public void prepare() {
        toTest = new Container("");
    }

    @Test
    public void testShortValueSetting() {
        // generate String of acceptable length for the container
        String expected = ofSpecificLength(Container.MAX_VALUE_LENGTH);
        toTest.setValue(expected);
        assertEquals("Container hasn't set the short string properly", expected, toTest.getValue());
    }

    @Test
    public void testLongValueSetting() {
        // generate String of not acceptable length for the container
        String value = ofSpecificLength(Container.MAX_VALUE_LENGTH + 1);
        toTest.setValue(value);
        String expected = value.substring(0, Container.MAX_VALUE_LENGTH - 3) + "...";
        assertEquals("Container hasn't set the long string properly", expected, toTest.getValue());
    }


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testNullSetting() {
        exception.expect(IllegalArgumentException.class);
        toTest.setValue(null);
    }

    private String ofSpecificLength(int length) {
        return Stream.generate(() -> String.valueOf('x')).limit(length).collect(Collectors.joining());
    }
}