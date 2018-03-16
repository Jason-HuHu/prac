package com.huxl.designpattern.adapter;

/**
 * 高级播放器 可以播放MP4和 VLC 格式
 * @author huxl
 * @createDate 2018/3/16 10:21
 */
public interface IAdvanceMediaPlayer {
    void playMp4(String fileName);
    void playVlc(String fileName);
}
