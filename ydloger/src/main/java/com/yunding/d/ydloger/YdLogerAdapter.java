package com.yunding.d.ydloger;

import android.support.annotation.NonNull;

import com.yunding.d.ydloger.interfaces.IYdLoger;


public class YdLogerAdapter {
    static volatile YdLogerAdapter singleton = null;

    private IYdLoger mIYdLogerImpl;

    private YdLogerAdapter(Builder builder) {
        mIYdLogerImpl = builder.mIYdLogerImpl;
    }

    public IYdLoger getLogger() {
        return mIYdLogerImpl;
    }

    public static void config(@NonNull Builder builder) {
        if (singleton == null) {
            synchronized (YdLogerAdapter.class) {
                if (singleton == null) {
                    singleton = builder.build();
                }
            }
        }
    }

    public static final class Builder {
        private IYdLoger mIYdLogerImpl;

        public Builder() { }

        public Builder setLoger(IYdLoger loger) {
            mIYdLogerImpl = loger;
            return this;
        }

        public YdLogerAdapter build() {
            return new YdLogerAdapter(this);
        }
    }
}
