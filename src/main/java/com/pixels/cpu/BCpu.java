package com.pixels.cpu;

import com.pixels.cpu.impl.CpuImpl;

public class BCpu {
    public static CpuImpl build() {
        return new CpuImpl();
    }
}
