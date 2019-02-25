package com.example.mynewsapp;

import com.example.mynewsapp.model.Result;
import com.example.mynewsapp.service.MapperService;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JsonParseTest {
    @Test
    public void test() throws Exception {

        final URL resource = JsonParseTest.class.getResource("");
        final Path classPath = Paths.get(resource.toURI());
        final Path dummyDataPath = classPath.getRoot().resolveSibling(Paths.get(new File("temp").toURI()));

        final byte[] bytes = Files.readAllBytes(dummyDataPath.resolve("plainresp.json"));

        String jsonResult = new String(bytes);

        LogMeToo.debug(jsonResult);

        MapperService service = new MapperService();

        Result result = service.unmarshall(jsonResult);

        System.out.println("done");


    }
}