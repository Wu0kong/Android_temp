package com.example.lzp102.bean;

import java.util.List;

public class VideoBean {

    private int id;
    private String name;
    private String img;
    private String intro;
    private List<VideoDetailListDTO> videoDetailList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<VideoDetailListDTO> getVideoDetailList() {
        return videoDetailList;
    }

    public void setVideoDetailList(List<VideoDetailListDTO> videoDetailList) {
        this.videoDetailList = videoDetailList;
    }

    public static class VideoDetailListDTO {
        private String video_id;
        private String video_name;

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public String getVideo_name() {
            return video_name;
        }

        public void setVideo_name(String video_name) {
            this.video_name = video_name;
        }
    }
}
