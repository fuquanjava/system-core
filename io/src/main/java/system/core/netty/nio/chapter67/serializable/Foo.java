package system.core.netty.nio.chapter67.serializable;

import io.netty.handler.codec.serialization.ObjectEncoder;

import java.io.Serializable;

/**
 * fuquanemail@gmail.com 2016/6/7 16:36
 * description:
 * 1.0.0
 */
public class Foo implements Serializable {

    private int id;

    private String name;

    public Foo buildId(int id) {
        this.id = id;
        return this;
    }

    public Foo buildName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
