package file;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class ReadFile {

    public static void main(String[] args) throws Exception {
        List<String> one = readFile2List("/Users/libai/Desktop/indicator.txt", true);
        List<String> same = readFile2List("/Users/libai/Desktop/samename.txt", false);
        printSql(one);

        different(one, same);

        //printSql(one);
    }

    public static List<String> readFile2List(String path, boolean format) throws Exception {
        List<String> list = Lists.newArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        while (line != null) {
            if (line.contains("/")) {
                line = line.split("/")[0];
            }
            if (format) {
                list.add(String.format("\"%s\"", line));

            } else {
                list.add(line);
            }

            line = reader.readLine();
        }
        System.out.println("total:::" + list.size());
        return list;
    }

    public static void printSame(List<String> list) {

    }

    public static void printSql(List<String> list) {
        String sql = "select id, name_en, name from beidou_indicaotr_item where name_en NOT in (";

        String con = Joiner.on(",").skipNulls().join(list.iterator());

        System.out.println(sql + con + ");");
    }

    public static void different(List<String> the, List<String> other){
        List<String> different = Lists.newArrayList();
        the.forEach(t->{
            boolean isDiff = true;
            for(String o : other){
                if(t.equals(o)){
                    isDiff = false;
                }
            }
            if(isDiff){
                different.add(t);
            }
        });

        System.out.println("不同的："+different);
        System.out.println("相同的："+ other);
        System.out.println("全部的："+ the);
        System.out.println("different size:::"+ different.size());
        System.out.println("the size:::"+ the.size());
        System.out.println("other size:::"+ other.size());

    }
}
