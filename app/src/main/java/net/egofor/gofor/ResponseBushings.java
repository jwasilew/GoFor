package net.egofor.gofor;

import android.util.Log;

import java.util.List;

/**
 * Created by T510 Owner on 5/27/2016.
 */
public class ResponseBushings {


    /**
     * FIELD1 : _upc
     * FIELD2 : _short_description
     * FIELD3 : _mfg
     * FIELD4 : _mfg_part_number
     * FIELD5 : _bushing_type
     * FIELD6 : _insulated
     * FIELD7 : _material
     * FIELD8 : _trade_size
     * FIELD9 : _height
     * FIELD10 : _thread_length
     * FIELD11 : _diameter
     * FIELD12 : _temerature_rating
     * FIELD13 : _application
     * FIELD14 : _installation
     * FIELD15 : _wire_size
     * FIELD16 : _lug
     * FIELD17 : _conductor_material
     * FIELD18 : _thumbnail
     */




    private List<materialEntity> results;

    public List<materialEntity> getResults() {
        return results;
    }


    public static class materialEntity {

        private String FIELD1;
        private String FIELD2;
        private String FIELD3;
        private String FIELD4;
        private String FIELD5;
        private String FIELD6;
        private String FIELD7;
        private String FIELD8;
        private String FIELD9;
        private String FIELD10;
        private String FIELD11;
        private String FIELD12;
        private String FIELD13;
        private String FIELD14;
        private String FIELD15;
        private String FIELD16;
        private String FIELD17;
        private String FIELD18;

        public String getFIELD1() {
            return FIELD1;
        }

        public void setFIELD1(String FIELD1) {
            this.FIELD1 = FIELD1;
        }

        public String getFIELD2() {
            return FIELD2;
        }

        public void setFIELD2(String FIELD2) {
            this.FIELD2 = FIELD2;
        }

        public String getFIELD3() {
            return FIELD3;
        }

        public void setFIELD3(String FIELD3) {
            this.FIELD3 = FIELD3;
        }

        public String getFIELD4() {
            return FIELD4;
        }

        public void setFIELD4(String FIELD4) {
            this.FIELD4 = FIELD4;
        }

        public String getFIELD5() {
            return FIELD5;
        }

        public void setFIELD5(String FIELD5) {
            this.FIELD5 = FIELD5;
        }

        public String getFIELD6() {
            return FIELD6;
        }

        public void setFIELD6(String FIELD6) {
            this.FIELD6 = FIELD6;
        }

        public String getFIELD7() {
            return FIELD7;
        }

        public void setFIELD7(String FIELD7) {
            this.FIELD7 = FIELD7;
        }

        public String getFIELD8() {
            return FIELD8;
        }

        public void setFIELD8(String FIELD8) {
            this.FIELD8 = FIELD8;
        }

        public String getFIELD9() {
            return FIELD9;
        }

        public void setFIELD9(String FIELD9) {
            this.FIELD9 = FIELD9;
        }

        public String getFIELD10() {
            return FIELD10;
        }

        public void setFIELD10(String FIELD10) {
            this.FIELD10 = FIELD10;
        }

        public String getFIELD11() {
            return FIELD11;
        }

        public void setFIELD11(String FIELD11) {
            this.FIELD11 = FIELD11;
        }

        public String getFIELD12() {
            return FIELD12;
        }

        public void setFIELD12(String FIELD12) {
            this.FIELD12 = FIELD12;
        }

        public String getFIELD13() {
            return FIELD13;
        }

        public void setFIELD13(String FIELD13) {
            this.FIELD13 = FIELD13;
        }

        public String getFIELD14() {
            return FIELD14;
        }

        public void setFIELD14(String FIELD14) {
            this.FIELD14 = FIELD14;
        }

        public String getFIELD15() {
            return FIELD15;
        }

        public void setFIELD15(String FIELD15) {
            this.FIELD15 = FIELD15;
        }

        public String getFIELD16() {
            return FIELD16;
        }

        public void setFIELD16(String FIELD16) {
            this.FIELD16 = FIELD16;
        }

        public String getFIELD17() {
            return FIELD17;
        }

        public void setFIELD17(String FIELD17) {
            this.FIELD17 = FIELD17;
        }

        public String getFIELD18() {

            final String IMAGE_BASE_PATH = "https://api.backendless.com/5FDD3FE0-9CDD-C6C4-FFD8-87B570EA4500/v1/files/media/";
            final String IMAGE_EXT = ".jpg";

            FIELD18 = IMAGE_BASE_PATH + FIELD18 + IMAGE_EXT;

            return FIELD18;
        }

        public void setFIELD18(String FIELD18) {
            this.FIELD18 = FIELD18;
        }
    }
}

