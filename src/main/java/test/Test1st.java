package test;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Test1st {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }

    @Test
    public void mainMethodTest() throws JsonProcessingException {
        Main.main(new String[]{});

        System.out.flush();
        final String actual = byteArrayOutputStream.toString();

        final String expected = "{\"id\":10,\"name\":\"hoge\"}" + System.lineSeparator();

        assertThat(actual, is(expected));
    }

    @After
    public void tearDown() {
        System.setOut(defaultPrintStream);
    }
}
