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
    public void mainメソッドを実行() throws JsonProcessingException {
        // main()メソッドを実行
        Main.main(new String[]{});

        // 標準出力の内容を取得
        System.out.flush();
        final String actual = byteArrayOutputStream.toString();

        // 期待値を設定
        final String expected = "{\"id\":10,\"name\":\"hoge\"}" + System.lineSeparator();

        assertThat(actual, is(expected));
    }

    @After
    public void tearDown() {
        System.setOut(defaultPrintStream);
    }
}
