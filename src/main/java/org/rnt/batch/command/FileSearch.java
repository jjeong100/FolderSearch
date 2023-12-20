package org.rnt.batch.command;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Properties;
import java.util.stream.Stream;

import org.rnt.batch.common.vo.RtnVO;
import org.rnt.batch.service.FileSearchService;
import org.rnt.batch.vo.FileSearchVO;
import org.rnt.com.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class FileSearch {
	static Properties properties = new Properties();
    private Reader properties_reader;
    
    /** service **/
    @Autowired
    private FileSearchService fileSearchService;
    
	 public FileSearch() {
       try {
           properties_reader = org.apache.ibatis.io.Resources.getResourceAsReader("config/globals.properties");
           properties.load(properties_reader);
           
           /**
            * Service 연결
            */
           fileSearchService = (FileSearchService)ApplicationContext.getBeanInstance("fileSearchService");
       }catch(Exception e) {}
   }
	 
	public static void main(String[] args) {
        final String className = new Object(){}.getClass().getEnclosingClass().getName();
        System.out.println("------------------------------ "+className+" ------------------- St.");
        
        String sourceFolderPath = "D:\\cdpp-app\\";
        try {
               
            FileSearch process = new FileSearch();
            process.Process(sourceFolderPath);
//            
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------ "+className+" ------------------- Ed.");
    }
   
   /**
    * select file_name , count(*) as cnt from sample.file_info
    * where status_count = 1
    * group by file_name
    * 
    * 폴더 열기
    * start explorer D:\cdpp-app\
    * 
    * 
    * 
    * select * from sample.file_info
    * where file_name in (
    * select file_name from 
    * (select file_name , count(*) as cnt from sample.file_info
    *   where status_count =  1
    *   group by file_name)
    * where cnt > 1)
    *  and status_count = 1
    */
    public void Process(String sourceFolderPath) {
        
    	RtnVO rtn = fileSearchService.searchFileStatus(new FileSearchVO());
        int status_count = (Integer)rtn.getObj();
        
        try (Stream<Path> paths = Files.walk(Paths.get(sourceFolderPath))) {
            paths
            .filter(Files::isRegularFile)//폴더 제외 파일만 가져온다.
            .forEach(path -> {
                try {
                    long bytes = Files.size(path);
                    String filePath = String.valueOf(path);
                    String[] split  = filePath.split("\\\\");
                    String file_name = split[(split.length-1)];
                    String file_path = filePath.replace(file_name, "");
                    
                    FileSearchVO vo = new FileSearchVO();
                    vo.setFileName(file_name);
                    vo.setFilePath(file_path);
                    vo.setFileSize(bytes);
                    vo.setStatusCount(status_count);
                    
                    /**
                     * 저장
                     */
                    fileSearchService.insertFileInfo(vo);
                }catch(Exception e) {
                    e.printStackTrace();
                }
            });
        } catch(Exception e) {
            //e.printStackTrace();
        }
    }
    
 // 재귀함수 
    private void ListFile( String sourceFolderPath ) { 
        File path = new File( sourceFolderPath ); 
        File[] fList = path.listFiles(); 
         
        for( int i = 0; i < fList.length; i++ ) { 
            System.out.println(checkPermission(sourceFolderPath));
            if( fList[i].isFile() ) { 
                System.out.println( fList[i].getPath() );  // 파일의 FullPath 출력 
            } 
            else if( fList[i].isDirectory() ) { 
                ListFile( fList[i].getPath() );  // 재귀함수 호출 
            } 
        } 
    }
    
    /*
     * 
     */
    public String checkPermission(String sourceFolderPath) {
        System.out.println("checkPermission");
        StringBuilder permission = new StringBuilder();
        System.out.println("checkPermission2");
        try {
            System.out.println("checkPermission3");
            File f = new File(sourceFolderPath);
            System.out.println("checkPermission4");
            if (!f.exists()) {
                System.out.println("파일이나 디렉토리가 아닙니다.");
                return null;
            }
            
    //        Integer permission = 0;
    //        permission += (f.canExecute()) ? PERMISSION_X : 0;
    //        permission += (f.canWrite()) ? PERMISSION_W : 0;
    //        permission += (f.canRead()) ? PERMISSION_R : 0;
            
            permission.append(sourceFolderPath + " => ");
            permission.append((f.canExecute()) ? "실행, " : "");
            permission.append((f.canExecute()) ? "쓰기, " : "");
            permission.append((f.canExecute()) ? "읽기" : "");
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return permission.toString();
    }
}
