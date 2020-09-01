package com.zkq.utils;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 15:15 2020/7/13
 */
public class PageableRestResult<T> extends RestResult{
    private int totalPages = 1;
    private long totalCount = 0L;

    public PageableRestResult() {
    }

    public PageableRestResult(int code, String message, T data, int totalPages, long totalCount) {
        super(code, message, data);
        this.totalPages = totalPages;
        this.totalCount = totalCount;
    }

    public PageableRestResult(int code, String message) {
        super(code, message);
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public static <T> PageableRestResult<T> success(T data, int totalPages, long totalCount) {
        return new PageableRestResult(0, "操作成功", data, totalPages, totalCount);
    }

    public static PageableRestResult error(int code, String message) {
        return new PageableRestResult(code, message);
    }
}
