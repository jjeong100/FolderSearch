package org.rnt.batch.dao;

import org.apache.ibatis.session.SqlSession;
import org.rnt.batch.common.dao.BaseDao;
import org.rnt.batch.common.vo.RtnVO;
import org.rnt.batch.vo.FileSearchVO;
import org.rnt.com.GlvConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("fileSearchDao")
public class FileSearchDao extends BaseDao {
    public final String ENTITY_NAME = "file_search";
    
    @Autowired
    private SqlSession sqlSession;
    
//    public RtnVO insertBogie(MPL002VO param) {
//		RtnVO rtn = new RtnVO();
//		try {
//			sqlSession.insert(ENTITY_NAME+".insertBogie", param);
//		} catch (Exception e) {
//			return setRtnVO(rtn, ENTITY_NAME+GlvConst.STR_SPACE+GlvConst.RC_DB_CRE_ERR_MSG, e.getMessage()); 
//		}
//		 return rtn;
//	}
//    
//    public RtnVO selectBogieCheckPos(MPL002VO param) {
//		RtnVO rtn = new RtnVO();
//		try {
//			String str = sqlSession.selectOne(ENTITY_NAME+".selectBogieCheckPos", param);
//			rtn.setObj(str);
//		} catch (Exception e) {
//			return setRtnVO(rtn, ENTITY_NAME+GlvConst.STR_SPACE+GlvConst.RC_DB_SEL_ERR_MSG, e.getMessage()); 
//		}
//		return rtn;
//	}
//    
//    public RtnVO insertChromate(MPL003VO param) {
//		RtnVO rtn = new RtnVO();
//		try {
//			sqlSession.insert(ENTITY_NAME+".insertChromate", param);
//		} catch (Exception e) {
//			return setRtnVO(rtn, ENTITY_NAME+GlvConst.STR_SPACE+GlvConst.RC_DB_CRE_ERR_MSG, e.getMessage()); 
//		}
//		 return rtn;
//	}
//    
//    public RtnVO insertEffluent(MPL001VO param) {
//		RtnVO rtn = new RtnVO();
//		try {
//			sqlSession.insert(ENTITY_NAME+".insertEffluent", param);
//		} catch (Exception e) {
//			return setRtnVO(rtn, ENTITY_NAME+GlvConst.STR_SPACE+GlvConst.RC_DB_CRE_ERR_MSG, e.getMessage()); 
//		}
//		 return rtn;
//	}
	
    public RtnVO searchFileStatus(FileSearchVO param) {
		RtnVO rtn = new RtnVO();
		try {
			Integer cnt = sqlSession.selectOne(ENTITY_NAME+".searchFileStatus", param);
			rtn.setObj(cnt);
		} catch (Exception e) {
			return setRtnVO(rtn, ENTITY_NAME+GlvConst.STR_SPACE+GlvConst.RC_DB_SEL_ERR_MSG, e.getMessage()); 
		}
		return rtn;
	}
    
    public RtnVO insertFileInfo(FileSearchVO param) {
		RtnVO rtn = new RtnVO();
		try {
			sqlSession.insert(ENTITY_NAME+".insertFileInfo", param);
		} catch (Exception e) {
			return setRtnVO(rtn, ENTITY_NAME+GlvConst.STR_SPACE+GlvConst.RC_DB_CRE_ERR_MSG, e.getMessage()); 
		}
		 return rtn;
	}
//    
}
