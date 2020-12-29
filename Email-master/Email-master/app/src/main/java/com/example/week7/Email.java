package com.example.week7;

public class Email {
    private String name,time,content,word;

    public  Email(String name, String time, String content){
        this.word=name.substring(0,1).toUpperCase();
        this.name=name;
        this.time=time;
        this.content=content;
    }
    public String getName(){
        return name;
    }
    public String getTime(){
        return time;
    }
    public String getContent(){
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
