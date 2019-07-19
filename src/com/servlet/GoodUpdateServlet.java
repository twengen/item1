package com.servlet;

import com.dao.GoodsDao;
import com.entity.Goods;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GoodUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Goods goods = new Goods();
        GoodsDao gd = new GoodsDao();
        if (ServletFileUpload.isMultipartContent(req)) {
            ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> fileItemList = null;
            try {
                fileItemList = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            int i=0;
            for (FileItem fileItem : fileItemList) {
                if (fileItem.isFormField()) {
                    if ("pics".equals(fileItem.getFieldName())) {
                        while (i==0){
                        goods.setPic(fileItem.getString());}
                    }
                    else if ("name".equals(fileItem.getFieldName())) {
                        goods.setName(fileItem.getString("utf-8"));
                    } else if ("description".equals(fileItem.getFieldName())) {
                        goods.setDescription(fileItem.getString("utf-8"));
                    } else if ("price".equals(fileItem.getFieldName())) {
                        goods.setPrice(Float.valueOf(fileItem.getString()));
                    } else if ("stock".equals(fileItem.getFieldName())) {
                        goods.setStock(Integer.parseInt(fileItem.getString()));
                    } else if ("goodsId".equals(fileItem.getFieldName())) {
                        goods.setId(Integer.parseInt(fileItem.getString()));
                    }
                } else {
                    System.out.println("!!!!!!!启动了备用方法！！！！");
                    String fileName = fileItem.getName();
                    if (fileName != null && fileName != "") {
                        String parentPath = req.getServletContext().getRealPath("/upload");
                        File parentFile = new File(parentPath);
                        File newFile = new File(parentFile, fileName);
                        InputStream is = fileItem.getInputStream();
                        OutputStream os = new FileOutputStream(newFile);
                        IOUtils.copy(is, os);
                        os.close();
                        is.close();
                        goods.setPic(fileName);
                        i++;
                    }
                }
            }
            gd.updateGoods(goods);
        }
        out.println("<script type='text/javascript'>alert('修改商品成功！');location.href='showallgoods';</script>");
    }
}
