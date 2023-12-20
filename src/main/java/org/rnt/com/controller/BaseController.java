package org.rnt.com.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rnt.batch.common.vo.RtnVO;
import org.rnt.com.GlvConst;

public class BaseController {
    protected Log log = LogFactory.getLog(this.getClass());
    
//    @Resource(name="proPertyService")
//    private ProPertyService proPertyService;
    
    public RtnVO setRtnVO(RtnVO rtnVO, String msg, String exceptionMsg) {
        rtnVO.setRc(GlvConst.RC_ERROR);
        rtnVO.setMsg(msg);
        rtnVO.setExceptionMsg(exceptionMsg);
        rtnVO.setExceptionClassName((new Throwable()).getStackTrace()[1].getClassName());
        rtnVO.setExceptionMethodName((new Throwable()).getStackTrace()[1].getMethodName());
        rtnVO.setExceptionLine((new Throwable()).getStackTrace()[1].getLineNumber());
        return rtnVO;
    }
    
}
