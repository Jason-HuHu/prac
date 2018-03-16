package com.huxl.designpattern.adapter;

/**
 * @author huxl
 * @createDate 2018/3/16 10:19
 */
public class AudioPlayer implements IMediaPlayer {
    private MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        //内置MP3格式
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("play mp3 file. Name" + fileName);
        }

        //mediaAdapter 提供了播放其他文件格式的支持
         else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        } else {
            System.out.println("Invalid media." + audioType + "format not supported");
        }
    }
}
