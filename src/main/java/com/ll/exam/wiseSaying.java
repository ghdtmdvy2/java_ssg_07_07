package com.ll.exam;

public class wiseSaying {
    private int id;
    private String content;
    private String author;
    wiseSaying(){

    }
    wiseSaying(int id, String content, String author){
        this.id = id;
        this.content = content;
        this.author = author;
    }
    @Override
    public String toString() {
        return id+".json\n{\n" +
                "       id=" + id +
                ",\n     content='" + content + "\'" +
                ",\n     author='" + author + "\'" +
                "\n}\n";
    }
    public String fileString() {
        return this.id+" / " + this.author + " / " + this.content;
    }
    public String getContent(){
        return this.content;
    }
    public String getAuthors(){
        return this.author;
    }
    public int getId(){
        return this.id;
    }

}
