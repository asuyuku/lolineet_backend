package com.lolineet.standard.util;

/**
 * ExtractVideoFirstFrameUtil
 *
 * @author YUKI.N
 * @version 1.0
 * @description
 * @date 2023/1/13 1:25
 */


import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpUtil;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

/** @Author huyi @Date 2021/11/11 11:08 @Description: 提取视频第一帧 */
public class ExtractVideoFirstFrameUtil {

    /**
     * 提取主方法
     *
     * @param path MP4视频路径
     * @param tmpDir 临时目录
     * @return 视频第一帧
     * @throws Exception 异常
     */
    public static String extract(String path, String tmpDir) throws Exception {
        String mp4Path;
        if (path.startsWith("http")) {
            mp4Path = tmpDir + "/" + IdUtil.simpleUUID() + ".mp4";
            HttpUtil.downloadFile(path, mp4Path);
        } else {
            mp4Path = path;
        }
        return ffmpegExtractImage(mp4Path, tmpDir + "/" + IdUtil.simpleUUID() + ".jpg")
                .orElseThrow(() -> new Exception("提取失败"));
    }

    /**
     * 提取视频第一帧图片
     *
     * @param mp4Path 视频地址
     * @param picPath 图片地址
     * @return 提取的图片地址
     */
    public static Optional<String> ffmpegExtractImage(String mp4Path, String picPath) {
        String ffmpeg = Loader.load(org.bytedeco.ffmpeg.ffmpeg.class);

        ProcessBuilder extractBuilder =
                new ProcessBuilder(
                        ffmpeg, "-i", mp4Path, "-f", "image2", "-ss", "1","-frames:v", "25", picPath);
        try {
            extractBuilder.inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        // 返回图片文件路径
        return Optional.of(picPath);
    }

    public static String ffmpegExtractImageForVideoStream(InputStream inputStream) throws FrameGrabber.Exception {
            FFmpegFrameGrabber ff = new FFmpegFrameGrabber(inputStream);
            String fileName = null;
            ff.start();
            int ffLength = ff.getLengthInFrames();
            Frame f;
            int i = 0;
            while (i < ffLength) {
                f = ff.grabFrame();
                //截取第6帧
                if ((i > 200) && (f.image != null)) {
                    fileName=executeFrame(f);
                    break;
                }
                i++;
            }
            ff.stop();
            return fileName;
    }

    private static String executeFrame(Frame frame) {
        OutputStream output = null;
        String fileName = UUID.randomUUID().toString() + ".png";
        try {
            String imageSuffix = "jpg";
            if (null == frame || null == frame.image) {
                return null;
            }
            Java2DFrameConverter converter = new Java2DFrameConverter();
            BufferedImage bi = converter.getBufferedImage(frame);
            output = Files.newOutputStream(Paths.get(fileName));
            ImageIO.write(bi, imageSuffix, output);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }
}