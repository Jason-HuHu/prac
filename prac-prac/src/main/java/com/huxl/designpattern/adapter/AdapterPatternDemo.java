package com.huxl.designpattern.adapter;

/**
 * 使用AudioPlayer 来播放不同音频格式的音频
 *
 * 适配器模式
 *  适配器模式是作为两个不相干接口之间的桥梁，结合了两个独立接口的功能
 *  这种模式涉及到一个单一的类，该类负责加入独立的或者不兼容的接口的功能。
 *  在该音频播放器的示例中，IMediaPlayer 和IAdvanceMediaPlayer是两个不相干的接口
 *
 *  其中IMediaPlayer 中有一个play()方法 IAdvanceMediaPlayer中有playMp4() 和 playvlc(方法)
 *
 *  现在有一个IMediaPlyer 的实现类具有播放其他音频的能力（本来只有MP3的能力），那么我们可以借助一个适配器类，MediaAdapter
 *  实现IMediaplayer接口，在其中实现播放其他音频的功能，这样就能直接在AudiaPlayer中使用适配器播放其他音频格式的内容了。
 *
 * @author huxl
 * @createDate 2018/3/16 10:52
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        //音频播放器
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3","mp3.mp3");
        audioPlayer.play("mp4","mp4.mp4");
        audioPlayer.play("vlc","vlc.vlc");
        audioPlayer.play("mpf","aaa.mpf");
    }
}
