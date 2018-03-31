package com.keji.washer.common.utils;

/**
 * 一个一直执行的 线程
 * @author Ice_Dog
 */
public class CheckOrder extends Thread{
	private final static Long FIVE_MIN = 5*60*1000L;
	public CheckOrder() {
		this.start();
	}

	@Override
	public void run() {
		super.run();
		while (true){
			try {
				sleep(FIVE_MIN);
				//检查是否有超时订单
			} catch (InterruptedException e) {
				e.printStackTrace();
				this.start();
			}
		}
	}
}
