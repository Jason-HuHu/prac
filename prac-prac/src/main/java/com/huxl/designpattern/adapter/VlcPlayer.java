package com.huxl.designpattern.adapter;

/**
 * @author huxl
 * @createDate 2018/3/16 10:24
 */
public class VlcPlayer implements IAdvanceMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        //do nothing...
    }

    @Override
    public void playVlc(String fileName) {
        System.out.println("play vlc file.name" + fileName);
    }
}
