package com.huxl.designpattern.adapter;

/**
 * @author huxl
 * @createDate 2018/3/16 10:26
 */
public class Mp4Player implements IAdvanceMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("play mp4 file.name" + fileName);
    }

    @Override
    public void playVlc(String fileName) {
        // do nothing...

    }
}
