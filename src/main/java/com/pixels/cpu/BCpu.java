package com.pixels.cpu;

import com.pixels.cpu.impl.ICpuImpl;

public class BCpu {
    public static ICpuImpl build() {
        return new ICpuImpl();
    }
}
