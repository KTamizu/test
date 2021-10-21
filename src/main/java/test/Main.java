package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        Hoge hoge = new Hoge();
        hoge.id = 10;
        hoge.name = "hoge";

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(hoge);

        System.out.println(json);
    }
}
