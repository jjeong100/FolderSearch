package org.rnt.batch.common.dao;

import org.rnt.batch.common.vo.RtnVO;
import org.rnt.com.GlvConst;
import org.rnt.com.util.StrUtil;

public class BaseDao {
    public RtnVO setRtnVO(RtnVO rtnVO, String msg, String exceptionMsg) {
        rtnVO.setRc(GlvConst.RC_ERROR);
        rtnVO.setMsg(msg);
        if (!StrUtil.isNull(exceptionMsg)) {
        	rtnVO.setExceptionMsg(StrUtil.getLastAfterStr(exceptionMsg.replaceAll("\"", ""),"Cause"));
        }
        rtnVO.setExceptionClassName((new Throwable()).getStackTrace()[1].getClassName());
        rtnVO.setExceptionMethodName((new Throwable()).getStackTrace()[1].getMethodName());
        rtnVO.setExceptionLine((new Throwable()).getStackTrace()[1].getLineNumber());
        
        /**Debug stackTrace **/
//        System.out.println("■■■■ err message : "+exceptionMsg);
        return rtnVO;
    }
}
