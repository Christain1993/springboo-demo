package com.example.demo.model;

import lombok.Data;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/22 14:54
 */
@Data
public class Msg {
    private String title;
    private String content;
    private String extraInfo;

    public Msg() {
    }

    public Msg(String title, String content, String extraInfo) {
        this.title = title;
        this.content = content;
        this.extraInfo = extraInfo;
    }
}
