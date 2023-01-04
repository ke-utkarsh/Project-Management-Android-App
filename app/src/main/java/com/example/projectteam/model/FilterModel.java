package com.example.projectteam.model;

public class FilterModel {
        private String team;
        private int imgId;
        public FilterModel(String team, int imgId) {
            this.team = team;
            this.imgId = imgId;
        }
        public String getTeam() {
            return team;
        }
        public void setTeam(String team) {
            this.team = team;
        }
        public int getImgId() {
            return imgId;
        }
        public void setImgId(int imgId) {
            this.imgId = imgId;
        }

}
