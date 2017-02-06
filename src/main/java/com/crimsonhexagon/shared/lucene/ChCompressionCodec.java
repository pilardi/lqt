package com.crimsonhexagon.shared.lucene;

import org.apache.lucene.codecs.FilterCodec;
import org.apache.lucene.codecs.StoredFieldsFormat;
import org.apache.lucene.codecs.compressing.CompressingStoredFieldsFormat;
import org.apache.lucene.codecs.compressing.CompressionMode;
import org.apache.lucene.codecs.lucene50.Lucene50Codec;

/**
 * 4k chunks
 */
public class ChCompressionCodec extends FilterCodec {
    public ChCompressionCodec() {
        super("ChCompressionCodec", new Lucene50Codec());
    }

    @Override
    public StoredFieldsFormat storedFieldsFormat() {
        return new CompressingStoredFieldsFormat("Lucene50StoredFieldsHigh", CompressionMode.FAST_DECOMPRESSION, 1 << 12, 128, 1024);
    }
}
