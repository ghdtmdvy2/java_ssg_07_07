import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Apptest {
    @Test
    public void 테스트실험(){
        int rs = 30;
        assertEquals(30,rs);
    }
    @Test
    public void 테스트_스캐너(){
        String input = """
                등록
                명언1
                작가1
                """.stripIndent();
        InputStream in= new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);
        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();
        assertEquals("등록",cmd);
        assertEquals("명언1",content);
        assertEquals("작가1",author);
    }
    @Test
    public void 표준출력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {
        // 표준 출력을 리다이렉션
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.out.println("안녕");

        String rs = output.toString().trim();

        // 표준 출력을 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();
        assertEquals("안녕",rs);
    }
}