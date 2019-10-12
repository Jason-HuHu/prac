package com.huxl.interview.object.producerandconsumer;

public interface Storage {

    void produce(int num);

    void consume(int num);
}
