package com.example.kareokeappstep1.audioMixer.remix;

import androidx.annotation.NonNull;

import java.nio.ShortBuffer;

public class PassThroughAudioRemixer implements AudioRemixer {

    @Override
    public void remix(@NonNull ShortBuffer inputBuffer, int inputChannelCount, @NonNull ShortBuffer outputBuffer, int outputChannelCount) {
        outputBuffer.put(inputBuffer);
    }

    @Override
    public int getRemixedSize(int inputSize, int inputChannelCount, int outputChannelCount) {
        return inputSize;
    }
}
