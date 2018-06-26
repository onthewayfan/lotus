package com.lotus.designpatterns.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/**
 * 策略实现方式 - 1
 * @author otw
 *
 */
public class GzipCompressStrategy implements CompressionStrategy {

	@Override
	public OutputStream compress(OutputStream data) throws IOException {
		return new GZIPOutputStream(data);
	}

}
