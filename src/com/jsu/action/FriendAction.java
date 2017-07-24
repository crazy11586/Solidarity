package com.jsu.action;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jsu.Iservice.FriendService;
import com.jsu.Iservice.UserService;
import com.jsu.po.Friends;
import com.jsu.po.Image;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FriendAction extends ActionSupport{
		
	private String _uid;
	private String _fid;
	private String _fname;
	private String group_id;
	private List list;
	
	private String pattern;
	
	

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String get_uid() {
		return _uid;
	}

	public void set_uid(String _uid) {
		this._uid = _uid;
	}

	public String get_fid() {
		return _fid;
	}

	public void set_fid(String _fid) {
		this._fid = _fid;
	}

	public String get_fname() {
		return _fname;
	}

	public void set_fname(String _fname) {
		this._fname = _fname;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}


	public String Add(){
		
		list = new ArrayList<String>();
		Friends friend = new Friends();
		friend.set_id(UUID.randomUUID().toString().replace("-", ""));
		friend.set_fname(_fname);
		friend.set_uid(_uid);
		friend.set_fid(_fid);
		friend.setGroup_id(group_id);
		
		FriendService service =(FriendService)ApplicationContextHelper.getBean("friendService");
		try {
			
			service.addFriends(friend);
			list.add("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list.add("error");
		}
		
		return SUCCESS;
			
	}
	
	public String Query() throws SQLException{
		System.out.println(FriendAction.convert(pattern));
		UserService service =(UserService)ApplicationContextHelper.getBean("userService");
		list = service.QueryUser(FriendAction.convert(pattern));
		return SUCCESS;
	}
	
	public static String convert(String str){

	       try {

	           byte[] bytes = str.getBytes("ISO-8859-1");

	           return new String(bytes,"UTF-8");

	       } catch (UnsupportedEncodingException e) {

	           e.printStackTrace();

	           return str;

	       }

	    }
	private String urlpath;
	private String result = null;
    private String fileName = null;
    private String savePath = null;
    private String image_id ;
    
 
    public String getImage_id() {
		return image_id;
	}

	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}

	public String getResult() {
        return result;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

public String uploadFile() throws Exception {
    	
        ActionContext context = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) context
                .get(ServletActionContext.HTTP_REQUEST);
        
        String realPath = ServletActionContext.getServletContext().getRealPath(
                savePath);
 
        File dir = new File(realPath);
        
        if (!dir.exists()) {
            dir.mkdirs();
        }
        
        File file = new File(dir, fileName);
        file.deleteOnExit();
        file.createNewFile();
        
        
        urlpath = realPath+File.separator+fileName;
        
        BufferedInputStream inBuff = null;
        FileOutputStream output = null;
        BufferedOutputStream outBuff = null;
        
        try {
        	
            inBuff = new BufferedInputStream(request.getInputStream());
            output = new FileOutputStream(file);
            outBuff = new BufferedOutputStream(output);
 
            byte[] b = new byte[1024 * 8];
            
            int len;
            
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
           
            outBuff.flush();
            
            Image image = new Image();
            image.setImage_id(image_id);
            image.set_uid(UUID.randomUUID().toString().replace("-",""));
            image.setImage_url("http://192.168.137.1:1314/Solidarity/upload/"+fileName);
            
            UserService userservice = (UserService) ApplicationContextHelper.getBean("userService");
            userservice.SaveImage(image);
            
            return SUCCESS;
        } finally {
            if (inBuff != null) {
                inBuff.close();
            }
            if (output != null) {
                output.close();
            }
            if (outBuff != null) {
                outBuff.close();
            }
        }
    }

	
}
