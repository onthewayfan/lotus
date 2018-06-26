package com.lotus.designpatterns.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

/**
 * 策略实现方式 - 2
 * @author otw
 *
 */
public class ZipCompressStrategy implements CompressionStrategy {

	@Override
	public OutputStream compress(OutputStream data) throws IOException {
		return new ZipOutputStream(data);
	}

}
