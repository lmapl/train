package com.train.service;


import java.math.BigDecimal;

public class Constant {
	// 测试日志打印开关,该开关通过控制台控制
	public static boolean	testLog					= false;

	public static String	SYSTEM_NAME				= "dsa";
	public static String	SYSTEM_DOMAIN			= SYSTEM_NAME + ".biyao.com";

	public static Integer SYS_CALLER = 8;

	// redis前缀
	public static String	REDIS_PREFIX			= SYSTEM_NAME + ":";
	// redis 分隔符
	public static String REDIS_SEPARATOR = "|";
	// redis 分隔符-解析
	public static String REDIS_ANALYSIS_SEPARATOR = "\\|";

	// 时间常量
	public static final int	DAY_SECONDS				= 3600 * 24;
	public static final int	WEEK_SECONDS			= DAY_SECONDS * 7;
	public static final int	MONTH_SECONDS			= DAY_SECONDS * 30;
	public static final int	DAY_3_SECONDS			= DAY_SECONDS * 3;
	public static final int	DAY_7_SECONDS			= WEEK_SECONDS;
	public static final int	DAY_15_SECONDS			= DAY_SECONDS * 15;
	public static final int	DAY_2_SECONDS			= DAY_SECONDS * 2;

	public static final int	SECONDS_10				= 10;
	public static final int	MINUTES_SECONDS			= 60;
	public static final int	MINUTES_5_SECONDS		= MINUTES_SECONDS * 5;
	public static final int	MINUTES_10_SECONDS		= MINUTES_SECONDS * 10;
	public static final int	MINUTES_30_SECONDS		= MINUTES_SECONDS * 30;
	public static final int	SECOND_MILLISECOND		= 1000;
	public static final int	YEAR_DAYS				= 365;
	public static final int	ONE_HOUR_SECONDS		= MINUTES_SECONDS * 60;

	public static final int	SIZE = 500;

	/**
	 * 签到周期
	 */
	public static final int	CYCLE_DAY = 7;


	/**
	 * 默认兑换汇率，特权金：金币 = 1：n
	 */
	public static final int DEFAULT_EXCHANGE_RATE = 100;

	/**
	 * 兑换汇率CMS素材ID
	 */
	public static final long MATERIAL_ID_EXCHANGE_RATE = 10290406L;

	/**
	 * 本人(素材编号：10290202)
	 */
	public static final long  ONESELF_ID = 10290202;

	/**
	 * 非本人(素材编号：10290203)
	 */
	public static final long	HELP_ID = 10290203;

	/**
	 * 可能收益倍速
	 */
	public static final BigDecimal POSSIBLERATIO = new BigDecimal("1.2");
	/**
	 * 默认收益倍速
	 */
	public static final BigDecimal DEFAULTRATIO = new BigDecimal("1.0");

}
