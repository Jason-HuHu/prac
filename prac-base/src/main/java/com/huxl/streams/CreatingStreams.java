package com.huxl.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huxl
 * @createDate 2018/3/5 8:52
 */
public class CreatingStreams {
    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream
                .limit(SIZE + 1)
                .collect(Collectors.toList());
        System.out.print(title + ":");
        for (int i = 0; i <firstElements.size(); i++) {
            if (i > 0) {
                System.out.print(",");
            }
            if (i < SIZE) {
                System.out.print(firstElements.get(i));
            }else {
                System.out.println("...");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
//        Path path = Paths.get("F:/codeworkspace/test");
//        Files.createDirectories(path);
//        System.out.println("创建文件夹成功 path" + path.toString());

        String fileName = "F:/codeworkspace/test/stream.txt";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(fileName));
            FileChannel channel = fos.getChannel();
            String content = "你好，NIO:\r这里是为了测试Java8的新特性而做的测试，\nlet\'s go";
            ByteBuffer bf = Charset.forName("utf-8").encode(content);

            int length = 0;
            while ((length = channel.write(bf)) !=0) {
                System.out.println("写入长度：" + length);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Path path1 = Paths.get(fileName);
//        Files.createFile(path1);
//        System.out.println("创建文件成功 path" + path1.toString());




        String contents = new String(Files.readAllBytes(path1), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("\\PL+"));

        show("words",words);
         Stream<String> song = Stream.of("gently","down","the","stream");
         show("song",song);

         Stream<String> silience = Stream.empty();
         show("silence",silience);

         Stream<String> echos = Stream.generate(() -> "echos");
         show("echos",echos);

         Stream<Double> randoms = Stream.generate(Math :: random);
         show("randows",randoms);

         Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE,n -> n.add(BigInteger.ONE));
         show("integers",integers);

         Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
         show("wordsAnotheryWay",wordsAnotherWay);

         try(Stream<String> lines = Files.lines(path1,StandardCharsets.UTF_8))
         {
             show("lines",lines);
         }



    }
}
