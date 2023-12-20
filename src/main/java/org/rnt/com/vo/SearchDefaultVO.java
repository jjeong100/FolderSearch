package org.rnt.com.vo;

import java.io.Serializable;

import org.rnt.com.util.DateUtil;


public class SearchDefaultVO implements Serializable {

    private static final long serialVersionUID = 5052775954515811258L;

    private String toDay = DateUtil.formatCurrent("yyyy/MM/dd");
    
    /** tabs Active Index **/
    private String activeIndex = "0";
    
    /** check Index **/
    private String checkIndex = "0";
    

    public String getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(String activeIndex) {
		this.activeIndex = activeIndex;
	}

	public String getCheckIndex() {
		return checkIndex;
	}

	public void setCheckIndex(String checkIndex) {
		this.checkIndex = checkIndex;
	}

	public String getToDay() {
        return toDay;
    }

    public void setToDay(String toDay) {
        this.toDay = toDay;
    }

}