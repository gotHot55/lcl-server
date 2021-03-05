package com.micro.lcl.service.impl;

import com.google.zxing.WriterException;
import com.micro.lcl.service.QRService;
import com.micro.lcl.utils.QRCodeGenerator;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/2911:48
 */
@Service
public class QRServiceImpl implements QRService {
    public static final String FILE_UPLOAD_PATH = "F:\\project\\lcl-server\\knife4j\\src\\main\\resources\\";
    @Override
    public String qrCode(String contno) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
//        获取登录用户ip
        String ip = request.getRemoteAddr();
        //获取本地ip
//        String ip = request.getLocalAddr();//0:0:0:0:0:0:0:1
        int port = request.getLocalPort();
        String address = ip + ":" + port;
        String payUrl = "http://" + address + "/hello?name=" + contno;
        try {
            QRCodeGenerator.generatorQRCodeImage(payUrl, 350, 350, FILE_UPLOAD_PATH + contno + ".png");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pngAddress = "http://" + address + "/images-dev/" + contno + ".png";
        return pngAddress;
    }

}
