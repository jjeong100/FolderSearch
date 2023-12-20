package org.rnt.batch.service;

import javax.annotation.Resource;

import org.rnt.batch.common.vo.RtnVO;
import org.rnt.batch.dao.FileSearchDao;
import org.rnt.batch.vo.FileSearchVO;
import org.rnt.com.service.BaseService;
import org.springframework.stereotype.Service;

@Service("fileSearchService")
public class FileSearchServiceImpl extends BaseService implements FileSearchService {
    
    @Resource(name="fileSearchDao")
    private FileSearchDao fileSearchDao;
    
//    @Override
//    public RtnVO insertBogie(MPL002VO param) {
//        RtnVO rtn = new RtnVO();
//        try {
//            rtn = plcDataDao.insertBogie(param);
//        } catch (Exception e) {
//            setRtnVO(rtn, null, e.getMessage());
//        }
//        return rtn;
//    }
//
//    @Override
//    public RtnVO selectBogieCheckPos(MPL002VO param) {
//        RtnVO rtn = new RtnVO();
//        try {
//            rtn = plcDataDao.selectBogieCheckPos(param);
//        } catch (Exception e) {
//            setRtnVO(rtn, null, e.getMessage());
//        }
//        return rtn;
//    }
//    
//    @Override
//    public RtnVO insertChromate(MPL003VO param) {
//        RtnVO rtn = new RtnVO();
//        try {
//            rtn = plcDataDao.insertChromate(param);
//        } catch (Exception e) {
//            setRtnVO(rtn, null, e.getMessage());
//        }
//        return rtn;
//    }
//    
//    @Override
//    public RtnVO selectEffluent(MPL001VO param) {
//        RtnVO rtn = new RtnVO();
//        try {
//            rtn = plcDataDao.selectEffluent(param);
//        } catch (Exception e) {
//            setRtnVO(rtn, null, e.getMessage());
//        }
//        return rtn;
//    }
//    
//    @Override
//    public RtnVO insertEffluent(MPL001VO param) {
//        RtnVO rtn = new RtnVO();
//        try {
//            rtn = plcDataDao.insertEffluent(param);
//        } catch (Exception e) {
//            setRtnVO(rtn, null, e.getMessage());
//        }
//        return rtn;
//    }
//    
    @Override
    public RtnVO searchFileStatus(FileSearchVO param) {
        RtnVO rtn = new RtnVO();
        try {
            rtn = fileSearchDao.searchFileStatus(param);
        } catch (Exception e) {
            setRtnVO(rtn, null, e.getMessage());
        }
        return rtn;
    }
    
    @Override
    public RtnVO insertFileInfo(FileSearchVO param) {
        RtnVO rtn = new RtnVO();
        try {
            rtn = fileSearchDao.insertFileInfo(param);
        } catch (Exception e) {
            setRtnVO(rtn, null, e.getMessage());
        }
        return rtn;
    }
    
}
