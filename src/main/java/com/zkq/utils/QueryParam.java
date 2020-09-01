package com.zkq.utils;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 15:13 2020/7/13
 */
public class QueryParam implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final int MAX_PAGE_SIZE = 100;
    private int pageNum = 0;
    private int pageSize = 10;

    public QueryParam() {
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
