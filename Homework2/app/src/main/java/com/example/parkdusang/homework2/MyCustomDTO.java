package com.example.parkdusang.homework2;


/**
 * Created by parkdusang on 16. 4. 8..
 */
public class MyCustomDTO {

    String title;
    String content;
    int imgIcon;

    public MyCustomDTO(String title, String content, int imgIcon) {
        //리스트뷰에 저장할 목록들을 지정하기 위해 사용했습니다.
        this.title = title;
        this.content = content;
        this.imgIcon = imgIcon;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getImgIcon() {
        return imgIcon;
    }
    public void setImgIcon(int imgIcon) {
        this.imgIcon = imgIcon;
    }
}
