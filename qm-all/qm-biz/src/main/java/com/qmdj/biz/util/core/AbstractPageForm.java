package com.qmdj.biz.util.core;

import java.io.Serializable;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import com.github.pagehelper.PageHelper;

/**
 * @Class AbstractPageForm
 * @Description 分页表单抽象基类
 * @Author xw
 * @Date 2016年10月18日16:07:26
 * @param <T>
 */
public abstract class AbstractPageForm<T extends AbstractPageForm<T>> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @Description 页码为首页
	 */
	@DefaultValue("1")
	@QueryParam("pageNum")
	protected int pageNum = 1;
	/**
	 * @Description 每页显示数量，默认为10
	 */
	@DefaultValue("10")
	@QueryParam("pageSize")
	protected int pageSize = 10;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @Title enablePaging
	 * @Description 启用分页
	 * @Author xw
	 * @Date 2016年10月18日16:18:24
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final T enablePaging() {
		PageHelper.startPage(pageNum, pageSize);
		return (T) this;
	}

	/**
	 * @Description 日期转换格式
	 */
	private static final String[] PATTERNS = { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd" };

	/**
	 * @Title parseDate
	 * @Description 将表单字符串转换为日期格式
	 * @Author xw
	 * @Date 2016年10月18日16:19:07
	 * @param date
	 * @return
	 */
//	protected static Date parseDate(String date) {
//		try {
//			if (StringUtils.isNotBlank(date))
//				return DateUtils.parseDate(date, PATTERNS);
//			return null;
//		} catch (Exception e) {
//			throw new BusinessException(ErrorCode.ERROR_PARAMETER_ERROR);
//		}
//	}
}
