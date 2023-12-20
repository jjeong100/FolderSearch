package org.rnt.batch.service;

import org.rnt.batch.common.vo.RtnVO;
import org.rnt.batch.vo.FileSearchVO;

public interface FileSearchService {
//	public RtnVO insertBogie(MPL002VO param);
//	public RtnVO selectBogieCheckPos(MPL002VO param);
//	public RtnVO insertChromate(MPL003VO param);
//	public RtnVO insertEffluent(MPL001VO param);
//	public RtnVO selectEffluent(MPL001VO param);
	public RtnVO searchFileStatus(FileSearchVO param);
	public RtnVO insertFileInfo(FileSearchVO param);
}
