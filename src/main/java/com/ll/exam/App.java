package com.ll.exam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() throws Exception {
        OutputStream output = new FileOutputStream("C:\\Users\\ghdtm\\IdeaProjects\\java_ssg_07_07\\output.txt");
        String str;
        byte[] by;
        System.out.println("== 명언 SSG ==");
        int i = 0;
        Scanner sc = new Scanner(System.in);

        wiseSaying ws = new wiseSaying();
        List<wiseSaying> datalist = new ArrayList<>();
        int cnt = 1;
        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            String s[] = cmd.split("=");
            cmd = s[0];
            switch (cmd) {
                case "종료":
                    break outer;
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    wiseSaying ts = new wiseSaying(cnt,content,author);
                    String data = ts.toString();
                    datalist.add(ts);
                    by = data.getBytes();
                    output.write(by);
                    System.out.println(cnt+"번 명언이 등록 되었습니다.");
                    cnt++;
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for(i = datalist.size()-1; i>=0; i--){
                        System.out.println(datalist.get(i).fileString());
                    }
                    break;
                case "삭제?id":
                    try {
                        if(datalist.get(0).getId() == Integer.parseInt(s[1])){
                            System.out.println(s[1]+"번 명언이 삭제되었습니다.");
                            datalist.remove(datalist.get(0).getId() - 1);
                        }
                        else{
                            System.out.println(s[1]+"번 명언은 존재하지 않습니다.");
                        }
                    }
                    catch(Exception e){
                        System.out.println("1번 명언은 존재하지 않습니다.");
                    }
                    break;
            }
        }

        sc.close();
    }
}