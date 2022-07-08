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
        int check;
        byte[] by;
        System.out.println("== 명언 SSG ==");
        Scanner sc = new Scanner(System.in);
        wiseSaying ts = null;
        wiseSaying ws = new wiseSaying();
        List<wiseSaying> datalist = new ArrayList<>();
        int cnt = 1;
        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            String s[] = cmd.split("=");
            cmd = s[0];
            check = 0;
            switch (cmd) {
                case "종료":
                    break outer;
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();
                    ts = new wiseSaying(cnt,content,author);

                    datalist.add(ts);

                    System.out.println(cnt+"번 명언이 등록 되었습니다.");
                    cnt++;
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    printlist(datalist);
                    break;
                case "삭제?id":
                    try {
//                        datalist.remove(Integer.parseInt(s[1]) - 1);

                        for(int i = 0; i<datalist.size(); i++){
                            int index = Integer.parseInt(s[1]);
                            if(datalist.get(i).getId() == index){
                                System.out.println(s[1]+"번 명언이 삭제되었습니다.");
                                datalist.remove(i);
                                check = 1;
                            }

                        }
                        if( check == 0 ){
                            System.out.println(s[1]+"번 명언은 존재하지 않습니다.");
                            check = 0;
                            break;
                        }

                    }
                    catch(Exception e){
                        System.out.println(s[1]+"번 명언은 존재하지 않습니다.");
                    }
                    break;
            }
        }
        String data = ts.toString();
        by = data.getBytes();
        output.write(by);
        sc.close();
    }

    private void printlist(List<wiseSaying> datalist) {
        for(int i = datalist.size()-1; i>=0; i--){
            System.out.println(datalist.get(i).fileString());
        }
    }
    private void printjson(List<wiseSaying> datalist) {
        for(int i = datalist.size()-1; i>=0; i--){
            System.out.println(datalist.get(i).fileString());
        }
    }
}
