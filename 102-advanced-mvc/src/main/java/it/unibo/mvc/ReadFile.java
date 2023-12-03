package it.unibo.mvc;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class ReadFile {
    public static final String SEP = File.separator;
    private static final String PATH = System.getProperty("user.dir") + 
        SEP + "src" + SEP + "main" + SEP + "resources";
    private static File file;

    public static Map<String,Integer> read(final String fileName) throws FileNotFoundException, IOException {
        Map<String,Integer> map = new HashMap<>();
        file = new File(PATH + SEP + fileName);
        try (final BufferedReader r = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = r.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line,":");
                map.put(st.nextToken(),ReadFile.getParam(line)); 
            }
        }
        return map;
    }

    private static Integer getParam(final String param){    
        final String[] result = param.split(": ");
        return Integer.parseInt(result[result.length-1]);
    }
}
