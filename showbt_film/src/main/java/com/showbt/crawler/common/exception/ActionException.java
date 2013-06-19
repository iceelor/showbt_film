package com.showbt.crawler.common.exception;


import org.apache.log4j.Logger;

/**
 * Action层异常
 * @date 2011/04/07
 */
public class ActionException extends Exception {

	private static final long serialVersionUID = 105188045974566349L;
	private Logger log = null;

	public ActionException(Class<?> clazz, String message) {
		super(message);
		log = Logger.getLogger(clazz);
		log.error(message);
	}

	public ActionException(Class<?> clazz, Throwable throwable) {
		super(throwable);
		log = Logger.getLogger(clazz);
		log.error(throwable.getMessage());
	}

}
