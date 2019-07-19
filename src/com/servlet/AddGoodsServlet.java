package com.servlet;

import com.dao.GoodsDao;
import com.entity.Goods;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Goods goods = new Goods();
        GoodsDao gd = new GoodsDao();
        // 1、判断当前表单是否为上传表单
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if(isMultipart){
            // 上传表单：表示是enctype:multipart/form-data
            // 2、如果是上传表单
            //   2.1 创建ServletFileUpload对象
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            //   2.2 获得上传表单里的所有控件对象
            List<FileItem> fileItemList = null;
            try {
                fileItemList = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            //   2.3 遍历
            if(fileItemList!=null && fileItemList.size()>0){
                for(FileItem fileItem:fileItemList){
                    //   2.4 判断控件对象是普通表单控件还是上传表单控件
                    if(fileItem.isFormField()){
                        // 普通表单：文本框、密码框等
                        // getFieldName：用于获得参数名
                        // fileItem.getString()：如果数据不带中文就用这个
                        // fileItem.getString(String charset)：如果数据中带中文的就用这个
                        if("name".equals(fileItem.getFieldName())){
                            goods.setName(fileItem.getString("utf-8"));
                        }else if("price".equals(fileItem.getFieldName())){
                            goods.setPrice(Float.parseFloat(fileItem.getString()));
                        }else if("description".equals(fileItem.getFieldName())){
                            goods.setDescription(fileItem.getString("utf-8"));
                        }else if("stock".equals(fileItem.getFieldName())){
                            goods.setStock(Integer.parseInt(fileItem.getString()));
                        }
                    }else{
                        // 上传表单控件：<input type="file">
                        // 2.4.1 获得文件名
                        String fileName = fileItem.getName();

                        // 2.4.2 将文件上传到指定的服务器目录
                        // 获得web工程在tomcat下的绝对路径
                        String parentPath = req.getServletContext().getRealPath("/upload");
                        // 判断目录是否存在，如果不存在就需要创建
                        File parentFile = new File(parentPath);
                        // parentFile.exists()：返回true表示目录存在
                        // parentFile.mkdirs()：用于创建目录
                        if(!parentFile.exists()) parentFile.mkdirs();
                        // 如果不报错，就将这个文件名设置到对象属性中
                        // 获得上传文件的文件对象
                        File newFile = new File(parentFile,fileName);
                        // 写文件
                        // 获得输入流和输出流
                        // 输入流用于读文件
                        InputStream is = fileItem.getInputStream();
                        // 输出流用于写文件
                        OutputStream os = new FileOutputStream(newFile);
                        // 写文件操作
                        IOUtils.copy(is, os);
                        // 关闭流：由内往外关
                        os.close();
                        is.close();
                        // 设置上传文件的文件名保存在对象属性中
                        goods.setPic(fileName);
                    }
                }
            }
            gd.addGoods(goods);

        }else{
            // 普通表单
        }
        out.println("<script type='text/javascript'>alert('添加商品成功！');location.href='showallgoods';</script>");
//        resp.sendRedirect("showallgoods");
    }
}
