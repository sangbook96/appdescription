package com.sangbook96.appdescription.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Homes implements Serializable {
    private String created_at;
    private String updated_at ;
    private int id;
    private int orientation;
    private int order;
    private String time;
    private int marketId;
    private int deviceId;
    private int mediaId;
    private Media media;

    public Homes(String created_at, String updated_at, int id, int orientation,
                 int order, String time, int marketId, int deviceId, int mediaId, Media media) {
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.id = id;
        this.orientation = orientation;
        this.order = order;
        this.time = time;
        this.marketId = marketId;
        this.deviceId = deviceId;
        this.mediaId = mediaId;
        this.media = media;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Homes{" +
                "created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", id=" + id +
                ", orientation=" + orientation +
                ", order=" + order +
                ", time='" + time + '\'' +
                ", marketId=" + marketId +
                ", deviceId=" + deviceId +
                ", mediaId=" + mediaId +
                ", media=" + media +
                '}';
    }

    public class Media implements Serializable{
        private String created_at;
        private String updated_at;
        private int id;
        private String url;
        private int type;
        private int marketId;

        public Media(String created_at, String updated_at, int id, String url, int type, int marketId) {
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.id = id;
            this.url = url;
            this.type = type;
            this.marketId = marketId;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getMarketId() {
            return marketId;
        }

        public void setMarketId(int marketId) {
            this.marketId = marketId;
        }

        @Override
        public String toString() {
            return "Media{" +
                    "created_at='" + created_at + '\'' +
                    ", updated_at='" + updated_at + '\'' +
                    ", id=" + id +
                    ", url='" + url + '\'' +
                    ", type=" + type +
                    ", marketId=" + marketId +
                    '}';
        }
    }


}
