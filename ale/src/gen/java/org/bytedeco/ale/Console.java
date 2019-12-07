// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.ale;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.ale.global.ale.*;


/**
  This class represents the entire game console.
  <p>
  @author  Bradford W. Mott
  @version $Id: Console.hxx,v 1.61 2007/07/27 13:49:16 stephena Exp $
*/
@NoOffset @Properties(inherit = org.bytedeco.ale.presets.ale.class)
public class Console extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Console(Pointer p) { super(p); }

    /**
      Create a new console for emulating the specified game using the
      given game image and operating system.
      <p>
      @param osystem  The OSystem object to use
      @param cart     The cartridge to use with this console
      @param props    The properties for the cartridge  
    */

    /**
      Create a new console object by copying another one
      <p>
      @param console The object to copy
    */
    public Console(@Const @ByRef Console console) { super((Pointer)null); allocate(console); }
    private native void allocate(@Const @ByRef Console console);
 
    /**
      Destructor
    */
    /**
      Get the controller plugged into the specified jack
      <p>
      @return The specified controller
    */
    public native @ByRef Controller controller(@Cast("Controller::Jack") int jack);

    /**
      Get the MediaSource for this console
      <p>
      @return The mediasource
    */
    public native @ByRef MediaSource mediaSource();

    /**
      Get the properties being used by the game
      <p>
      @return The properties being used by the game
    */

    /**
      Get the console switches
      <p>
      @return The console switches
    */
    public native @ByRef Switches switches();

    /**
      Get the 6502 based system used by the console to emulate the game
      <p>
      @return The 6502 based system
    */
    public native @ByRef System system();

    /**
      Returns the OSystem for this emulator.
      
      @return The OSystem. 
    */
    public native @ByRef OSystem osystem();

    /**
      Get the cartridge used by the console which contains the ROM code
      <p>
      @return The cartridge for this console
    */
    public native @ByRef Cartridge cartridge();

    /**
      Get the 6532 used by the console
      <p>
      @return The 6532 for this console
    */
    public native @ByRef M6532 riot();

    /**
      Set the properties to those given
      <p>
      @param The properties to use for the current game
    */

    /**
      Query some information about this console.
    */
    public native @StdString BytePointer about();
    /**
      Overloaded assignment operator
      <p>
      @param console The console object to set myself equal to
      @return Myself after assignment has taken place
    */
    public native @ByRef @Name("operator =") Console put(@Const @ByRef Console console);
    /**
      Toggle between NTSC/PAL/PAL60 display format.
    */
    public native void toggleFormat();

    /**
      Query the currently selected display format (NTSC/PAL/PAL60).
    */
    public native @StdString BytePointer getFormat();

    /**
      Toggle between the available palettes.
    */
    public native void togglePalette();

    /**
      Toggles phosphor effect.
    */
    public native void togglePhosphor();

    /**
      Initialize the video subsystem wrt this class.
      This is required for changing window size, title, etc.
      <p>
      @param full  Whether we want a full initialization,
                   or only reset certain attributes.
    */
    public native void initializeVideo(@Cast("bool") boolean full/*=true*/);
    public native void initializeVideo();

    /**
      Initialize the audio subsystem wrt this class.
      This is required any time the sound settings change.
    */
    public native void initializeAudio();

    /**
      "Fry" the Atari (mangle memory/TIA contents)
    */
    public native void fry();

    /**
      Change the "Display.YStart" variable.
      <p>
      @param direction +1 indicates increase, -1 indicates decrease.
    */
    public native void changeYStart(int direction);

    /**
      Change the "Display.Height" variable.
      <p>
      @param direction +1 indicates increase, -1 indicates decrease.
    */
    public native void changeHeight(int direction);

    /**
      Toggles the TIA bit specified in the method name.
    */
    public native void toggleP0Bit();
    public native void toggleP1Bit();
    public native void toggleM0Bit();
    public native void toggleM1Bit();
    public native void toggleBLBit();
    public native void togglePFBit();
    public native void enableBits(@Cast("bool") boolean enable);

// #ifdef ATARIVOX_SUPPORT

}