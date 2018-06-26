package com.lotus.designpatterns.strategy;

import java.io.IOException;
import java.io.OutputStream;
/**
 * 压缩 策略接口
 * @author otw
 *
 */
public interface CompressionStrategy {
	
	public OutputStream compress(OutputStream data) throws IOException;
	

}
