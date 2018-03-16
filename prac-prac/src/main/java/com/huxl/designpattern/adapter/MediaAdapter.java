package com.huxl.designpattern.adapter;

/**
 * @author huxl
 * @createDate 2018/3/16 10:27
 */
public class MediaAdapter implements IMediaPlayer {
    private IAdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer = new Mp4Player();
        }
    }
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advanceMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer.playMp4(fileName);
        }

    }
}
