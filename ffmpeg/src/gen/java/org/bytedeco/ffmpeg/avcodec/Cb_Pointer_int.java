// Targeted by JavaCPP version 1.5.2: DO NOT EDIT THIS FILE

package org.bytedeco.ffmpeg.avcodec;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.ffmpeg.avutil.*;
import static org.bytedeco.ffmpeg.global.avutil.*;
import org.bytedeco.ffmpeg.swresample.*;
import static org.bytedeco.ffmpeg.global.swresample.*;

import static org.bytedeco.ffmpeg.global.avcodec.*;

@Properties(inherit = org.bytedeco.ffmpeg.presets.avcodec.class)
public class Cb_Pointer_int extends FunctionPointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public    Cb_Pointer_int(Pointer p) { super(p); }
    protected Cb_Pointer_int() { allocate(); }
    private native void allocate();
    public native int call(@Cast("void**") @ByPtrPtr Pointer mutex, @Cast("AVLockOp") int op);
}